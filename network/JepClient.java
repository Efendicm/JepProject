package network;
/*
    Client-side network implementation for Network Jeopardy
    Written by Derek Rodriguez
    last commit: 2/14/21
*/
import java.io.*;
import java.net.*;
import java.util.StringTokenizer;

public class JepClient implements Runnable{
    private final static boolean debug=true;
    private int sleepTime=1000;//millis
    private String ipaddress;
    private NetPlayer me;

    public JepClient(int sleepTime){
        this.sleepTime=sleepTime;
        me=new NetPlayer(getIpAddress(),0,"null",-1);
    }
    public JepClient(){
        me=new NetPlayer(getIpAddress(),0,"null",-1);
    }


    public synchronized void run(){
        try{
            while(true){
                //do the shit--probably updateScores and whatnot
                if(debug)System.out.println("run");
                Thread.sleep(sleepTime);
            }
        }catch(Exception e){
            if(debug)e.printStackTrace();
        }
    }

    public boolean joinGame(){
        if(ipaddress==null){
            if(debug)System.out.println("joingame:err:noipaddress");
            return false;
        }
        boolean out=false;
        String serverSays=sendReceive("join:"+me.getIpAddress());
        if(serverSays.startsWith("err")){
            if(debug)System.out.println(serverSays);
            return false;
        }
        int number=Integer.parseInt(serverSays);
        if(number!=-1){
            me.setNumber(number);
            out=true;
        }
        return out;
    }
    public boolean quitGame(){
        if(sendReceive("quitgame").equals("solonggaybowser"))return true;
        return false;
    }
    public int[] getScores(){
        int[] out=new int[3];
        String scores=sendReceive("getscores");
        if(scores.startsWith("err")){
            if(debug)System.out.println("getscores:"+scores);
            return out;
        }
        StringTokenizer st=new StringTokenizer(scores,",");
        for(int i=0;i<3;i++){
            out[i]=Integer.parseInt(st.nextToken());
        }
        return out;
    }
    public String[] getNames(){
        String[] out=new String[3];
        String names=sendReceive("getnames");
        if(names.startsWith("err")){
            if(debug)System.out.println("getnames:"+names);
            return out;
        }
        StringTokenizer st=new StringTokenizer(names,",");
        for(int i=0;i<3;i++){
            out[i]=st.nextToken();
        }
        return out;
    }
    public boolean setName(String name){
        if(name==null||name.trim().equals("")){
            if(debug)System.out.println("name NOT changed:invalid");
            return false;
        }
        String received=sendReceive("changename:"+name);
        if(received.equals("1")){
            me.setName(name);
            if(debug)System.out.println("name changed to:"+name);
            return true;
        }
        if(debug)System.out.println("setname:"+received);  
        return false; 
    }
    public boolean setIpAddress(String address){
        if(ValidateIPv4.isValidInet4Address(address)){
            ipaddress=address;
            if(debug)System.out.println("ipaddress changed to:"+address);
            return true;
        }else{
            if(debug)System.out.println("ipaddress NOT changed:invalid");
            return false;
        }
    }
    public boolean attemptQuestion(int x,int y){//category,difficulty -- 0 difficulty is just the category name
        if(sendReceive("buzz:"+y+":"+x).equals("goodluck"))return true;
        return false;
    }
    public String[][] getBoard(){
        int rows=Integer.parseInt(sendReceive("getboard:rows:"));//height//     since the board is never stored locally in the client,
        int columns=Integer.parseInt(sendReceive("getboard:cols:"));//width//   it must get the dimensions from the server as well as the questions
        String[][] board=new String[rows][columns];
        for(int y=0;y<rows;y++){
            for(int x=0;x<columns;x++){
                board[y][x]=sendReceive("getboard:"+y+":"+x);//y,x -- NOT x,y -- always opposite of what you think
            }
        }
        return board;
    }

    private String getIpAddress(){//based on code found at https://stackoverflow.com/questions/9481865/getting-the-ip-address-of-the-current-machine-using-java
        String out="err:";
        try(final DatagramSocket socket = new DatagramSocket()){
            socket.connect(InetAddress.getByName("8.8.8.8"), 10002);
            out=socket.getLocalAddress().getHostAddress();
        }catch(Exception e){
            out+=e.getLocalizedMessage();
        }
        return out;
    }

    private String sendReceive(String send){//actual communication w/ server
        if(debug)System.out.println("   Client:"+send);
        String receive="err:";
        try{
            Socket s=new Socket(ipaddress,80);
            BufferedReader in=new BufferedReader(new InputStreamReader(s.getInputStream()));
            BufferedWriter out=new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
            out.write(send+"\n");
            out.flush();
            receive=in.readLine();
            s.close();
        }catch(Exception e){
            receive+=e.getLocalizedMessage();
        }
        if(debug)System.out.println("Server:"+receive);
        return receive;
    }
}
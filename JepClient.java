/*
    Client-side network implementation for Network Jeopardy
    Written by Derek Rodriguez
    last commit: 2/12/21
*/
import java.io.*;
import java.net.*;
import java.util.StringTokenizer;

public class JepClient implements Runnable{
    private final static boolean debug=true;
    private int sleepTime=100;//millis
    private String ipaddress="null";
    private NetPlayer me;

    public JepClient(int sleepTime){
        this.sleepTime=sleepTime;
        me=new NetPlayer(getIpAddress(),0,"null",-1);
    }

    public synchronized void run(){
        try{
            while(true){
                //do the shit--probably updateScores and whatnot
                Thread.sleep(sleepTime);
            }
        }catch(Exception e){
            if(debug)e.printStackTrace();
        }
    }

    public boolean joinGame(){
        boolean out=false;
        int number=Integer.parseInt(sendReceive("join:"+me.getIpAddress()));
        if(number!=-1){
            me.setNumber(number);
            out=true;
        }
        return out;
    }
    public int[] getScores(){
        int[] out=new int[3];
        String scores=sendReceive("getscores");
        StringTokenizer st=new StringTokenizer(scores,",");
        for(int i=0;i<3;i++){
            out[i]=Integer.parseInt(st.nextToken());
        }
        return out;
    }
    public String[] getNames(){
        String[] out=new String[3];
        String names=sendReceive("getnames");
        StringTokenizer st=new StringTokenizer(names,",");
        for(int i=0;i<3;i++){
            out[i]=st.nextToken();
        }
        return out;
    }
    public boolean setName(String name){
        if(name==null||name.trim().equals(""))return false;
        me.setName(name);
        return true;
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
    public String[][] getBoard(){//TODO:this
        String[][] out=new String[10][10];
        return out;
    }

    private String getIpAddress(){//based on code found at https://stackoverflow.com/questions/9481865/getting-the-ip-address-of-the-current-machine-using-java
        String out="err";
        try(final DatagramSocket socket = new DatagramSocket()){
            socket.connect(InetAddress.getByName("8.8.8.8"), 10002);
            out=socket.getLocalAddress().getHostAddress();
        }catch(Exception e){
            if(debug)e.printStackTrace();
        }
        return out;
    }

    private String sendReceive(String send){//actual communication w/ server
        if(ipaddress.equals("null")&&debug)return "err:noipaddress";
        if(debug)System.out.println("   Client:"+send);
        String receive="err";
        try{
            Socket s=new Socket(ipaddress,80);
            BufferedReader in=new BufferedReader(new InputStreamReader(s.getInputStream()));
            BufferedWriter out=new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
            out.write(send+"\n");
            out.flush();
            receive=in.readLine();
            s.close();
        }catch(Exception e){
            if(debug)e.printStackTrace();
        }
        if(debug)System.out.println("Server:"+receive);
        return receive;
    }
}
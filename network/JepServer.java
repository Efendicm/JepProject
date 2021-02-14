package network;
/*
    Server-side network implementation for Network Jeopardy
    Written by Derek Rodriguez
    last commit: 2/12/21
*/
import java.io.*;
import java.net.*;
import java.util.StringTokenizer;

public class JepServer implements Runnable{
    private final static boolean debug=true;
    private ServerSocket ss;
    private Socket s;
    private NetPlayer[] players;

    public JepServer(){
        players=new NetPlayer[3];
    }

    public synchronized void run(){
        try{
            ss=new ServerSocket(80);
            while(true){
                if(debug)System.out.println("waiting for connection:");
                s=ss.accept();
                Thread clientThread=new handleRequest(s);
                clientThread.start();
            }
        }catch(Exception e){
            if(debug)e.printStackTrace();
        }
    }

    public String getIpAddress(){//based on code found at https://stackoverflow.com/questions/9481865/getting-the-ip-address-of-the-current-machine-using-java
        String out="err";
        try(final DatagramSocket socket = new DatagramSocket()){
            socket.connect(InetAddress.getByName("8.8.8.8"), 10002);
            out=socket.getLocalAddress().getHostAddress();
        }catch(Exception e){
            if(debug)e.printStackTrace();
        }
        return out;
    }
    public void setScore(int player,int score){
        if(players[2]==null){//players[2] should always be initialized last, so we don't need to make sure the other two exist
            if(debug)System.out.println("err:gamenotfull");
            return;
        }
        for(NetPlayer p:players){
            if(p.getNumber()==player){
                p.setScore(score);
                if(debug)System.out.println("player "+p.getName()+" score changed to:"+p.getScore());
                return;
            }
        }
    }
    public void setScores(int[] scores){
        if(players[2]==null){//players[2] should always be initialized last, so we don't need to make sure the other two exist
            if(debug)System.out.println("err:gamenotfull");
            return;
        }
        for(int i=0;i<3;i++){
            for(NetPlayer p:players){
                if(p.getNumber()==i){
                    p.setScore(scores[i]);
                    if(debug)System.out.println("player "+p.getName()+" score changed to:"+p.getScore());
                    continue;
                }
            }
        }
    }
    public String[] getNames(){//this is probably the slowest possible way to do this, but theres only every three players, so we good
        String[] out=new String[3];
        for(int i=0;i<3;i++){
            for(NetPlayer p:players){
                if(p.getNumber()==i){
                    out[i]=p.getName();
                    continue;
                }
            }
        }
        return out;
    }
    public int[] getScores(){//bogosort, am I right???
        int[] out=new int[3];
        for(int i=0;i<3;i++){
            for(NetPlayer p:players){
                if(p.getNumber()==i){
                    out[i]=p.getScore();
                    continue;
                }
            }
        }
        return out;
    }

    private class handleRequest extends Thread{
        Socket s;
        public handleRequest(Socket s){
            this.s=s;
        }
        public void run(){
            try{
                String connection=s.getInetAddress().toString().substring(1);
                if(debug)System.out.println("connected to:"+connection);
                BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
                String received = in.readLine();
                StringTokenizer args=new StringTokenizer(received,":");
                
                /*
                   for a full list of valid server commands, see Client Documentation.txt and Server Documentation.txt
                   or, you know, look below
                */
                if(debug)System.out.println("received:"+received);
                switch(args.nextToken()){//jeopardy protocol goes here
                    case "join":out.write(joinGame(args.nextToken()));break;
                    case "changename":out.write(changeName(connection,args.nextToken()));break;
                    case "getscores":out.write(getScores());break;
                    case "getnames":out.write(getNames());break;
                    case "getboard":break;//TODO: god i dont wanna figure this out right now
                    default:out.write("err:unknowncmd");if(debug)System.out.println("error:unknown command:"+received);break;
                }

                out.close();
                if(debug)System.out.println("closing connection");
            }catch(Exception e){
                if(debug)e.printStackTrace();
            }
        }


        private String joinGame(String ip){
            String out="-1";
            if(ValidateIPv4.isValidInet4Address(ip)){
                for(int i=0;i<3;i++){
                    if(players[i]!=null&&ip.equals(players[i].getIpAddress()))break;
                    if(players[i]==null){
                        players[i]=new NetPlayer(ip,0,"",i);
                        out=i+"";
                        break;
                    }
                }
            }
            if(debug)System.out.println("sent:"+out);
            return out;
        }
        private String getScores(){
            String out="";
            for(NetPlayer p:players){
                if(p==null){
                    out="err:gamenotfull";
                    break;
                }
                out+=","+p.getScore();
            }
            if(debug)System.out.println("sent:"+out);
            return out;
        }
        private String getNames(){
            String out="";
            for(NetPlayer p:players){
                if(p==null){
                    out="err:gamenotfull";
                    break;
                }
                out+=","+p.getName();
            }
            if(debug)System.out.println("sent:"+out);
            return out;
        }
        private String changeName(String ip,String name){
            String out="0";//trust me i'd love to use a boolean or at least an int but BuffereWriter.write() doesn't seem to share the sentiment
            for(NetPlayer p:players){
                if(p.getIpAddress().equals(ip)){
                    if(debug)System.out.println("name changed:"+p.getName()+" to "+name);
                    p.setName(name);
                    out="1";
                    break;
                }
            }
            if(debug)System.out.println("sent:"+out);
            return out;
        }
    }
}

// "We should have called it 'Trivial Pursuit.' I bet these motherfuckers would know how to spell THAT."
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
        for(NetPlayer p:players){
            if(p.getNumber()==player){
                p.setScore(score);
                return;
            }
        }
    }
    public void setScores(int[] scores){
        for(int i=0;i<3;i++){
            for(NetPlayer p:players){
                if(p.getNumber()==i){
                    p.setScore(scores[i]);
                    continue;
                }
            }
        }
    }
    public String[] getNames(){
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
    public int[] getScores(){
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
                if(debug)System.out.println("connected to:"+s.getRemoteSocketAddress().toString());
                BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
                String received = in.readLine();
                StringTokenizer args=new StringTokenizer(received,":");
                
                /*
                   for a full list of valid server commands, see Client Documentation.txt and Server Documentation.txt
                   or, you know, look below
                */
                switch(args.nextToken()){//jeopardy protocol goes here
                    case "join":out.write(joinGame(args.nextToken()));break;
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


        private int joinGame(String ip){
            int out=-1;
            if(ValidateIPv4.isValidInet4Address(ip)){
                for(int i=0;i<3;i++){
                    if(ip.equals(players[i].getIpAddress()))break;
                    if(players[i]==null){
                        players[i]=new NetPlayer(ip,0,"",i);
                        out=i;
                    }
                }
            }
            return out;
        }
        private String getScores(){
            String out="";
            for(NetPlayer p:players){
                out+=","+p.getScore();
            }
            return out;
        }
        private String getNames(){
            String out="";
            for(NetPlayer p:players){
                out+=","+p.getName();
            }
            return out;
        }
    }
}

// "We should have called it 'Trivial Pursuit.' I bet these motherfuckers would know how to spell THAT."
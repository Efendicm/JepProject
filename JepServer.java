import java.io.*;
import java.net.*;
import java.util.StringTokenizer;

public class JepServer implements Runnable{
    private final static boolean debug=true;
    private ServerSocket ss=new ServerSocket(80);
    private Socket s;

    public JepServer(){
    }

    public synchronized void run(){
        try{
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

                /*full list of valid server requests:
                    join - requests to join the current game. returns the player id if successful
                    returns -1 if game is full
                    ex: send:join receive:0

                    getscores - returns an int[3] containing each players current score at their ids index
                    ex: send:getscores receive:[400,200,-100]

                    getboard - returns a String[][] containing the next question board. the first row contains the categories,
                    while the other rows contain the questions
                    ex: send:getboard receive:{[Animals,Cities,Famous People,Server Nightmares],[blah blah...]}
                */
                switch(args.nextToken()){//jeopardy protocol goes here
                    case "":break;
                }

                out.close();
                if(debug)System.out.println("closing connection");
            }catch(Exception e){
                if(debug)e.printStackTrace();
            }
        }
    }
}
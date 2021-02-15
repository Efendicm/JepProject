package network;
/*
    Server-side network implementation for Network Jeopardy
    Written by Derek Rodriguez
    last commit: 2/14/21
*/
import java.io.*;
import java.net.*;
import java.util.StringTokenizer;

public class JepServer implements Runnable{
    private final static boolean debug=true;
    private final static int ROWS=4;//question categories
    private final static int COLUMNS=5;//questions per category, plus one (for category label)
    private final static int PLAYERS=3;//the total number of players. I know we're only using three. Stray constants are big stinky
    private ServerSocket ss;
    private Socket s;
    private NetPlayer[] players;
    private String[][] board;
    private int[] buzz;//[row,column] of buzzed question (y,x)

    public JepServer(){
        players=new NetPlayer[PLAYERS];
        board=new String[ROWS][COLUMNS];
        buzz=new int[]{-1,-1};//this is the way im checking if a buzz happens... since -1 question coordinate
    }

    public synchronized void run(){
        try{
            ss=new ServerSocket(80);
            while(true){
                if(debug)System.out.println("waiting for connection:");
                s=ss.accept();
                Thread clientThread=new HandleRequest(s);
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
    public void setBoard(String[][] board){
        if(board.length==ROWS&&board[0].length==COLUMNS){
            this.board=board;
            if(debug)System.out.println("board changed to:"+board.toString());
        }else{
            if(debug)System.out.println("err:wrongboarddimensions:"+board.length+"x"+board[0].length+" != "+ROWS+"x"+COLUMNS);
        }
    }
    public void setScore(int player,int score){
        if(!gameFull()){
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
        if(!gameFull()){
            if(debug)System.out.println("err:gamenotfull");
            return;
        }
        for(int i=0;i<PLAYERS;i++){
            for(NetPlayer p:players){
                if(p.getNumber()==i){
                    p.setScore(scores[i]);
                    if(debug)System.out.println("player "+p.getName()+" score changed to:"+p.getScore());
                    continue;
                }
            }
        }
    }
    public String[] getNames(){//this is probably the slowest possible way to do this, but there are only three players, so we good
        String[] out=new String[PLAYERS];
        for(int i=0;i<PLAYERS;i++){
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
        int[] out=new int[PLAYERS];
        for(int i=0;i<PLAYERS;i++){
            for(NetPlayer p:players){
                if(p.getNumber()==i){
                    out[i]=p.getScore();
                    continue;
                }
            }
        }
        return out;
    }
    public void kickPlayer(int playerNumber){
        for(int i=0;i<PLAYERS;i++){
            if(players[i].getNumber()==playerNumber){
                if(debug)System.out.println(players[i].getIpAddress()+" kicked");
                players[i]=null;
            }
        }
    }
    public boolean gameFull(){
        boolean out=true;
        for(NetPlayer p:players){
            if(p==null)out=false;
        }
        return out;
    }
    public boolean checkBuzzes(){
        if(buzz[0]==-1)return false;
        return true;
    }
    public int[] getBuzz(){
        int[] temp=buzz;
        buzz=new int[]{-1,-1};
        return temp;
    }

    private class HandleRequest extends Thread{
        Socket s;
        public HandleRequest(Socket s){
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
                    case "quitgame":out.write(quitGame(connection));break;
                    case "buzz":out.write(setBuzz(args.nextToken(),args.nextToken()));break;
                    case "getboard":out.write(getBoard(args.nextToken(),args.nextToken()));break;
                    default:out.write("err:unknowncmd");if(debug)System.out.println("error:unknown command:"+received);break;
                }

                out.close();
                if(debug)System.out.println("closing connection");
            }catch(Exception e){
                if(debug)e.printStackTrace();
            }
        }

        private String setBuzz(String y,String x){
            String out="err:outofbounds";
            try{
                int row=Integer.parseInt(y);
                int col=Integer.parseInt(x);
                out=board[row][col];//if y,x is out of bounds, board[row][col] will not exist and the catch will be thrown
                buzz=new int[]{row,col};
                if(debug)System.out.println("buzz set to:"+row+":"+col);
                out="goodluck";//the only reason i made out=board[whatever] earlier was because java gets pissy about just declaring a value without assigning it to something
            }catch(Exception e){
                if(debug)System.out.println("setbuzz:err:outofbounds:"+y+":"+x);
            }
            if(debug)System.out.println("sent:"+out);
            return out;
        }
        private String getBoard(String y,String x){
            String out="err:outofbounds";
            if(y.equals("rows")){
                out=board.length+"";
            }else if(y.equals("cols")){
                out=board[0].length+"";
            }else{
                try{
                    int row=Integer.parseInt(y);
                    int col=Integer.parseInt(x);
                    out=board[row][col];
                }catch(Exception e){
                    if(debug)System.out.println("getboard:err:outofbounds:"+y+":"+x);
                }
            }
            if(debug)System.out.println("sent:"+out);
            return out;
        }
        private String quitGame(String address){
            for(NetPlayer p:players){
                if(p.getIpAddress().equals(address)){
                    if(debug)System.out.println(address+" quitting");
                    p=null;
                    return "solonggaybowser";
                }
            }
            if(debug)System.out.println("err:unknownip:"+address);
            return "err:nosuchplayer";
        }
        private String joinGame(String ip){
            String out="-1";
            if(ValidateIPv4.isValidInet4Address(ip)){
                for(int i=0;i<PLAYERS;i++){
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
import java.io.*;
import java.net.*;

public class JepClient implements Runnable{
    private final static boolean debug=true;
    private int sleepTime=100;//millis i believe
    private String ipaddress="null";

    public JepClient(int sleepTime){
        this.sleepTime=sleepTime;
    }

    public synchronized void run(){
        try{
            while(true){
                //do the shit
                Thread.sleep(sleepTime);
            }
        }catch(Exception e){
            if(debug)e.printStackTrace();
        }
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

    public String sendReceive(String send){//actual communication w/ server
        if(ipaddress.equals("null"))return "err:noipaddress";
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
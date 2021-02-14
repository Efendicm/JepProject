package network;
/*
    this is just meant to be used for network implementation
    DON'T create any of these in the actual interfaces

    Written by Derek Rodriguez
    last commit: 2/12/21
*/
public class NetPlayer{
    private String ipAddress;
    private int score;
    private String name;
    private int number;
    public NetPlayer(String ipAddress,int score,String name,int number){
        this.ipAddress=ipAddress;
        this.score=score;
        this.name=name;
        this.number=number;
    }
    public NetPlayer(){
        ipAddress="null";
        score=0;
        name="";
        number=-1;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
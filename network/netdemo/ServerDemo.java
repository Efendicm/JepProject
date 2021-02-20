package network.netdemo;
/*
    this class is really just here to show how to use a JepServer object, as well as some ways to make the app look good.
    JepClients work pretty much the exact same way, but its specific methods can be found in the doc text file.
*/
import javax.swing.*;
import javax.swing.text.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import network.*;
public class ServerDemo extends JFrame implements ActionListener,KeyListener{
    JFrame frame;
    JButton button;
    JButton question;
    JButton trebek;
    JTextPane text;

    JepServer server;

    Sound music;
    Font font;
    BufferedImage alex;
    BufferedImage cursorImg;
    public static void main(String[] args){
        ServerDemo demo=new ServerDemo();
    }
    public ServerDemo(){
        try{//file io at the start
            alex=ImageIO.read(new File("network\\netdemo\\Capture.PNG"));
            font=Font.createFont(Font.TRUETYPE_FONT, new File("network\\netdemo\\font.ttf"));//this is how you use a custom true type font
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(font);
            cursorImg=ImageIO.read(new File("network\\netdemo\\cursor.png"));
        }catch(Exception e){
            System.out.println("oh shit lmao");
        }

        Cursor cursor=Toolkit.getDefaultToolkit().createCustomCursor(cursorImg, new Point(0,0),"cursor");
        getContentPane().setCursor(cursor);//custom cursor

        setTitle("Demo");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        addKeyListener(this);
        setVisible(true);
        getContentPane().setBackground(new Color(0,0,60));//god i hate how much shit you have to do to make a fucking window
        button=new JButton();
        button.setBounds(getWidth()/2,getHeight()/2,200,50);
        button.setText("Show my IP address!!!");
        button.addActionListener(this);
        button.setFocusable(false);
        button.setBackground(Color.BLUE);
        button.setFont(font);
        button.setFont(new Font(button.getFont().getFontName(),Font.TRUETYPE_FONT,(16)));
        button.setForeground(new Color(230,230,240));
        add(button);
        question=new JButton();
        question.setBounds(getWidth()/4,getHeight()/2,200,50);
        question.setText("Give me a question!!!");
        question.addActionListener(this);
        question.setFocusable(false);
        question.setBackground(Color.BLUE);
        question.setFont(font);
        question.setFont(new Font(question.getFont().getFontName(),Font.TRUETYPE_FONT,(16)));
        question.setForeground(new Color(230,230,240));
        add(question);
        trebek=new JButton();
        trebek.setBounds(getWidth()/2,getHeight()/2+200,200,50);
        trebek.setText("Show me Trebek!!!");
        trebek.addActionListener(this);
        trebek.setFocusable(false);
        trebek.setBackground(Color.BLUE);
        trebek.setFont(font); 
        trebek.setFont(new Font(trebek.getFont().getFontName(),Font.TRUETYPE_FONT,(16)));
        trebek.setForeground(new Color(230,230,240));
        add(trebek);

        text=new JTextPane();
        text.setBounds(0,0,getWidth(),getHeight()/2);

        StyledDocument doc = text.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);//GOD FUCK SWING ALL I WANT IS TO CENTER SOME GODDAMMED TEXT
        //thank you stack overflow
        text.setBorder(null);//we dont want a border
        text.setFont(font);
        text.setFont(new Font(text.getFont().getFontName(),Font.TRUETYPE_FONT,(66)));//easiest way to make the text bigger
        text.setForeground(new Color(230,230,240));
        text.setText("\n\n\nIt's spelled Jeopardy you dumbasses");
        text.setFocusable(false);//stops you from selecting the text
        text.setBackground(new Color(0,0,60));
        add(text);
        repaint();//safety repaint

        server=new JepServer();//the actually important part
        Thread serverThread=new Thread(server);
        serverThread.start();

        music=new Sound("network\\netdemo\\song.wav");//music is easy finally
        music.loop();//forever
        music.play();

        
    }    

    @Override
    public void keyPressed(final KeyEvent e){
        switch(e.getKeyCode()){
            case KeyEvent.VK_ESCAPE:System.exit(0);//quit the whole thing
            case KeyEvent.VK_R:music.play();//restart the music
        }
    }
    @Override
    public void keyTyped(final KeyEvent e){
    }
    @Override
    public void keyReleased(final KeyEvent e){
    }
    @Override
    public void actionPerformed(final ActionEvent e){
        switch(e.getActionCommand()){
            case "Show my IP address!!!":text.setText("\n\n\n\n\n"+server.getIpAddress());break;//no way to vertically center text, gotta use \n\n\n\n
            case "Give me a question!!!":text.setText("On computer keyboards, this key is used to generate the character which can be represented as ASCII code 27 in decimal, Unicode U+001B, or Ctrl+[. This key's character, when sent from the keyboard to a computer, often is interpreted by software as \"stop\", and when sent from the computer to an external device (including many printers since the 1980s, computer terminals and Linux consoles, for example) marks the beginning of an escape sequence to specify operating modes or characteristics generally. It is now generally placed at the top left corner of the keyboard, a convention dating at least to the original IBM PC keyboard, though the key itself originated decades earlier with teletypewriters.");break;
            case "Show me Trebek!!!":getGraphics().drawImage(scale(alex,2.5),0,0,null);
        }
    }


    public BufferedImage scale(BufferedImage sprite,double scale){//scales an image, duh
        BufferedImage img = new BufferedImage((int)(sprite.getWidth()*scale),(int)(sprite.getHeight()*scale),BufferedImage.TYPE_INT_ARGB);
        for(int xx = 0;xx<(int)(sprite.getWidth()*scale);xx++){
            for(int yy = 0;yy <(int)(sprite.getHeight()*scale);yy++){
                img.setRGB(xx, yy, sprite.getRGB((int)(xx/scale), (int)(yy/scale)));
            }
        }
        return img;
    }
}
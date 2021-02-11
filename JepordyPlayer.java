import java.awt.*;
import java.awt.event.*;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.Border;
 
public class JepordyPlayer extends JFrame {
	//Combo box being named
	//private static JComboBox World;
	//private static JComboBox People;
	//private static JComboBox Planets;
	//private static JComboBox Animals;
    private static JFrame frame; //Define static variables for main to use
   private JButton World;
   private JButton People;
   private JButton Planets;
   private JButton Animals;
    private JButton A100;
    private JButton A200;
    private JButton A300;
    private JButton A400;
    private JButton P100;
    private JButton P200;
    private JButton P300;
    private JButton P400;
    private JButton p100;
    private JButton p200;
    private JButton p300;
    private JButton p400;
    private JButton W100;
    private JButton W200;
    private JButton W300;
    private JButton W400;
    private JButton Right; //right and wrong button for quiz master
    private JButton Wrong; //^
	private JButton button1; //Define the button component here
    private JButton button2; //To enable ActionListener to use
    GridLayout Intro = new GridLayout(0,1);
     
    public JepordyPlayer(String name) {
        super(name);
    }
     
    public void addComponentsToPane(final Container pane) {
        final JPanel Player = new JPanel();
        Player.setLayout(Intro);
        JPanel Quiz = new JPanel();
        Quiz.setLayout(Intro);
         
      //New button
        button1 = new JButton("Quiz Master"); //New button 1
        button2 = new JButton("Player");
        SimpleListener ourListener = new SimpleListener();
        //Create an action listener for two buttons to share
         button1.addActionListener(ourListener);
         button2.addActionListener(ourListener);
        //Intro Saying
        Border blackline = BorderFactory.createTitledBorder("Jepordy");
        JPanel Intro = new JPanel();
        LayoutManager layout = new FlowLayout();  
        Intro.setLayout(layout);       

        JPanel panel1 = new JPanel();
        String spaces = "                   ";

        panel1.add(new JLabel(spaces + "Please Pick a player The Qiuz Master Or Answer The Question!" + spaces));  
        panel1.setBorder(blackline);

        Intro.add(panel1);
        //Rules
        Border Rule = BorderFactory.createTitledBorder("Rules");
        JPanel Rules = new JPanel();
        LayoutManager Decribe = new FlowLayout();
        Rules.setLayout(Decribe);
        
        JPanel explain = new JPanel();
        String space = "                   ";

        explain.add(new JLabel(space + "Welcome To Jepordy This is a 4 player game with one being the Quiz Master and 3 being the Player!"
        		+ "  You will have to compete trying to answer questions and the winner is demetmined at the end when the time runs out and who has more points" + space));  
        explain.setBorder(Rule);
        Player.add(explain);
        //Action listner to buttons
        final Button player = new Button("Quiz Master");
        //Add buttons
        Player.add(button1); //Add buttons to the panel
        Player.add(button2);
        //Player.add(new JButton("Quiz Master"));
        //Quiz.add(new JButton("Answer Questions"));
         
        //Actives Buttons
        pane.add(Intro, BorderLayout.NORTH);
        pane.add(Player, BorderLayout.CENTER);
        pane.add(Rules, BorderLayout.SOUTH);
        pane.add(Quiz, BorderLayout.EAST);
    }
    
     
    private class SimpleListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
         String buttonName = e.getActionCommand();
		if (buttonName.equals("Quiz Master"))
		{
			QuizMaster();
			Playercount(e);
			CloseFrame();//Remove frame
			
        	
     }
         	else if (buttonName.equals("Player")) {
         		Player();
         		Playercount1(e);
         		CloseFrame();
         	}
		
         	else if (buttonName.equals("W100")) {
         		World1();
         		W100.setEnabled(false);
         		
         	}
         	else if (buttonName.equals("W300")) {
         		World1();
         		W100.setEnabled(false);
         		
         	}
         	else if (buttonName.equals("W400")) {
         		World1();
         		W100.setEnabled(false);
         		
         	}
         	else if (buttonName.equals("W400")) {
         		People1();
         		//P100.setEnabled(false);
         		
         	}
         	else if (buttonName.equals("P100")) {
         		People1();
         		//P100.setEnabled(false);
         		
         	}
		}
    }
    int Master;
    int Player;
    private void Playercount(ActionEvent e){  

        Master++;
        String buttonName = e.getActionCommand();
        if(buttonName.equals("Quiz Master")) {
        if(Master > 1){
            JOptionPane.showMessageDialog(null, "Only one player can be Quiz master");
        }
        }
    }
    private void Playercount1(ActionEvent e){  
        Player++;
        String buttonName = e.getActionCommand();
       if(buttonName.equals("Player")) {   
        if(Player > 3)
        {
        	JOptionPane.showMessageDialog(null, "Only Three player can be Player");
        }
       }
    }
    private static void World1() {
    	//string for Questions
    	final String[] World1 = {"World War I began in which year?","What city was the first capital of the United States?", "Who is Elon Musk?","How Many States are in the united States?"};
    	Random random = new Random();
    	final int index = random.nextInt(World1.length);
    	JOptionPane.showMessageDialog(null,World1[index]);
    	
    }
    private static void World2() {
    	//string for Questions
    	final String[] World1 = {"World War I began in which year?","What city was the first capital of the United States?", "Who is Elon Musk?","How Many States are in the united States?"};
    	Random random = new Random();
    	final int index = random.nextInt(World1.length);
    	JOptionPane.showMessageDialog(null,World1[index]);
    	
    }
    private static void World3() {
    	//string for Questions
    	final String[] World1 = {"World War I began in which year?","What city was the first capital of the United States?", "Who is Elon Musk?","How Many States are in the united States?"};
    	Random random = new Random();
    	final int index = random.nextInt(World1.length);
    	JOptionPane.showMessageDialog(null,World1[index]);
    	
    }
    private static void World4() {
    	//string for Questions
    	final String[] World1 = {"World War I began in which year?","What city was the first capital of the United States?", "Who is Elon Musk?","How Many States are in the united States?"};
    	Random random = new Random();
    	final int index = random.nextInt(World1.length);
    	JOptionPane.showMessageDialog(null,World1[index]);
    	
    }
    private static void People1() {
    	//string for Questions
    	final String[] People1 = {"Who is George Washington?","Who made FaceBook?", "Who is Elon Musk?","Who is Martin Luther King jr.?"};
    	Random random = new Random();
    	final int index = random.nextInt(People1.length);
    	JOptionPane.showMessageDialog(null,People1[index]);
    	
    }


    private static void createAndShowGUI() {
        //Create and set up the window.
        JepordyPlayer frame = new JepordyPlayer("GridLayoutDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Set up the content pane.
        frame.addComponentsToPane(frame.getContentPane());
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
     
    public static void main(String[] args) {
         
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
    private void Player() {
    	//Buttons
    	 World = new JButton("World");
    	 People = new JButton("People");
    	 Planets = new JButton("Planets");
    	 Animals = new JButton("Animals");
        W100 = new JButton("W100");
        W200 = new JButton("W200");
        W300 = new JButton("W300");
        W400 = new JButton("W400");
        P100 = new JButton("P100");
        P200 = new JButton("P200");
        P300 = new JButton("P300");
        P400 = new JButton("P400");
        p100 = new JButton("p100");
        p200 = new JButton("200");
        p300 = new JButton("p300");
        p400 = new JButton("p400");
        A100 = new JButton("A100");
        A200 = new JButton("A200");
        A300 = new JButton("A300");
        A400 = new JButton("A400");
        //Action Listener For buttons
        SimpleListener Cat = new SimpleListener();
        SimpleListener Cat1 = new SimpleListener();
        SimpleListener Cat2 = new SimpleListener();
        SimpleListener Cat3 = new SimpleListener();
        W100.addActionListener(Cat);
        W200.addActionListener(Cat);
        W300.addActionListener(Cat);
        W400.addActionListener(Cat);
        P100.addActionListener(Cat1);
        P200.addActionListener(Cat1);
        P300.addActionListener(Cat1);
        P400.addActionListener(Cat1);
        p100.addActionListener(Cat2);
        p200.addActionListener(Cat2);
        p300.addActionListener(Cat2);
        p400.addActionListener(Cat2);
        A100.addActionListener(Cat3);
        A200.addActionListener(Cat3);
        A300.addActionListener(Cat3);
        A400.addActionListener(Cat3);
        //Buttons Functions
        //Action for each question cat
//        class Cat implements ActionListener{
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				String buttonName = e.getActionCommand();
//				if (buttonName.equals("W100"))
//				{
//					World1();
//					//JOptionPane.showMessageDialog(null,World1[index]);
//
//			}
//        	
//        }
//        class Cat1 implements ActionListener{
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				
//				
//			}
//        	
//        }
//        class Cat2 implements ActionListener{
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				
//				
//			}
//        	
//        }
//        //class Cat3 implements ActionListener{
//
//			//@Override
//			//public void actionPerformed(ActionEvent e) {
//				
//				
//        }
       // }
        //JPanel to make bored
    	JPanel Master = new JPanel();
    	JPanel Master2 = new JPanel();
    	 GridLayout Game = new GridLayout(0,4);
        Master.setLayout(Game);
        Master2.setLayout(Game);
        Master.add(World);
        Master.add(People);
        Master.add(Planets);
        Master.add(Animals);
        Master2.add(W100);
        Master2.add(P100);
        Master2.add(p100);
        Master2.add(A100);
        Master2.add(W200);
        Master2.add(P200);
        Master2.add(p200);
        Master2.add(A200);
        Master2.add(W300);
        Master2.add(P300);
        Master2.add(p300);
        Master2.add(A300);
        Master2.add(W400);
        Master2.add(P400);
        Master2.add(p400);
        Master2.add(A400);
        //Master.add(World);
        //Master.add(People);
        //Master.add(Planets);
        //Master.add(Animals);
        JFrame quiz = new JFrame("QuizMaster" );
        quiz.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Set up the content pane.
        //frame.addComponentsToPane(frame.getContentPane());
        //Display the window.
        quiz.add(Master, BorderLayout.NORTH);
        quiz.add(Master2, BorderLayout.CENTER);
        //quiz.add(Master3, BorderLayout.WEST);
        //quiz.add(Master4, BorderLayout.CENTER);
        quiz.pack();
        quiz.setVisible(true);   

    }
    private void QuizMaster() {
        JFrame Quiz = new JFrame("Quiz Master" );
        Quiz.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Set up the content pane.
        JPanel B = new JPanel();
        GridLayout g = new GridLayout(0,2);
        B.setLayout(g);
        //Button
        Right = new JButton("Right");
        Wrong = new JButton("Wrong");
        //Button on JPanel
        B.add(Right);
        B.add(Wrong);
        //Action Listerner for button
        //SimpleListener answers = new SimpleListener();
        //Display the window.
        Quiz.add(B, BorderLayout.CENTER);
        Quiz.pack();
        Quiz.setVisible(true);   

    }
    //private class answers implements ActionListener{
    //}
    public void CloseFrame(){
        super.dispose();
    }
    //class MyComboBox extends JLabel implements ListCellRenderer
   // {
       // private String _title;

      //  public MyComboBox(String title)
       // {
       //     _title = title;
       // }

       // @Override
       // public Component getListCellRendererComponent(JList list, Object value,
           //     int index, boolean isSelected, boolean hasFocus)
      //  {
          //  if (index == -1 && value == null) setText(_title);
         //   else setText(value.toString());
          //  return this;
       // }
   // }
}


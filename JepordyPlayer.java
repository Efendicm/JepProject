import java.awt.*;
import java.awt.event.*;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.Border;
 
public class JepordyPlayer extends JFrame {
    private static JFrame frame; //Define static variables for main to use
    private JButton AnswerW;
    private JButton AnswerP;
    private JButton Answerpl;
    private JButton AnswerA;
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
	//Creates the JPanel
     
    public void addComponentsToPane(final Container pane) {
        final JPanel Player = new JPanel();
        Player.setLayout(Intro);
        JPanel Quiz = new JPanel();
        Quiz.setLayout(Intro);
        
      //New button
        button1 = new JButton("Quiz Master"); //New button 1
        button1.setBackground(Color.PINK);
        button1.setForeground(Color.WHITE);
        button2 = new JButton("Player");
        button2.setBackground(Color.MAGENTA);
        button2.setForeground(Color.WHITE);
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
        panel1.setBackground(Color.BLUE);

        panel1.add(new JLabel(spaces + "Please Pick a player The Qiuz Master Or Answer The Question!" + spaces));  
        panel1.setBorder(blackline);


        Intro.add(panel1);
        //Rules
        Border Rule = BorderFactory.createTitledBorder("Rules");
        JPanel Rules = new JPanel();
        LayoutManager Decribe = new FlowLayout();
        Rules.setLayout(Decribe);
        //Rules.setBackground(Color.BLUE);
        
        JPanel explain = new JPanel();
        String space = "                   ";

        explain.add(new JLabel("<html><i>Welcome To Jepordy This is a 4 player game with one being the Quiz Master and 3 being the Player! <br> You will have to compete trying to answer questions and the winner is demetmined at the end when the time runs out and who has more points.</i><html>"));  
        explain.setBorder(Rule);
        explain.setBackground(Color.CYAN);
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
        //pane.add(Rules, BorderLayout.SOUTH);
        //pane.add(Quiz, BorderLayout.EAST);
        Intro.setBackground(Color.BLUE);

        //setLayout(new BorderLayout());
		//setContentPane(new JLabel(new ImageIcon("Jeopardy.jpg")));
		//setLayout(new FlowLayout());
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

            else if (buttonName.equals("W200")) {
         	    World2();
         		W200.setEnabled(false);

            }
            
            else if (buttonName.equals("W300")) {
         		World3();
         		W300.setEnabled(false);
         		
         	}
         	else if (buttonName.equals("W400")) {
         		World4();
         		W400.setEnabled(false);
         		
         	}
         	else if (buttonName.equals("P100")) {
         		People1();
         		P100.setEnabled(false);
         		
         	}
         	else if (buttonName.equals("P200")) {
         		People2();
         		P200.setEnabled(false);
         		
         	}
            else if (buttonName.equals("P300")) {
         		People3();
         		P300.setEnabled(false);
         		
         	}
         	else if (buttonName.equals("P400")) {
         		People4();
         		P400.setEnabled(false);
         		
         	} 
            else if (buttonName.equals("p100")) {
         		Planets1();
         		p100.setEnabled(false);
         		
         	}
         	else if (buttonName.equals("p200")) {
         		Planets2();
         		p200.setEnabled(false);
         		
         	}
            else if (buttonName.equals("p300")) {
         		Planets3();
         		p300.setEnabled(false);
         		
         	}
         	else if (buttonName.equals("p400")) {
         		Planets4();
         		p400.setEnabled(false);
         		
         	}
            else if (buttonName.equals("A100")) {
         		Animals1();
         		A100.setEnabled(false);
         		
         	}
         	else if (buttonName.equals("A200")) {
         		Animals2();
         		A200.setEnabled(false);
         		
         	}
            else if (buttonName.equals("A300")) {
         		Animals3();
         		A300.setEnabled(false);
         		
         	}
         	else if (buttonName.equals("A400")) {
         		Animals4();
         		A400.setEnabled(false);
         		
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
    	final String[] World1 = {"EasyWQ1","EasyWQ2", "EasyWQ3","EasyWQ4"};
    	Random random = new Random();
    	final int index = random.nextInt(World1.length);
    	JOptionPane.showMessageDialog(null,World1[index]);
    	
    }
    private static void World2() {
    	//string for Questions
    	final String[] World2 = {"MediumWQ1","MediumWQ2", "MediumWQ3","MediumWQ4"};
    	Random random = new Random();
    	final int index = random.nextInt(World2.length);
    	JOptionPane.showMessageDialog(null,World2[index]);
    	
    }
    private static void World3() {
    	//string for Questions
    	final String[] World1 = {"HardWQ1","HardWQ2", "HardWQ3","HardWQ4"};
    	Random random = new Random();
    	final int index = random.nextInt(World1.length);
    	JOptionPane.showMessageDialog(null,World1[index]);
    	
    }
    private static void World4() {
    	//string for Questions
    	final String[] World1 = {"ExpertWQ1","ExpertWQ2", "ExpertWQ3","ExpertWQ4"};
    	Random random = new Random();
    	final int index = random.nextInt(World1.length);
    	JOptionPane.showMessageDialog(null,World1[index]);
    	
    }
    private static void People1() {
    	//string for Questions
    	final String[] People1 = {"EasyPQ1","EasyPQ2", "EasyPQ3","EasyPQ4"};
    	Random random = new Random();
    	final int index = random.nextInt(People1.length);
    	JOptionPane.showMessageDialog(null,People1[index]);
    	
    }
    private static void People2() {
    	//string for Questions
    	final String[] People2 = {"MediumPQ1","MediumPQ2", "MediumPQ3","MediumPQ4"};
    	Random random = new Random();
    	final int index = random.nextInt(People2.length);
    	JOptionPane.showMessageDialog(null,People2[index]);
    	
    }
    private static void People3() {
    	//string for Questions
    	final String[] People3 = {"HardPQ1","HardPQ2", "HardPQ3","HardPQ4"};
    	Random random = new Random();
    	final int index = random.nextInt(People3.length);
    	JOptionPane.showMessageDialog(null,People3[index]);
    	
    }
    private static void People4() {
    	//string for Questions
    	final String[] People4 = {"ExpertPQ1","ExpertPQ2", "ExpertPQ3","ExpertPQ4"};
    	Random random = new Random();
    	final int index = random.nextInt(People4.length);
    	JOptionPane.showMessageDialog(null,People4[index]);
    	
    }
    private static void Planets1() {
    	//string for Questions
    	final String[] Planets1 = {"EasypQ1","EasypQ2", "EasypQ3","EasypQ4"};
    	Random random = new Random();
    	final int index = random.nextInt(Planets1.length);
    	JOptionPane.showMessageDialog(null,Planets1[index]);
    	
    }
    private static void Planets2() {
    	//string for Questions
    	final String[] Planets2 = {"MediumpQ1","MediumpQ2", "MediumpQ3","MediumpQ4"};
    	Random random = new Random();
    	final int index = random.nextInt(Planets2.length);
    	JOptionPane.showMessageDialog(null,Planets2[index]);
    	
    }
    private static void Planets3() {
    	//string for Questions
    	final String[] Planets3 = {"HardpQ1","HardpQ2", "HardpQ3","HardpQ4"};
    	Random random = new Random();
    	final int index = random.nextInt(Planets3.length);
    	JOptionPane.showMessageDialog(null,Planets3[index]);
    	
    }
    private static void Planets4() {
    	//string for Questions
    	final String[] Planets4 = {"ExpertAQ1","ExpertAQ2", "ExpertAQ3","ExpertAQ4"};
    	Random random = new Random();
    	final int index = random.nextInt(Planets4.length);
    	JOptionPane.showMessageDialog(null,Planets4[index]);
    	
    }
    private static void Animals1() {
    	//string for Questions
    	final String[] Animals1 = {"EasyAQ1","EasyAQ2", "EasyAQ3","EasyAQ4"};
    	Random random = new Random();
    	final int index = random.nextInt(Animals1.length);
    	JOptionPane.showMessageDialog(null,Animals1[index]);
    	
    }
    private static void Animals2() {
    	//string for Questions
    	final String[] Animals2 = {"MediumAQ1","MediumAQ2", "MediumAQ3","MediumAQ4"};
    	Random random = new Random();
    	final int index = random.nextInt(Animals2.length);
    	JOptionPane.showMessageDialog(null,Animals2[index]);
    	
    }
    private static void Animals3() {
    	//string for Questions
    	final String[] Animals3 = {"HardAQ1","HardAQ2", "HardAQ3","HardAQ4"};
    	Random random = new Random();
    	final int index = random.nextInt(Animals3.length);
    	JOptionPane.showMessageDialog(null,Animals3[index]);
    	
    }
    private static void Animals4() {
    	//string for Questions
    	final String[] Animals4 = {"ExpertAQ1","ExpertAQ2", "ExpertAQ3","ExpertAQ4"};
    	Random random = new Random();
    	final int index = random.nextInt(Animals4.length);
    	JOptionPane.showMessageDialog(null,Animals4[index]);
    	
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
        World.setBackground(Color.CYAN);
    	People = new JButton("People");
        People.setBackground(Color.CYAN);
    	Planets = new JButton("Planets");
        Planets.setBackground(Color.CYAN);
    	Animals = new JButton("Animals");
        Animals.setBackground(Color.CYAN);
        W100 = new JButton("W100");
        W100.setBackground(Color.GREEN);
        W100.setForeground(Color.BLACK);
        W200 = new JButton("W200");
        W200.setBackground(Color.YELLOW);
        W200.setForeground(Color.BLACK);
        W300 = new JButton("W300");
        W300.setBackground(Color.ORANGE);
        W300.setForeground(Color.BLACK);
        W400 = new JButton("W400");
        W400.setBackground(Color.RED);
        W400.setForeground(Color.WHITE);
        P100 = new JButton("P100");
        P100.setBackground(Color.GREEN);
        P100.setForeground(Color.BLACK);
        P200 = new JButton("P200");
        P200.setBackground(Color.YELLOW);
        P200.setForeground(Color.BLACK);
        P300 = new JButton("P300");
        P300.setBackground(Color.ORANGE);
        P300.setForeground(Color.BLACK);
        P400 = new JButton("P400");
        P400.setBackground(Color.RED);
        P400.setForeground(Color.WHITE);
        p100 = new JButton("p100");
        p100.setBackground(Color.GREEN);
        p100.setForeground(Color.BLACK);
        p200 = new JButton("p200");
        p200.setBackground(Color.YELLOW);
        p200.setForeground(Color.BLACK);
        p300 = new JButton("p300");
        p300.setBackground(Color.ORANGE);
        p300.setForeground(Color.BLACK);
        p400 = new JButton("p400");
        p400.setBackground(Color.RED);
        p400.setForeground(Color.WHITE);
        A100 = new JButton("A100");
        A100.setBackground(Color.GREEN);
        A100.setForeground(Color.BLACK);
        A200 = new JButton("A200");
        A200.setBackground(Color.YELLOW);
        A200.setForeground(Color.BLACK);
        A300 = new JButton("A300");
        A300.setBackground(Color.ORANGE);
        A300.setForeground(Color.BLACK);
        A400 = new JButton("A400");
        A400.setBackground(Color.RED);
        A400.setForeground(Color.WHITE);
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
        quiz.pack();
        quiz.setVisible(true);   

    }
    private void QuizMaster() {
        JFrame Quiz = new JFrame("Quiz Master" );
        Quiz.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Set up the content pane.
        JPanel B = new JPanel();
	JPanel A = new JPanel();
        GridLayout g = new GridLayout(0,2);
        B.setLayout(g);
	A.setLayout(g);
        //Button
        Right = new JButton("Right");
        Right.setBackground(Color.GREEN);
        Right.setForeground(Color.WHITE);
        Wrong = new JButton("Wrong");
        Wrong.setBackground(Color.RED);
        Wrong.setForeground(Color.WHITE);
	AnswerW = new JButton("World Answers");
	AnswerW.setBackground(Color.CYAN);
        AnswerW.setForeground(Color.WHITE);
	AnswerP = new JButton("People Answers");
	AnswerP.setBackground(Color.CYAN);
        AnswerP.setForeground(Color.WHITE);
	Answerpl = new JButton("Planets Answers");
	Answerpl.setBackground(Color.CYAN);
        Answerpl.setForeground(Color.WHITE);
	AnswerA = new JButton("Animals Answers");
	AnswerA.setBackground(Color.CYAN);
        AnswerA.setForeground(Color.WHITE);
        //Button on JPanel
	A.add(AnswerW);
	A.add(AnswerP);
	A.add(Answerpl);
	A.add(AnswerA);
        B.add(Right);
        B.add(Wrong);
        //Action Listerner for button
        //SimpleListener answers = new SimpleListener();
        //Display the window.
        Quiz.add(B, BorderLayout.CENTER);
	Quiz.add(A, BorderLayout.SOUTH);
        Quiz.pack();
        Quiz.setVisible(true);   

    }
    //Closes The Frame out
    public void CloseFrame(){
        super.dispose();
    }
}


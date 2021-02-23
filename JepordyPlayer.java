import java.awt.*;
import java.awt.event.*;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.Border;

import jepordy.JepordyPlayer1.Action;

public class JepordyPlayer extends JFrame {
	private static JFrame frame; //Define static variables for main to use
	private JButton b;
	private String Input = "";
	private String Quest = "";
	private static JTextField Answer;
	private static JLabel Score;
	private static JLabel Score1;
	private static JLabel Score2;
	private static JLabel Question;
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
	private JButton RightPlayer1;
	private JButton RightPlayer2;
	private JButton RightPlayer3;
	private JButton WrongPlayer1;
	private JButton WrongPlayer2;
	private JButton WrongPlayer3;
	private JButton Add;
	private JButton Add1;
	private JButton Add2;
	private JButton Add3;
	private JButton button1; //Define the button component here
	private JButton button2; //To enable ActionListener to use
	//add score to game
	private int score1 = 0;
	private int score2 = 0;
	private int score3 = 0;
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
		button1.setForeground(Color.BLACK);
		button2 = new JButton("Player");
		button2.setBackground(Color.MAGENTA);
		button2.setForeground(Color.BLACK);
		SimpleListener ourListener = new SimpleListener();
		//Create an action listener for two buttons to share
		button1.addActionListener(ourListener);
		button2.addActionListener(ourListener);
		//Add.addActionListener(ourListener);
		//Intro Saying
		Font font1 = new Font("Dialog", Font.BOLD, 50);
		JLabel Intro = new JLabel("Jeopardy");
		Intro.setFont(font1);
		Intro.setSize(200, 200);
		LayoutManager layout = new FlowLayout();  
		Intro.setLayout(layout);    
		Intro.setHorizontalAlignment(JLabel.CENTER);
 
		//Rules
		Border Rule = BorderFactory.createTitledBorder("Rules");
		JPanel Rules = new JPanel();
		LayoutManager Decribe = new FlowLayout();
		Rules.setLayout(Decribe);

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

		//Actives Buttons
		pane.add(Intro, BorderLayout.NORTH);
		pane.add(Player, BorderLayout.CENTER);
		Intro.setBackground(Color.CYAN);
	}


	private class SimpleListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String buttonName = e.getActionCommand();
			if (buttonName.equals("Quiz Master"))
			{
				QuizMaster();
				Playercount(e);
				//CloseFrame();//Remove frame


			}
			else if (buttonName.equals("Player")) {
				Player();
				Playercount1(e);
				//CloseFrame();
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
			else if (buttonName.equals("World Answers")) {
				WorldAnswers();
			}
			else if (buttonName.equals("People Answers")) {
				PeopleAnswers();
			}
			else if (buttonName.equals("Planets Answers")) {
				PlanetsAnswers();
			}
			else if (buttonName.equals("Animals Answers")) {
				AnimalsAnswers();
			}
			else if (buttonName.equals("Right")) {
				Right();
			}
			else if (buttonName.equals("Player1")) {
				ScoreAdd();
			}
			else if (buttonName.equals("Player2")) {
				ScoreAdd1();
			}
			else if (buttonName.equals("Player3")) {
				ScoreAdd2();
			}
		}
	}
	private class SimpleListener1 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String buttonName = e.getActionCommand();
			if (buttonName.equals("+100")) {
				score1 += 100;
				Score.setText("Player1: " + score1);
			}
			else if (buttonName.equals("+200")) {
				score1 += 200;
				Score.setText("Player1: " + score1);
			}
			else if (buttonName.equals("+300")) {
				score1 += 300;
				Score.setText("Player1: " + score1);
			}
			else if (buttonName.equals("+400")) {
				score1 += 400;
				Score.setText("Player1: " + score1);
			}
		}
	}
	private class SimpleListener2 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String buttonName = e.getActionCommand();
			if (buttonName.equals("+100")) {
				score2 += 100;
				Score1.setText("Player2: " + score2);
			}
			else if (buttonName.equals("+200")) {
				score2 += 200;
				Score1.setText("Player2: " + score2);
			}
			else if (buttonName.equals("+300")) {
				score2 += 300;
				Score1.setText("Player2: " + score2);
			}
			else if (buttonName.equals("+400")) {
				score2 += 400;
				Score1.setText("Player2: " + score2);
			}
		}
	}
	private class SimpleListener3 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String buttonName = e.getActionCommand();
			if (buttonName.equals("+100")) {
				score3 += 100;
				Score2.setText("Player3: " + score3);
			}
			else if (buttonName.equals("+200")) {
				score3 += 200;
				Score2.setText("Player3: " + score3);
			}
			else if (buttonName.equals("+300")) {
				score3 += 300;
				Score2.setText("Player3: " + score3);
			}
			else if (buttonName.equals("+400")) {
				score3 += 400;
				Score2.setText("Player3: " + score3);
			}
		}
	}
	private class SimpleListenerWrong implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String buttonName = e.getActionCommand();
			if (buttonName.equals("Wrong")) {
				Wrong();
			}
			else if (buttonName.equals("Player1")) {
				ScoreMinus();
			}
			else if (buttonName.equals("Player2")) {
				ScoreMinus1();
			}
			else if (buttonName.equals("Player3")) {
				ScoreMinus2();
			}
			else if (buttonName.equals("-100")) {
				score1 -= 100;
				Score.setText("Player1: " + score1);
			}
			else if (buttonName.equals("-200")) {
				score1 -= 200;
				Score.setText("Player1: " + score1);
			}
			else if (buttonName.equals("-300")) {
				score1 -= 300;
				Score.setText("Player1: " + score1);
			}
			else if (buttonName.equals("-400")) {
				score1 -= 400;
				Score.setText("Player1: " + score1);
			}
		}
	}
	private class SimpleListenerWrong1 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String buttonName = e.getActionCommand();
			if (buttonName.equals("-100")) {
				score2 -= 100;
				Score1.setText("Player2: " + score2);
			}
			else if (buttonName.equals("-200")) {
				score2 -= 200;
				Score1.setText("Player2: " + score2);
			}
			else if (buttonName.equals("-300")) {
				score2 -= 300;
				Score1.setText("Player2: " + score2);
			}
			else if (buttonName.equals("-400")) {
				score2 -= 400;
				Score1.setText("Player2: " + score2);
			}
		}
	}
	private class SimpleListenerWrong2 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String buttonName = e.getActionCommand();
			if (buttonName.equals("-100")) {
				score3 -= 100;
				Score2.setText("Player3: " + score3);
			}
			else if (buttonName.equals("-200")) {
				score3 -= 200;
				Score2.setText("Player3: " + score3);
			}
			else if (buttonName.equals("-300")) {
				score3 -= 300;
				Score2.setText("Player3: " + score3);
			}
			else if (buttonName.equals("-400")) {
				score3 -= 400;
				Score2.setText("Player3: " + score3);
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
	private class Answers implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String buttonName = e.getActionCommand();
			if(buttonName.equals("Submit")) {
			Answer.setText(Input);
		}
		
	}
	}
//	private class An implements ActionListener{
//
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			String buttonName = e.getActionCommand();
//			if(buttonName.equals("Submit")) {
//			An.setText(Input);
//		}
//		
//	}
//	}
	private void WorldAnswers() {
		JepordyPlayer Answers = new JepordyPlayer("Question");
		Answers.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//Display the window.
		Answers.setPreferredSize(new Dimension(600, 600));
	    Answers.setLocationRelativeTo(null);
		Answers.pack();       
		Answers.setVisible(true);
		JPanel response = new JPanel();
		JLabel Response = new JLabel("Players Response:");
		JLabel Question = new JLabel("Players Response:");
		GridLayout answer = new GridLayout(0,1);
		response.setLayout(answer);
		response.add(Response);
		Input = Answer.getText();
		Response.setText("Players Answer: " + Input);
		Answers.add(response);
		Answers.add(response, BorderLayout.CENTER);
	}
	private void PeopleAnswers() {
		JepordyPlayer Answers = new JepordyPlayer("Question");
		Answers.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//Display the window.
		Answers.setPreferredSize(new Dimension(600, 600));
	    Answers.setLocationRelativeTo(null);
		Answers.pack();       
		Answers.setVisible(true);
		JPanel response = new JPanel();
		JLabel Response = new JLabel("Players Response:");
		JLabel Question = new JLabel("Players Response:");
		GridLayout answer = new GridLayout(0,1);
		response.setLayout(answer);
		response.add(Response);
		Input = Answer.getText();
		Response.setText("Players Answer: " + Input);
		Answers.add(response);
		Answers.add(response, BorderLayout.CENTER);
	}
	private void PlanetsAnswers() {
		JepordyPlayer Answers = new JepordyPlayer("Question");
		Answers.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//Display the window.
		Answers.setPreferredSize(new Dimension(600, 600));
	    Answers.setLocationRelativeTo(null);
		Answers.pack();       
		Answers.setVisible(true);
		JPanel response = new JPanel();
		JLabel Response = new JLabel("Players Response:");
		JLabel Question = new JLabel("Players Response:");
		GridLayout answer = new GridLayout(0,1);
		response.setLayout(answer);
		response.add(Response);
		Input = Answer.getText();
		Response.setText("Players Answer: " + Input);
		Answers.add(response);
		Answers.add(response, BorderLayout.CENTER);
	}
	private void AnimalsAnswers() {
		JepordyPlayer Answers = new JepordyPlayer("Question");
		Answers.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//Display the window.
		Answers.setPreferredSize(new Dimension(600, 600));
	    Answers.setLocationRelativeTo(null);
		Answers.pack();       
		Answers.setVisible(true);
		JPanel response = new JPanel();
		JLabel Response = new JLabel("Players Response:");
		JLabel Question = new JLabel("Players Response:");
		GridLayout answer = new GridLayout(0,1);
		response.setLayout(answer);
		response.add(Response);
		Input = Answer.getText();
		Response.setText("Players Answer: " + Input);
		Answers.add(response);
		Answers.add(response, BorderLayout.CENTER);
	}
	private void World1() {
		 JButton b = new JButton("submit");
		 Answer = new JTextField(20);
		 Answers A = new Answers();
		 b.addActionListener(A);
		//string for Questions
		 final String[] World1 = {"EasyWQ1","EasyWQ2", "EasyWQ3","EasyWQ4"};
		Random random = new Random();
		final int index = random.nextInt(World1.length);
		JepordyPlayer question = new JepordyPlayer("Question");
		question.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//Display the window.
		question.setPreferredSize(new Dimension(600, 600));
	    question.setLocationRelativeTo(null);
		question.pack();       
		question.setVisible(true);
		Question = new JLabel("Question: ");
		JPanel QuestionDisplay = new JPanel();
		JPanel An = new JPanel();
		JPanel sub = new JPanel();
		QuestionDisplay.add(Question);
		GridLayout quest = new GridLayout(0,1);
		GridLayout answer = new GridLayout(0,1);
		An.setLayout(answer);
		sub.setLayout(answer);
		Question.setLayout(quest);
		An.add(Answer);
		sub.add(b);
		Question.setText("Question: " + World1[index]);
		Question.setFont(new Font("Dialog", Font.BOLD, 30));
		question.add(QuestionDisplay, BorderLayout.NORTH);
		question.add(An, BorderLayout.CENTER);
		question.add(sub, BorderLayout.SOUTH);
		
		
		
		

	}
	private void World2() {
		//string for Questions
		JButton b = new JButton("submit");
		 Answer = new JTextField(20);
		 Answers A = new Answers();
		 b.addActionListener(A);
		final String[] World2 = {"MediumWQ1","MediumWQ2", "MediumWQ3","MediumWQ4"};
		Random random = new Random();
		final int index = random.nextInt(World2.length);
		JepordyPlayer question = new JepordyPlayer("Question");
		question.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//Display the window.
		question.setPreferredSize(new Dimension(600, 600));
	    question.setLocationRelativeTo(null);
		question.pack();       
		question.setVisible(true);
		Question = new JLabel("Question: ");
		JPanel QuestionDisplay = new JPanel();
		JPanel An = new JPanel();
		JPanel sub = new JPanel();
		QuestionDisplay.add(Question);
		GridLayout quest = new GridLayout(0,1);
		GridLayout answer = new GridLayout(0,1);
		An.setLayout(answer);
		sub.setLayout(answer);
		Question.setLayout(quest);
		An.add(Answer);
		sub.add(b);
		Question.setText("Question: " + World2[index]);
		Question.setFont(new Font("Dialog", Font.BOLD, 30));
		question.add(QuestionDisplay, BorderLayout.NORTH);
		question.add(An, BorderLayout.CENTER);
		question.add(sub, BorderLayout.SOUTH);
		//JOptionPane.showMessageDialog(null,World2[index]);

	}
	private void World3() {
		JButton b = new JButton("submit");
		 Answer = new JTextField(20);
		 Answers A = new Answers();
		 b.addActionListener(A);
		//string for Questions
		final String[] World3 = {"HardWQ1","HardWQ2", "HardWQ3","HardWQ4"};
		Random random = new Random();
		final int index = random.nextInt(World3.length);
		JepordyPlayer question = new JepordyPlayer("Question");
		question.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//Display the window.
		question.setPreferredSize(new Dimension(600, 600));
	    question.setLocationRelativeTo(null);
		question.pack();       
		question.setVisible(true);
		Question = new JLabel("Question: ");
		JPanel QuestionDisplay = new JPanel();
		JPanel An = new JPanel();
		JPanel sub = new JPanel();
		QuestionDisplay.add(Question);
		GridLayout quest = new GridLayout(0,1);
		GridLayout answer = new GridLayout(0,1);
		An.setLayout(answer);
		sub.setLayout(answer);
		Question.setLayout(quest);
		An.add(Answer);
		sub.add(b);
		Question.setText("Question: " + World3[index]);
		Question.setFont(new Font("Dialog", Font.BOLD, 30));
		question.add(QuestionDisplay, BorderLayout.NORTH);
		question.add(An, BorderLayout.CENTER);
		question.add(sub, BorderLayout.SOUTH);
		//JOptionPane.showMessageDialog(null,World1[index]);

	}
	private void World4() {
		JButton b = new JButton("submit");
		 Answer = new JTextField(20);
		 Answers A = new Answers();
		 b.addActionListener(A);
		//string for Questions
		final String[] World4 = {"ExpertWQ1","ExpertWQ2", "ExpertWQ3","ExpertWQ4"};
		Random random = new Random();
		final int index = random.nextInt(World4.length);
		JepordyPlayer question = new JepordyPlayer("Question");
		question.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//Display the window.
		question.setPreferredSize(new Dimension(600, 600));
	    question.setLocationRelativeTo(null);
		question.pack();       
		question.setVisible(true);
		Question = new JLabel("Question: ");
		JPanel QuestionDisplay = new JPanel();
		JPanel An = new JPanel();
		JPanel sub = new JPanel();
		QuestionDisplay.add(Question);
		GridLayout quest = new GridLayout(0,1);
		GridLayout answer = new GridLayout(0,1);
		An.setLayout(answer);
		sub.setLayout(answer);
		Question.setLayout(quest);
		An.add(Answer);
		sub.add(b);
		Question.setText("Question: " + World4[index]);
		Question.setFont(new Font("Dialog", Font.BOLD, 30));
		question.add(QuestionDisplay, BorderLayout.NORTH);
		question.add(An, BorderLayout.CENTER);
		question.add(sub, BorderLayout.SOUTH);
		//JOptionPane.showMessageDialog(null,World1[index]);

	}
	private void People1() {
		JButton b = new JButton("submit");
		 Answer = new JTextField(20);
		 Answers A = new Answers();
		 b.addActionListener(A);
		//string for Questions
		final String[] People1 = {"EasyPQ1","EasyPQ2", "EasyPQ3","EasyPQ4"};
		Random random = new Random();
		final int index = random.nextInt(People1.length);
		JepordyPlayer question = new JepordyPlayer("Question");
		question.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//Display the window.
		question.setPreferredSize(new Dimension(600, 600));
	    question.setLocationRelativeTo(null);
		question.pack();       
		question.setVisible(true);
		Question = new JLabel("Question: ");
		JPanel QuestionDisplay = new JPanel();
		JPanel An = new JPanel();
		JPanel sub = new JPanel();
		QuestionDisplay.add(Question);
		GridLayout quest = new GridLayout(0,1);
		GridLayout answer = new GridLayout(0,1);
		An.setLayout(answer);
		sub.setLayout(answer);
		Question.setLayout(quest);
		An.add(Answer);
		sub.add(b);
		Question.setText("Question: " + People1[index]);
		Question.setFont(new Font("Dialog", Font.BOLD, 30));
		question.add(QuestionDisplay, BorderLayout.NORTH);
		question.add(An, BorderLayout.CENTER);
		question.add(sub, BorderLayout.SOUTH);
		//JOptionPane.showMessageDialog(null,People1[index]);

	}
	private void People2() {
		JButton b = new JButton("submit");
		 Answer = new JTextField(20);
		 Answers A = new Answers();
		 b.addActionListener(A);
		//string for Questions
		final String[] People2 = {"MediumPQ1","MediumPQ2", "MediumPQ3","MediumPQ4"};
		Random random = new Random();
		final int index = random.nextInt(People2.length);
		JepordyPlayer question = new JepordyPlayer("Question");
		question.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//Display the window.
		question.setPreferredSize(new Dimension(600, 600));
	    question.setLocationRelativeTo(null);
		question.pack();       
		question.setVisible(true);
		Question = new JLabel("Question: ");
		JPanel QuestionDisplay = new JPanel();
		JPanel An = new JPanel();
		JPanel sub = new JPanel();
		QuestionDisplay.add(Question);
		GridLayout quest = new GridLayout(0,1);
		GridLayout answer = new GridLayout(0,1);
		An.setLayout(answer);
		sub.setLayout(answer);
		Question.setLayout(quest);
		An.add(Answer);
		sub.add(b);
		Question.setText("Question: " + People2[index]);
		Question.setFont(new Font("Dialog", Font.BOLD, 30));
		question.add(QuestionDisplay, BorderLayout.NORTH);
		question.add(An, BorderLayout.CENTER);
		question.add(sub, BorderLayout.SOUTH);
		//JOptionPane.showMessageDialog(null,People2[index]);

	}
	private void People3() {
		JButton b = new JButton("submit");
		 Answer = new JTextField(20);
		 Answers A = new Answers();
		 b.addActionListener(A);
		//string for Questions
		final String[] People3 = {"HardPQ1","HardPQ2", "HardPQ3","HardPQ4"};
		Random random = new Random();
		final int index = random.nextInt(People3.length);
		JepordyPlayer question = new JepordyPlayer("Question");
		question.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//Display the window.
		question.setPreferredSize(new Dimension(600, 600));
	    question.setLocationRelativeTo(null);
		question.pack();       
		question.setVisible(true);
		Question = new JLabel("Question: ");
		JPanel QuestionDisplay = new JPanel();
		JPanel An = new JPanel();
		JPanel sub = new JPanel();
		QuestionDisplay.add(Question);
		GridLayout quest = new GridLayout(0,1);
		GridLayout answer = new GridLayout(0,1);
		An.setLayout(answer);
		sub.setLayout(answer);
		Question.setLayout(quest);
		An.add(Answer);
		sub.add(b);
		Question.setText("Question: " + People3[index]);
		Question.setFont(new Font("Dialog", Font.BOLD, 30));
		question.add(QuestionDisplay, BorderLayout.NORTH);
		question.add(An, BorderLayout.CENTER);
		question.add(sub, BorderLayout.SOUTH);
		//JOptionPane.showMessageDialog(null,People3[index]);

	}
	private void People4() {
		JButton b = new JButton("submit");
		 Answer = new JTextField(20);
		 Answers A = new Answers();
		 b.addActionListener(A);
		//string for Questions
		final String[] People4 = {"ExpertPQ1","ExpertPQ2", "ExpertPQ3","ExpertPQ4"};
		Random random = new Random();
		final int index = random.nextInt(People4.length);
		JepordyPlayer question = new JepordyPlayer("Question");
		question.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//Display the window.
		question.setPreferredSize(new Dimension(600, 600));
	    question.setLocationRelativeTo(null);
		question.pack();       
		question.setVisible(true);
		Question = new JLabel("Question: ");
		JPanel QuestionDisplay = new JPanel();
		JPanel An = new JPanel();
		JPanel sub = new JPanel();
		QuestionDisplay.add(Question);
		GridLayout quest = new GridLayout(0,1);
		GridLayout answer = new GridLayout(0,1);
		An.setLayout(answer);
		sub.setLayout(answer);
		Question.setLayout(quest);
		An.add(Answer);
		sub.add(b);
		Question.setText("Question: " + People4[index]);
		Question.setFont(new Font("Dialog", Font.BOLD, 30));
		question.add(QuestionDisplay, BorderLayout.NORTH);
		question.add(An, BorderLayout.CENTER);
		question.add(sub, BorderLayout.SOUTH);
		//JOptionPane.showMessageDialog(null,People4[index]);

	}
	private  void Planets1() {
		JButton b = new JButton("submit");
		 Answer = new JTextField(20);
		 Answers A = new Answers();
		 b.addActionListener(A);
		//string for Questions
		final String[] Planets1 = {"EasypQ1","EasypQ2", "EasypQ3","EasypQ4"};
		Random random = new Random();
		final int index = random.nextInt(Planets1.length);
		JepordyPlayer question = new JepordyPlayer("Question");
		question.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//Display the window.
		question.setPreferredSize(new Dimension(600, 600));
	    question.setLocationRelativeTo(null);
		question.pack();       
		question.setVisible(true);
		Question = new JLabel("Question: ");
		JPanel QuestionDisplay = new JPanel();
		JPanel An = new JPanel();
		JPanel sub = new JPanel();
		QuestionDisplay.add(Question);
		GridLayout quest = new GridLayout(0,1);
		GridLayout answer = new GridLayout(0,1);
		An.setLayout(answer);
		sub.setLayout(answer);
		Question.setLayout(quest);
		An.add(Answer);
		sub.add(b);
		Question.setText("Question: " + Planets1[index]);
		Question.setFont(new Font("Dialog", Font.BOLD, 30));
		question.add(QuestionDisplay, BorderLayout.NORTH);
		question.add(An, BorderLayout.CENTER);
		question.add(sub, BorderLayout.SOUTH);
		//JOptionPane.showMessageDialog(null,Planets1[index]);

	}
	private void Planets2() {
		JButton b = new JButton("submit");
		 Answer = new JTextField(20);
		 Answers A = new Answers();
		 b.addActionListener(A);
		//string for Questions
		final String[] Planets2 = {"MediumpQ1","MediumpQ2", "MediumpQ3","MediumpQ4"};
		Random random = new Random();
		final int index = random.nextInt(Planets2.length);
		JOptionPane.showMessageDialog(null,Planets2[index]);

	}
	private void Planets3() {
		JButton b = new JButton("submit");
		 Answer = new JTextField(20);
		 Answers A = new Answers();
		 b.addActionListener(A);
		//string for Questions
		final String[] Planets3 = {"HardpQ1","HardpQ2", "HardpQ3","HardpQ4"};
		Random random = new Random();
		final int index = random.nextInt(Planets3.length);
		JOptionPane.showMessageDialog(null,Planets3[index]);

	}
	private void Planets4() {
		JButton b = new JButton("submit");
		 Answer = new JTextField(20);
		 Answers A = new Answers();
		 b.addActionListener(A);
		//string for Questions
		final String[] Planets4 = {"ExpertAQ1","ExpertAQ2", "ExpertAQ3","ExpertAQ4"};
		Random random = new Random();
		final int index = random.nextInt(Planets4.length);
		JOptionPane.showMessageDialog(null,Planets4[index]);

	}
	private void Animals1() {
		JButton b = new JButton("submit");
		 Answer = new JTextField(20);
		 Answers A = new Answers();
		 b.addActionListener(A);
		//string for Questions
		final String[] Animals1 = {"EasyAQ1","EasyAQ2", "EasyAQ3","EasyAQ4"};
		Random random = new Random();
		final int index = random.nextInt(Animals1.length);
		JOptionPane.showMessageDialog(null,Animals1[index]);

	}
	private void Animals2() {
		JButton b = new JButton("submit");
		 Answer = new JTextField(20);
		 Answers A = new Answers();
		 b.addActionListener(A);
		//string for Questions
		final String[] Animals2 = {"MediumAQ1","MediumAQ2", "MediumAQ3","MediumAQ4"};
		Random random = new Random();
		final int index = random.nextInt(Animals2.length);
		JOptionPane.showMessageDialog(null,Animals2[index]);

	}
	private void Animals3() {
		JButton b = new JButton("submit");
		 Answer = new JTextField(20);
		 Answers A = new Answers();
		 b.addActionListener(A);
		//string for Questions
		final String[] Animals3 = {"HardAQ1","HardAQ2", "HardAQ3","HardAQ4"};
		Random random = new Random();
		final int index = random.nextInt(Animals3.length);
		JOptionPane.showMessageDialog(null,Animals3[index]);

	}
	private void Animals4() {
		JButton b = new JButton("submit");
		 Answer = new JTextField(20);
		 Answers A = new Answers();
		 b.addActionListener(A);
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
		//Buttons for questions
		World = new JButton("World");
		World.setBackground(Color.CYAN);
		World.setForeground(Color.BLACK);
		People = new JButton("People");
		People.setBackground(Color.CYAN);
		People.setForeground(Color.BLACK);
		Planets = new JButton("Planets");
		Planets.setBackground(Color.CYAN);
		Planets.setForeground(Color.BLACK);
		Animals = new JButton("Animals");
		Animals.setBackground(Color.CYAN);
		Animals.setForeground(Color.BLACK);
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
		W400.setForeground(Color.BLACK);
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
		P400.setForeground(Color.BLACK);
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
		p400.setForeground(Color.BLACK);
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
		A400.setForeground(Color.BLACK);
		//Action Listener For Question buttons
        SimpleListener Question = new SimpleListener();
        W100.addActionListener(Question);
        W200.addActionListener(Question);
        W300.addActionListener(Question);
        W400.addActionListener(Question);
        P100.addActionListener(Question);
        P200.addActionListener(Question);
        P300.addActionListener(Question);
        P400.addActionListener(Question);
        p100.addActionListener(Question);
        p200.addActionListener(Question);
        p300.addActionListener(Question);
        p400.addActionListener(Question);
        A100.addActionListener(Question);
        A200.addActionListener(Question);
        A300.addActionListener(Question);
        A400.addActionListener(Question);
		//JPanel to make bored
		Score = new JLabel("Score: ");
		Score1 = new JLabel("Score: ");
		Score2 = new JLabel("Score: ");
		JPanel Scoredisplay = new JPanel();
		Scoredisplay.add(Score);
		Scoredisplay.add(Score1);
		Scoredisplay.add(Score2);
		JPanel Master = new JPanel();
		JPanel Master2 = new JPanel();
		GridLayout Game = new GridLayout(0,4);
		GridLayout score = new GridLayout(0,3);
		Scoredisplay.setLayout(score);
		Score.setText("Player1: " + score1);
		Score1.setText("Player2: " + score2);
		Score2.setText("Player3: " + score3);
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
		JFrame quiz = new JFrame("Player" );
		quiz.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Display the window for the player side of the frame
		quiz.add(Scoredisplay, BorderLayout.SOUTH);
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
		Right.setForeground(Color.BLACK);
		Wrong = new JButton("Wrong");
		Wrong.setBackground(Color.RED);
		Wrong.setForeground(Color.BLACK);
		AnswerW = new JButton("World Answers");
		AnswerW.setBackground(Color.CYAN);
		AnswerW.setForeground(Color.BLACK);
		AnswerP = new JButton("People Answers");
		AnswerP.setBackground(Color.CYAN);
		AnswerP.setForeground(Color.BLACK);
		Answerpl = new JButton("Planets Answers");
		Answerpl.setBackground(Color.CYAN);
		Answerpl.setForeground(Color.BLACK);
		AnswerA = new JButton("Animals Answers");
		AnswerA.setBackground(Color.CYAN);
		AnswerA.setForeground(Color.BLACK);
		//Button on JPanel
		A.add(AnswerW);
		A.add(AnswerP);
		A.add(Answerpl);
		A.add(AnswerA);
		B.add(Right);
		B.add(Wrong);
		SimpleListener ourListener = new SimpleListener();
		Right.addActionListener(ourListener);
		AnswerW.addActionListener(ourListener);
		AnswerP.addActionListener(ourListener);
		Answerpl.addActionListener(ourListener);
		AnswerA.addActionListener(ourListener);
		SimpleListenerWrong wrong = new SimpleListenerWrong();
		Wrong.addActionListener(wrong);
		//Display the window.
		Quiz.add(B, BorderLayout.CENTER);
		Quiz.add(A, BorderLayout.SOUTH);
		Quiz.pack();
		Quiz.setVisible(true);  

	}
	private void Right() {
		//button for player score section
		RightPlayer1 = new JButton("Player1");
		RightPlayer1.setBackground(Color.RED);
		RightPlayer1.setForeground(Color.BLACK);
		RightPlayer2 = new JButton("Player2");
		RightPlayer2.setBackground(Color.GREEN);
		RightPlayer2.setForeground(Color.BLACK);
		RightPlayer3 = new JButton("Player3");
		RightPlayer3.setBackground(Color.BLUE);
		RightPlayer3.setForeground(Color.BLACK);
		SimpleListener ourListener = new SimpleListener();
		RightPlayer1.addActionListener(ourListener);
		RightPlayer2.addActionListener(ourListener);
		RightPlayer3.addActionListener(ourListener);
		JPanel Score = new JPanel();
		GridLayout Game = new GridLayout(1,0);
		Score.setLayout(Game);
		Score.add(RightPlayer1);
		Score.add(RightPlayer2);
		Score.add(RightPlayer3);
		JepordyPlayer right = new JepordyPlayer("Score");
		right.add(Score, BorderLayout.CENTER);
		right.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//Display the window.
		right.pack();       
		right.setVisible(true);
	}
	private void ScoreAdd() {
		//add Score Buttons
		Add = new JButton("+100");
		Add.setBackground(Color.GREEN);
		Add.setForeground(Color.BLACK);
		Add1 = new JButton("+200");
		Add1.setBackground(Color.GREEN);
		Add1.setForeground(Color.BLACK);
		Add2 = new JButton("+300");
		Add2.setBackground(Color.GREEN);
		Add2.setForeground(Color.BLACK);
		Add3 = new JButton("+400");
		Add3.setBackground(Color.GREEN);
		Add3.setForeground(Color.BLACK);
		//action for buttons
		SimpleListener1 ourListener1 = new SimpleListener1();
		Add.addActionListener(ourListener1);
		Add1.addActionListener(ourListener1);
		Add2.addActionListener(ourListener1);
		Add3.addActionListener(ourListener1);
		//panel for scores
		JPanel Scorep = new JPanel();
		GridLayout Game = new GridLayout(0,2);
		Scorep.setLayout(Game);
		Scorep.add(Add);
		Scorep.add(Add1);
		Scorep.add(Add2);
		Scorep.add(Add3);
		//JFrame for Score
		JepordyPlayer right = new JepordyPlayer("ScoreAdd");
		right.add(Scorep, BorderLayout.CENTER);
		right.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//Display the window.
		right.pack();       
		right.setVisible(true);
	}
	private void ScoreAdd1() {
		//add Score Buttons
		Add = new JButton("+100");
		Add.setBackground(Color.GREEN);
		Add.setForeground(Color.BLACK);
		Add1 = new JButton("+200");
		Add1.setBackground(Color.GREEN);
		Add1.setForeground(Color.BLACK);
		Add2 = new JButton("+300");
		Add2.setBackground(Color.GREEN);
		Add2.setForeground(Color.BLACK);
		Add3 = new JButton("+400");
		Add3.setBackground(Color.GREEN);
		Add3.setForeground(Color.BLACK);
		//action for buttons
		SimpleListener2 ourListener2 = new SimpleListener2();
		Add.addActionListener(ourListener2);
		Add1.addActionListener(ourListener2);
		Add2.addActionListener(ourListener2);
		Add3.addActionListener(ourListener2);
		//panel for scores
		JPanel Scorep = new JPanel();
		GridLayout Game = new GridLayout(0,2);
		Scorep.setLayout(Game);
		Scorep.add(Add);
		Scorep.add(Add1);
		Scorep.add(Add2);
		Scorep.add(Add3);
		//JFrame for Score
		JepordyPlayer right = new JepordyPlayer("ScoreAdd");
		right.add(Scorep, BorderLayout.CENTER);
		right.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//Display the window.
		right.pack();       
		right.setVisible(true);
	}
	private void ScoreAdd2() {
		//add Score Buttons
		Add = new JButton("+100");
		Add.setBackground(Color.GREEN);
		Add.setForeground(Color.BLACK);
		Add1 = new JButton("+200");
		Add1.setBackground(Color.GREEN);
		Add1.setForeground(Color.BLACK);
		Add2 = new JButton("+300");
		Add2.setBackground(Color.GREEN);
		Add2.setForeground(Color.BLACK);
		Add3 = new JButton("+400");
		Add3.setBackground(Color.GREEN);
		Add3.setForeground(Color.BLACK);
		//action for buttons
		SimpleListener3 ourListener3 = new SimpleListener3();
		Add.addActionListener(ourListener3);
		Add1.addActionListener(ourListener3);
		Add2.addActionListener(ourListener3);
		Add3.addActionListener(ourListener3);
		//panel for scores
		JPanel Scorep = new JPanel();
		GridLayout Game = new GridLayout(0,2);
		Scorep.setLayout(Game);
		Scorep.add(Add);
		Scorep.add(Add1);
		Scorep.add(Add2);
		Scorep.add(Add3);
		//JFrame for Score
		JepordyPlayer right = new JepordyPlayer("ScoreAdd");
		right.add(Scorep, BorderLayout.CENTER);
		right.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//Display the window.
		right.pack();       
		right.setVisible(true);
	}
	private void Wrong() {
		//button for player score section
		WrongPlayer1 = new JButton("Player1");
		WrongPlayer1.setBackground(Color.RED);
		WrongPlayer1.setForeground(Color.BLACK);
		WrongPlayer2 = new JButton("Player2");
		WrongPlayer2.setBackground(Color.GREEN);
		WrongPlayer2.setForeground(Color.BLACK);
		WrongPlayer3 = new JButton("Player3");
		WrongPlayer3.setBackground(Color.BLUE);
		WrongPlayer3.setForeground(Color.BLACK);
		SimpleListenerWrong Wrong = new SimpleListenerWrong();
		WrongPlayer1.addActionListener(Wrong);
		WrongPlayer2.addActionListener(Wrong);
		WrongPlayer3.addActionListener(Wrong);
		JPanel Score = new JPanel();
		GridLayout Game = new GridLayout(1,0);
		Score.setLayout(Game);
		Score.add(WrongPlayer1);
		Score.add(WrongPlayer2);
		Score.add(WrongPlayer3);
		JepordyPlayer right = new JepordyPlayer("Score");
		right.add(Score, BorderLayout.CENTER);
		right.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//Display the window.
		right.pack();       
		right.setVisible(true);
	}
	private void ScoreMinus() {
		//add Score Buttons
		Add = new JButton("-100");
		Add.setBackground(Color.GREEN);
		Add.setForeground(Color.BLACK);
		Add1 = new JButton("-200");
		Add1.setBackground(Color.GREEN);
		Add1.setForeground(Color.BLACK);
		Add2 = new JButton("-300");
		Add2.setBackground(Color.GREEN);
		Add2.setForeground(Color.BLACK);
		Add3 = new JButton("-400");
		Add3.setBackground(Color.GREEN);
		Add3.setForeground(Color.BLACK);
		//action for buttons
		SimpleListenerWrong Wrong = new SimpleListenerWrong();
		Add.addActionListener(Wrong);
		Add1.addActionListener(Wrong);
		Add2.addActionListener(Wrong);
		Add3.addActionListener(Wrong);
		//panel for scores
		JPanel Scorep = new JPanel();
		GridLayout Game = new GridLayout(0,2);
		Scorep.setLayout(Game);
		Scorep.add(Add);
		Scorep.add(Add1);
		Scorep.add(Add2);
		Scorep.add(Add3);
		//JFrame for Score
		JepordyPlayer right = new JepordyPlayer("ScoreMinus");
		right.add(Scorep, BorderLayout.CENTER);
		right.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//Display the window.
		right.pack();       
		right.setVisible(true);
	}
	private void ScoreMinus1() {
		//add Score Buttons
		Add = new JButton("-100");
		Add.setBackground(Color.GREEN);
		Add.setForeground(Color.BLACK);
		Add1 = new JButton("-200");
		Add1.setBackground(Color.GREEN);
		Add1.setForeground(Color.BLACK);
		Add2 = new JButton("-300");
		Add2.setBackground(Color.GREEN);
		Add2.setForeground(Color.BLACK);
		Add3 = new JButton("-400");
		Add3.setBackground(Color.GREEN);
		Add3.setForeground(Color.BLACK);
		//action for buttons
		SimpleListenerWrong1 Wrong = new SimpleListenerWrong1();
		Add.addActionListener(Wrong);
		Add1.addActionListener(Wrong);
		Add2.addActionListener(Wrong);
		Add3.addActionListener(Wrong);
		//panel for scores
		JPanel Scorep = new JPanel();
		GridLayout Game = new GridLayout(0,2);
		Scorep.setLayout(Game);
		Scorep.add(Add);
		Scorep.add(Add1);
		Scorep.add(Add2);
		Scorep.add(Add3);
		//JFrame for Score
		JepordyPlayer right = new JepordyPlayer("ScoreMinus");
		right.add(Scorep, BorderLayout.CENTER);
		right.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//Display the window.
		right.pack();       
		right.setVisible(true);
	}
	private void ScoreMinus2() {
		//add Score Buttons
		Add = new JButton("-100");
		Add.setBackground(Color.GREEN);
		Add.setForeground(Color.BLACK);
		Add1 = new JButton("-200");
		Add1.setBackground(Color.GREEN);
		Add1.setForeground(Color.BLACK);
		Add2 = new JButton("-300");
		Add2.setBackground(Color.GREEN);
		Add2.setForeground(Color.BLACK);
		Add3 = new JButton("-400");
		Add3.setBackground(Color.GREEN);
		Add3.setForeground(Color.BLACK);
		//action for buttons
		SimpleListenerWrong2 Wrong = new SimpleListenerWrong2();
		Add.addActionListener(Wrong);
		Add1.addActionListener(Wrong);
		Add2.addActionListener(Wrong);
		Add3.addActionListener(Wrong);
		//panel for scores
		JPanel Scorep = new JPanel();
		GridLayout Game = new GridLayout(0,2);
		Scorep.setLayout(Game);
		Scorep.add(Add);
		Scorep.add(Add1);
		Scorep.add(Add2);
		Scorep.add(Add3);
		//JFrame for Score
		JepordyPlayer right = new JepordyPlayer("ScoreMinus");
		right.add(Scorep, BorderLayout.CENTER);
		right.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//Display the window.
		right.pack();       
		right.setVisible(true);
	}
	//Closes The Frame out
	public void CloseFrame(){
		super.dispose();
	}
}


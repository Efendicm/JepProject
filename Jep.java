import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
 
public class JepordyPlayer extends JFrame {
	//Combo box being named
	private static JComboBox World;
	private static JComboBox People;
	private static JComboBox Planets;
	private static JComboBox Animals;
	private static JFrame frame; //Define static variables for main to use
	private JButton button1; //Define the button component here
    private JButton button2; //To enable ActionListener to use
    GridLayout Intro = new GridLayout(2,2);
     
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
        Rules.add(explain);
        //Action listner to buttons
        final Button player = new Button("Quiz Master");
        //Add buttons
        Quiz.add(button1); //Add buttons to the panel
        Player.add(button2);
        //Player.add(new JButton("Quiz Master"));
        //Quiz.add(new JButton("Answer Questions"));
         
        //Actives Buttons
        pane.add(Intro, BorderLayout.NORTH);
        pane.add(Player, BorderLayout.WEST);
        pane.add(Rules, BorderLayout.CENTER);
        pane.add(Quiz, BorderLayout.EAST);
    }
     
    private class SimpleListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
         String buttonName = e.getActionCommand();
		if (buttonName.equals("Quiz Master"))
		{
			QuizMaster();
			CloseFrame();//Remove frame
        	
     }
         	else if (buttonName.equals("Player")) {
         		Player();
         		CloseFrame();
         	}
         		
         	else
         		JOptionPane.showMessageDialog(frame,
         				"Unknown event" );
			
		}
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
    	//string for the comboBoxs
    	String q1[] = {"100", "200", "300", "400" };
    	String q2[] = {"100", "200", "300", "400" };
    	String q3[] = {"100", "200", "300", "400" };
    	String q4[] = {"100", "200", "300", "400" };
    	//Create Combo Boxes
    	World = new JComboBox(q1);
        World.setRenderer(new MyComboBox("World"));
        World.setSelectedIndex(-1);
    	People = new JComboBox(q2);
    	People.setRenderer(new MyComboBox("People"));
        People.setSelectedIndex(-1);
    	Planets = new JComboBox(q3);
    	Planets.setRenderer(new MyComboBox("Planets"));
        Planets.setSelectedIndex(-1);
    	Animals = new JComboBox(q4);
    	Animals.setRenderer(new MyComboBox("Animals"));
        Animals.setSelectedIndex(-1);
    	JPanel Master = new JPanel();
    	JPanel Master2 = new JPanel();
    	JPanel Master3 = new JPanel();
    	JPanel Master4 = new JPanel();
    	 GridLayout Game = new GridLayout(0,4);
        Master.setLayout(Game);
        //Master2.setLayout(Game);
        //Master3.setLayout(Game);
        //Master4.setLayout(Game);
        //Master.setBorder(BorderFactory.createTitledBorder("WORLD"));
       // Master.setBorder(BorderFactory.createTitledBorder("PEOPLE"));
       // Master.setBorder(BorderFactory.createTitledBorder("PLANETS"));
        Master.setBorder(BorderFactory.createTitledBorder("WORLD,                           	                                                                                                                                                                                                                                            PEOPLE,                                                                                                                                                                                                                                                                               PLANETS,                                                                                                                                                                                                                                                                             ANIMALS"));
        Master.add(World);
        Master.add(People);
        Master.add(Planets);
        Master.add(Animals);
        JFrame quiz = new JFrame("QuizMaster" );
        quiz.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Set up the content pane.
        //frame.addComponentsToPane(frame.getContentPane());
        //Display the window.
        quiz.add(Master, BorderLayout.NORTH);
        //quiz.add(Master2, BorderLayout.EAST);
        //quiz.add(Master3, BorderLayout.WEST);
        //quiz.add(Master4, BorderLayout.CENTER);
        quiz.pack();
        quiz.setVisible(true);   

    }
    private void QuizMaster() {
        JFrame Quiz = new JFrame("Quiz MAster" );
        Quiz.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Set up the content pane.
        //frame.addComponentsToPane(frame.getContentPane());
        //Display the window.
        Quiz.pack();
        Quiz.setVisible(true);   

    }
    public void CloseFrame(){
        super.dispose();
    }
    class MyComboBox extends JLabel implements ListCellRenderer
    {
        private String _title;

        public MyComboBox(String title)
        {
            _title = title;
        }

        @Override
        public Component getListCellRendererComponent(JList list, Object value,
                int index, boolean isSelected, boolean hasFocus)
        {
            if (index == -1 && value == null) setText(_title);
            else setText(value.toString());
            return this;
        }
    }
}


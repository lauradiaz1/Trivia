import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.awt.image.BufferedImage; 

public class Game implements ActionListener{

	String[] questions = {
			               "What is Tennessee's nickname?",
			               "What is California's nickname?",
			               "What is Kentucky's nickname?",
			               "What is Missouri's nickname?",
			               "What is Mississippi's nickname?",
			               "What is Montana's nickname?",
			               "What is Texas' nickname?",
			               "What is Idaho's nickname?",
			               "What is Utah's nickname?",
			               "What is Ohio's nickname?",
			               "What is Oregon's nickname?",
			               "What is New York's nickname?",
			               "What is West Virginia's nickname?",
			               "What is Wyoming's nickname?",
			               "What is Oklahoma's nickname?",
			               "What is Rhode Islands' nickname?",
			               "What is Pennsylvania's nickname?",
			               "What is Kansas' nickname?",
			               "What is Georgia's nickname?",
			               "What is Louisiana's nickname?"
			               
	};
	
	String[][] options = {
			             {"The Iron State", "The Volunteer State", "Fried Chicken State", "Pickle State"},
			             {"The Golden State", "Rush State", "The Bronze State", "Hollywood State"},
			             {"Fried Chicken State", "The Bourbon State", "The Limestone State", "The Bluegrass State"},
			             {"Show Me State", "The Jazz State", "The Oversized State", "The Pecan State"},
			             {"The River State", "Southern Charm State", "The Magnolia State", "Cotton Capital"},
			             {"Yellowstone State", "Treasure State", "Terrain State", "Mineral Mine State"},
			             {"The Bluebonnet State", "Star State", "The Longhorn State", "The Lone Star State"},
			             {"Potato State", "Gem State", "The Canyon State", "Farm State"},
			             {"The Skii State", "Salt Lake State", "Beehive State", "Mormon State"},
			             {"Buckeye State", "Cradle of Aviation", "The Rock and Roll State", "The River State"},
			             {"Beaver State", "Otter State", "The Wood State", "Mount Hood State"},
			             {"Lady Liberty State", "Wall Street State", "The Skyscraper State", "Empire State"},
			             {"Hiking State", "Whitewater State", "Mountain State", "Half State"},
			             {"National Park State", "Equality State", "Wildlife State", "Plain State"},
			             {"Sooner State", "Okra State", "The Grit State", "Oil State"},
			             {"The Jewel State", "Termite State", "The Hope State", "Ocean State"},
			             {"Coal State", "The Mine State", "Keystone State", "Mushroom State"},
			             {"Wizard State", "The Plain State", "Wheat State", "Sunflower State"},
			             {"Peanut State", "Peach State", "Coca-Cola State", "Climate State"},
			             {"Pelican State", "The Gumbo State", "Mardi Gras State", "The Seafood State"}
			            
			
	};
	
	char[] answers = {
			           'B',
			           'A',
			           'D',
			           'A',
			           'C',
			           'B',
			           'D',
			           'B',
			           'C',
			           'A',
			           'A',
			           'D',
			           'C',
			           'B',
			           'A',
			           'D',
			           'C',
			           'D',
			           'B',
			           'A'
	};
	
	char guess;
	char answer;
	int index;
	//int correct_guesses = 0;
	int correct_guess = 0;
	int total_questions = questions.length;
	int result;
	int seconds=10;

	
	
	JFrame frame = new JFrame();
	JTextField textfield = new JTextField();
	JTextArea textarea = new JTextArea();
	JButton buttonA = new JButton();
	JButton buttonB = new JButton();
	JButton buttonC = new JButton();
	JButton buttonD = new JButton();
	JLabel answer_labelA = new JLabel();
	JLabel answer_labelB = new JLabel();
	JLabel answer_labelC = new JLabel();
	JLabel answer_labelD = new JLabel();
	JLabel time_label = new JLabel();
	JLabel seconds_left = new JLabel();
	JTextField number_right = new JTextField();
	JTextField percentage = new JTextField();
	
	
	
	Timer timer = new Timer(1000, new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			seconds--;
			seconds_left.setText(String.valueOf(seconds));
			if(seconds<=0) {
				displayAnswer();
			}
		}
	});
	
	public Game() {
		
		

		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,750);
		// set background
		frame.getContentPane().setBackground(new Color(246,203,168));
		frame.setLayout(null);
		frame.setResizable(false);
		
		textfield.setBounds(0,0,850,50);
		textfield.setBackground(new Color(250,252,162));
		//color of question label
		textfield.setForeground(new Color(0,0,0));
		textfield.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		textfield.setBorder(BorderFactory.createBevelBorder(1));
		textfield.setHorizontalAlignment(JTextField.CENTER);
		textfield.setEditable(false);
		
		textarea.setBounds(0,50,850,50);
		textarea.setLineWrap(true);
		textarea.setWrapStyleWord(true);
		textarea.setBackground(new Color(250,252,162));
		//color of title
		textarea.setForeground(new Color(0,0,0));
		//font of questions
		textarea.setFont(new Font("Times New Roman", Font.BOLD, 25));
		textarea.setBorder(BorderFactory.createBevelBorder(1));
		textarea.setEditable(false);

		buttonA.setBounds(10,120,100,100);
		buttonA.setFont(new Font("Times New Roman", Font.BOLD, 35));
		buttonA.setFocusable(false);
		buttonA.addActionListener(this);
		buttonA.setText("A");
		
		buttonB.setBounds(10,270,100,100);
		buttonB.setFont(new Font("Times New Roman", Font.BOLD, 35));
		buttonB.setFocusable(false);
		buttonB.addActionListener(this);
		buttonB.setText("B");
		
		buttonC.setBounds(10,420,100,100);
		buttonC.setFont(new Font("Times New Roman", Font.BOLD, 35));
		buttonC.setFocusable(false);
		buttonC.addActionListener(this); 
		buttonC.setText("C");
		
		buttonD.setBounds(10,570,100,100);
		buttonD.setFont(new Font("Times New Roman", Font.BOLD, 35));
		buttonD.setFocusable(false);
		buttonD.addActionListener(this);
		buttonD.setText("D");
		
		//text next to the button
		answer_labelA.setBounds(135, 120, 500, 100);
		answer_labelA.setBackground(new Color(50,50,0));
		answer_labelA.setForeground(new Color(255,255,255));
		answer_labelA.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		//answer_labelA.setText("Testing Label 1");
		
		answer_labelB.setBounds(135, 270, 500, 100);
		answer_labelB.setBackground(new Color(50,50,0));
		answer_labelB.setForeground(new Color(255,255,255));
		answer_labelB.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		//answer_labelB.setText("Testing Label 2");
		
		answer_labelC.setBounds(135, 420, 500, 100);
		answer_labelC.setBackground(new Color(50,50,0));
		answer_labelC.setForeground(new Color(255,255,255));
		answer_labelC.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		//answer_labelC.setText("Testing Label 3");
		
		answer_labelD.setBounds(135, 570, 500, 100);
		answer_labelD.setBackground(new Color(50,50,0));
		answer_labelD.setForeground(new Color(255,255,255));
		answer_labelD.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		//answer_labelD.setText("Testing Label 4");
		
		seconds_left.setBounds(600,510,100,150);
		seconds_left.setBackground(new Color (197,197,197));
		seconds_left.setForeground(new Color(255,255,255));
		seconds_left.setFont(new Font("Times New Roman", Font.PLAIN, 60));
		seconds_left.setBorder(BorderFactory.createBevelBorder(1));
		seconds_left.setOpaque(true);
		seconds_left.setHorizontalAlignment(JTextField.CENTER);
		seconds_left.setText(String.valueOf(seconds));
		
		
		
		number_right.setBounds(225,225,200,100);
		number_right.setBackground(new Color(250,252,162));
		number_right.setForeground(new Color(0,0,0));
		number_right.setFont(new Font("Times New Roman", Font.BOLD, 50));
		number_right.setBorder(BorderFactory.createBevelBorder(1));
		number_right.setHorizontalAlignment(JTextField.CENTER);
		number_right.setEditable(false);
		
		percentage.setBounds(225,325,200,100);
		percentage.setBackground(new Color(250,252,162));
		percentage.setForeground(new Color(0,0,0));
		percentage.setFont(new Font("Times New Roman", Font.BOLD, 50));
		percentage.setBorder(BorderFactory.createBevelBorder(1));
		percentage.setHorizontalAlignment(JTextField.CENTER);
		percentage.setEditable(false);
		
		//frame.add(number_right);
		//frame.add(percentage);
		frame.add(time_label);
		frame.add(seconds_left);
		frame.add(answer_labelA);
		frame.add(answer_labelB);
		frame.add(answer_labelC);
		frame.add(answer_labelD);
		frame.add(buttonA);
		frame.add(buttonB);
		frame.add(buttonC);
		frame.add(buttonD);
		frame.add(textarea);
		frame.add(textfield);
		frame.setVisible(true);
		
		nextQuestion();
		
	
	
	}
	public void nextQuestion() {
		if(index>=total_questions) {
			results();
		}
		else {
			textfield.setText("Question" + (index+1));
			textarea.setText(questions[index]);
			answer_labelA.setText(options[index][0]);
			answer_labelB.setText(options[index][1]);
			answer_labelC.setText(options[index][2]);
			answer_labelD.setText(options[index][3]);
			timer.start();
		}
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);
		
		if(arg0.getSource()==buttonA) {
			answer ='A';
			if(answer == answers[index]) {
				correct_guess++;
			}
		}
		if(arg0.getSource()==buttonB) {
			answer ='B';
			if(answer == answers[index]) {
				correct_guess++;
			}
		}
		if(arg0.getSource()==buttonC) {
			answer ='C';
			if(answer == answers[index]) {
				correct_guess++;
			}
		}
		if(arg0.getSource()==buttonD) {
			answer ='D';
			if(answer == answers[index]) {
				correct_guess++;
			}
		}
		displayAnswer();
	}
	public void displayAnswer() {
		
		timer.stop();
		
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);
		
		//red for wrong answers
		if(answers[index] != 'A') 
			answer_labelA.setForeground(new Color(255,0,0));
		if(answers[index] != 'B') 
			answer_labelB.setForeground(new Color(255,0,0));
		if(answers[index] != 'C') 
			answer_labelC.setForeground(new Color(255,0,0));
		if(answers[index] != 'D') 
			answer_labelD.setForeground(new Color(255,0,0));
		
		Timer pause = new Timer(2000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				answer_labelA.setForeground(new Color(255,255,255));
				answer_labelB.setForeground(new Color(255,255,255));
				answer_labelC.setForeground(new Color(255,255,255));
				answer_labelD.setForeground(new Color(255,255,255));
				
				answer = ' ';
				seconds=10;
				seconds_left.setText(String.valueOf(seconds));
				buttonA.setEnabled(true);
				buttonB.setEnabled(true);
				buttonC.setEnabled(true);
				buttonD.setEnabled(true);
				index++;
				nextQuestion();
			}
			
		});
		pause.setRepeats(false);
		pause.start();
		
		
		
		
	}
	public void results() {
		
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);
		
		
		result = (int)((correct_guess /(double)total_questions)*100);
		 
		textfield.setText("Results!");
		textarea.setText("");
		answer_labelA.setText("");
		answer_labelB.setText("");
		answer_labelC.setText("");
		answer_labelD.setText("");
		
		number_right.setText("(" + correct_guess +"/"+total_questions + ")");
		percentage.setText(result+ "%");
		
		frame.add(number_right);
		frame.add(percentage);
	}
}




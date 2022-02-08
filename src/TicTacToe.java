import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

//this is where we imported the action listeners
public class TicTacToe extends JFrame implements ActionListener //here we created the actual class that we used and also implemented the action listener
{
	private	JButton topLeft, topCenter, topRight, midLeft, midCenter, midRight, botLeft, botCenter, botRight;
	private	JButton resetB, PvP, PvCpuEasy, CpuvCpu;//here in the code we created all the buttons we're using so far
	private JLabel xWins,oWins, note, turnShow;//here we created a couple labels for later 
	boolean gameEnd;
	String turn, winner, gameMode;
	int numTurns, score1, score2;
	Container window;
	//here in the code we created the veriables necessary for our game to be possible
	
	public TicTacToe()
	{
		playSound();
		window = getContentPane();
		window.setLayout(null);
		window.setBackground(Color.black);
		setSize(600,755);
		setResizable(false);
		setLocation(1000,250);
		setTitle("Calculator");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//here we created the platform needed for our board
		/*in this "paragraph" of code we created the 
		 window in which our board will be placed */
		
		makeButtons();
		//calls for "makeButtons"
		
		winner = "x";
		note = new JLabel("Welcome to Tic-Tac-Toe. Please Select A GameMode");
		note.setBounds(0, 0, 600, 67);
		note.setOpaque(true);
		note.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
		note.setHorizontalAlignment(SwingConstants.CENTER);
		note.setFont(new Font("Arial", Font.BOLD, 20));
		window.add(note);
		//here is what the outcome would be if the X 
		
		score1 = 0;
		xWins = new JLabel("X Wins:" + score1);
		xWins.setBounds(0, 67, 200, 67);
		xWins.setOpaque(true);
		xWins.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
		xWins.setHorizontalAlignment(SwingConstants.CENTER);
		xWins.setFont(new Font("Arial", Font.BOLD, 30));
		/* here we created an outcome for if the opponent
		  that is playing as the "X" happens to win */
		turn = "X";
		turnShow = new JLabel("It is " + turn + " turn");
		turnShow.setBounds(200, 67, 200, 67);
		turnShow.setOpaque(true);
		turnShow.setHorizontalAlignment(SwingConstants.CENTER);
		turnShow.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
		turnShow.setFont(new Font("Arial", Font.BOLD, 30));
		// here is how we get the "X" opponent to take their turn
		score2 = 0;
		oWins = new JLabel("O Wins:" + score2);
		oWins.setBounds(400, 67, 200, 67);
		oWins.setOpaque(true);
		oWins.setHorizontalAlignment(SwingConstants.CENTER);
		oWins.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
		oWins.setFont(new Font("Arial", Font.BOLD, 30));
		/* here we created an outcome for if the opponent
		  that is playing as the "O" happens to win */
		setVisible(true);
	}
	public void playSound() //plays music 
	{
		int randSong = (int) (Math.random() * 3 + 1);
	    try {
	        AudioInputStream song1 = AudioSystem.getAudioInputStream(new File("Porter Robinson  Madeon - Shelter (Official Audio).wav").getAbsoluteFile());
	        AudioInputStream song2 = AudioSystem.getAudioInputStream(new File("Porter Robinson - Flicker (Official Video).wav").getAbsoluteFile());
	        AudioInputStream song3 = AudioSystem.getAudioInputStream(new File("Porter Robinson - Sad Machine (Lyric Video).wav").getAbsoluteFile());
	        Clip clip = AudioSystem.getClip();
	        if(randSong == 1)
	        {
	        	 clip.open(song1);
	        }
	        if(randSong == 2)
	        {
	        	 clip.open(song2);
	        }
	        if(randSong == 3)
	        {
	        	 clip.open(song3);
	        }
	        clip.start();
	    } catch(Exception ex) {
	        System.out.println("Error with playing sound.");
	        ex.printStackTrace();
	    }
	}
	public void makeButtons()
	{
		PvP = new JButton("Player V.S Player");
		PvP.setBounds(0, 67, 200, 67);
		PvP.addActionListener(this);
		PvP.setHorizontalAlignment(SwingConstants.CENTER);
		PvP.setFont(new Font("Arial", Font.BOLD, 15));
		window.add(PvP);//creates PvP choice 
		
		PvCpuEasy = new JButton("Player V.S CPU(Easy)");
		PvCpuEasy.setBounds(200, 67, 200, 67);
		PvCpuEasy.addActionListener(this);
		PvCpuEasy.setHorizontalAlignment(SwingConstants.CENTER);
		PvCpuEasy.setFont(new Font("Arial", Font.BOLD, 15));
		window.add(PvCpuEasy);//creates PvCPU choice 
		
		CpuvCpu = new JButton("CPU V.S CPU");
		CpuvCpu.setBounds(400, 67, 200, 67);
		CpuvCpu.addActionListener(this);
		CpuvCpu.setHorizontalAlignment(SwingConstants.CENTER);
		CpuvCpu.setFont(new Font("Arial", Font.BOLD, 15));
		window.add(CpuvCpu);//creates CPUvCPU choice 
		
		resetB = new JButton("Restart");
		resetB.setBounds(200, 67, 200, 67);
		resetB.addActionListener(this);
		resetB.setHorizontalAlignment(SwingConstants.CENTER);
		resetB.setFont(new Font("Arial", Font.BOLD, 15));
		resetB.setVisible(false);
		window.add(resetB);//reset button to reset the game/ scores
		
		topLeft = new JButton("");
		topLeft.setBounds(15, 154, 170, 170);
		topLeft.setHorizontalAlignment(SwingConstants.CENTER);
		topLeft.setFont(new Font("Arial", Font.BOLD, 75));
		window.add(topLeft);
		//here is where the top left side of our game board is being brought to life
		topCenter = new JButton("");
		topCenter.setBounds(210, 154, 170, 170);
		topCenter.setHorizontalAlignment(SwingConstants.CENTER);
		topCenter.setFont(new Font("Arial", Font.BOLD, 75));
		window.add(topCenter);
		//in this area of code we create the top center of our tic tac toe board
		topRight = new JButton("");
		topRight.setBounds(410, 154, 170, 170);
		topRight.setHorizontalAlignment(SwingConstants.CENTER);
		topRight.setFont(new Font("Arial", Font.BOLD, 75));
		window.add(topRight);
		//here we create the top right of our board
		midLeft = new JButton("");
		midLeft.setBounds(15, 350, 170, 170);
		midLeft.setHorizontalAlignment(SwingConstants.CENTER);
		midLeft.setFont(new Font("Arial", Font.BOLD, 75));
		window.add(midLeft);
		/* here in this paragraph of code we 
		 * created a button that we then set the bounds of
		 * thus creating the mid left of out board
		 */
		midCenter = new JButton("");
		midCenter.setBounds(210, 350, 170, 170);
		midCenter.setHorizontalAlignment(SwingConstants.CENTER);
		midCenter.setFont(new Font("Arial", Font.BOLD, 75));
		window.add(midCenter);
		/* in the area here we created a button and then
		 * set its bounds, creating our mid center of our game board
		 */
		midRight = new JButton("");
		midRight.setBounds(410, 350, 170, 170);
		midRight.setHorizontalAlignment(SwingConstants.CENTER);
		midRight.setFont(new Font("Arial", Font.BOLD, 75));
		window.add(midRight);
		/*here in the paragraph above we made a new button 
		 * and set its bounds, creating our mid right section of 
		 * our game board
		 */
		botLeft = new JButton("");
		botLeft.setBounds(15, 550, 170, 170);
		botLeft.setHorizontalAlignment(SwingConstants.CENTER);
		botLeft.setFont(new Font("Arial", Font.BOLD, 75));
		window.add(botLeft);
		/* in this section of code we created a button that happens to be new
		 * and told it where to show up at by setting its bounds
		 * creating the bottom left of our board
		 */
		botCenter = new JButton("");
		botCenter.setBounds(210, 550, 170, 170);
		botCenter.setHorizontalAlignment(SwingConstants.CENTER);
		botCenter.setFont(new Font("Arial", Font.BOLD, 75));
		window.add(botCenter);
		/* in this section of code we created a button that happens to be new
		 * and told it where to show up at by setting its bounds
		 * creating the bottom center of our board
		 */
		botRight = new JButton("");
		botRight.setBounds(410, 550, 170, 170);
		botRight.setHorizontalAlignment(SwingConstants.CENTER);
		botRight.setFont(new Font("Arial", Font.BOLD, 75));
		window.add(botRight);
		/* in this section of code we created a button that happens to be new
		 * and told it where to show up at by setting its bounds
		 * creating the bottom right of our board
		 */
	}
	public void setButton(ActionEvent e)
	{
		JButton clicked = (JButton) e.getSource();
		if(turn == "X")
		{
			clicked.setText("X");
			winner = "X";
			turn = "O";
			// this part of the code is to tell the game that once x goes its then o's turn
		}
		else if(turn == "O")
		{
			clicked.setText("O");
			winner = "O";
			turn = "X";
		}
		//this part is to tell the tells the game that once o goes its x's turn
		turnShow.setText("It is " + turn + " turn");
		//this line prints the message that informs the players its their opponents turn
	}
	public void hideModeChoose()
	{
		PvP.setVisible(false);
		PvCpuEasy.setVisible(false);
		CpuvCpu.setVisible(false);
		window.add(xWins);
		window.add(oWins);
		window.add(turnShow);
		note.setText("Tic-Tac-Toe");
		topLeft.addActionListener(this);
		topCenter.addActionListener(this);
		topRight.addActionListener(this);
		midLeft.addActionListener(this);
		midCenter.addActionListener(this);
		midRight.addActionListener(this);
		botLeft.addActionListener(this);
		botCenter.addActionListener(this);
		botRight.addActionListener(this);
	}
	public void goNext()
	{
		String askNext = winner;
	    JFrame frame = new JFrame("next");
	    JOptionPane.showMessageDialog(frame, askNext);
	 }
	public void oneBot(ActionEvent e)
	{
		int place = (int) (Math.random() * 9 + 1);
		while(turn.equals("O"))
		{
			if(place == 1 && topLeft.getText().equals(""))
			{
				topLeft.setText("O");
				turn = "X";
				winner = "O";
			}
			else if(place == 2 && topCenter.getText().equals(""))
			{
				topCenter.setText("O");
				turn = "X";
				winner = "O";
			}
			else if(place == 3 && topRight.getText().equals(""))
			{
				topRight.setText("O");
				turn = "X";
				winner = "O";
			}
			else if(place == 4 && midLeft.getText().equals(""))
			{
				midLeft.setText("O");
				turn = "X";
				winner = "O";
			}
			else if(place == 5 && midCenter.getText().equals(""))
			{
				midCenter.setText("O");
				turn = "X";
				winner = "O";
			}
			else if(place == 6 && midRight.getText().equals(""))
			{
				midRight.setText("O");
				turn = "X";
				winner = "O";
			}
			else if(place == 7 && botLeft.getText().equals(""))
			{
				botLeft.setText("O");
				turn = "X";
				winner = "O";
			}
			else if(place == 8 && botCenter.getText().equals(""))
			{
				botCenter.setText("O");
				turn = "X";
				winner = "O";
			}
			else if(place == 9 && botRight.getText().equals(""))
			{
				botRight.setText("O");
				turn = "X";
				winner = "O";
			}
			place = (int) (Math.random() * 9 + 1);
			checkWin();
		}
		numTurns++;
	}
	public void twoBot(ActionEvent e)
	{
		int place = (int) (Math.random() * 9 + 1);
		int timesLooped = 0;
		while(turn.equals("X") && timesLooped <= 9)
		{
			if(place == 1 && topLeft.getText().equals(""))
			{
				topLeft.setText("X");
				turn = "O";
				winner = "X";
			}
			else if(place == 2 && topCenter.getText().equals(""))
			{
				topCenter.setText("X");
				turn = "O";
				winner = "X";
			}
			else if(place == 3 && topRight.getText().equals(""))
			{
				topRight.setText("X");
				turn = "O";
				winner = "X";
			}
			else if(place == 4 && midLeft.getText().equals(""))
			{
				midLeft.setText("X");
				turn = "O";
				winner = "X";
			}
			else if(place == 5 && midCenter.getText().equals(""))
			{
				midCenter.setText("X");
				turn = "O";
				winner = "X";
			}
			else if(place == 6 && midRight.getText().equals(""))
			{
				midRight.setText("X");
				turn = "O";
				winner = "X";
			}
			else if(place == 7 && botLeft.getText().equals(""))
			{
				botLeft.setText("X");
				turn = "O";
				winner = "X";
			}
			else if(place == 8 && botCenter.getText().equals(""))
			{
				botCenter.setText("X");
				turn = "O";
				winner = "X";
			}
			else if(place == 9 && botRight.getText().equals(""))
			{
				botRight.setText("X");
				turn = "O";
				winner = "X";
			}
			place = (int) (Math.random() * 9 + 1);
			timesLooped++;
		}
		while(turn.equals("O") && timesLooped <=9)
		{
			if(place == 1 && topLeft.getText().equals(""))
			{
				topLeft.setText("O");
				turn = "X";
				winner = "O";
			}
			else if(place == 2 && topCenter.getText().equals(""))
			{
				topCenter.setText("O");
				turn = "X";
				winner = "O";
			}
			else if(place == 3 && topRight.getText().equals(""))
			{
				topRight.setText("O");
				turn = "X";
				winner = "O";
			}
			else if(place == 4 && midLeft.getText().equals(""))
			{
				midLeft.setText("O");
				turn = "X";
				winner = "O";
			}
			else if(place == 5 && midCenter.getText().equals(""))
			{
				midCenter.setText("O");
				turn = "X";
				winner = "O";
			}
			else if(place == 6 && midRight.getText().equals(""))
			{
				midRight.setText("O");
				turn = "X";
				winner = "O";
			}
			else if(place == 7 && botLeft.getText().equals(""))
			{
				botLeft.setText("O");
				turn = "X";
				winner = "O";
			}
			else if(place == 8 && botCenter.getText().equals(""))
			{
				botCenter.setText("O");
				turn = "X";
				winner = "O";
			}
			else if(place == 9 && botRight.getText().equals(""))
			{
				botRight.setText("O");
				turn = "X";
				winner = "O";
			}
			place = (int) (Math.random() * 9 + 1);
			timesLooped++;
			checkWin();
		}
		numTurns++;
		timesLooped = 0;
	}
	public void checkWin()
	{
		if(topLeft.getText().equals(topCenter.getText()) && topCenter.getText().equals(topRight.getText()) && !topLeft.getText().equals(""))
		{
			winner = winner + " is the winner";
			topLeft.setForeground(Color.RED);
			topCenter.setForeground(Color.RED);
			topRight.setForeground(Color.RED);
			addScore(topLeft);
			goNext();
			reset();
		}
		else if(midLeft.getText().equals(midCenter.getText()) && midCenter.getText().equals(midRight.getText()) && !midLeft.getText().equals(""))
		{
			winner = winner + " is the winner";
			midLeft.setForeground(Color.RED);
			midCenter.setForeground(Color.RED);
			midRight.setForeground(Color.RED);
			addScore(midLeft);
			goNext();
			reset();
		}
		else if(botLeft.getText().equals(botCenter.getText()) && botCenter.getText().equals(botRight.getText()) && !botLeft.getText().equals(""))
		{
			winner = winner + " is the winner";
			botLeft.setForeground(Color.RED);
			botCenter.setForeground(Color.RED);
			botRight.setForeground(Color.RED);
			addScore(botLeft);
			goNext();
			reset();
		}
		else if(topLeft.getText().equals(midLeft.getText()) && midLeft.getText().equals(botLeft.getText()) && !topLeft.getText().equals(""))
		{
			winner = winner + " is the winner";
			topLeft.setForeground(Color.RED);
			midLeft.setForeground(Color.RED);
			botLeft.setForeground(Color.RED);
			addScore(botLeft);
			goNext();
			reset();
		}
		else if(topCenter.getText().equals(midCenter.getText()) && midCenter.getText().equals(botCenter.getText()) && !topCenter.getText().equals(""))
		{
			winner = winner + " is the winner";
			topCenter.setForeground(Color.RED);
			midCenter.setForeground(Color.RED);
			botCenter.setForeground(Color.RED);
			addScore(topCenter);
			goNext();
			reset();
		}
		else if(topRight.getText().equals(midRight.getText()) && midRight.getText().equals(botRight.getText()) && !topRight.getText().equals(""))
		{
			winner = winner + " is the winner";
			topRight.setForeground(Color.RED);
			midRight.setForeground(Color.RED);
			botRight.setForeground(Color.RED);
			addScore(topRight);
			goNext();
			reset();
		}
		else if(topLeft.getText().equals(midCenter.getText()) && midCenter.getText().equals(botRight.getText()) && !topLeft.getText().equals(""))
		{
			winner = winner + " is the winner";
			topLeft.setForeground(Color.RED);
			midCenter.setForeground(Color.RED);
			botRight.setForeground(Color.RED);
			addScore(topLeft);
			goNext();
			reset();
		}
		else if(topRight.getText().equals(midCenter.getText()) && midCenter.getText().equals(botLeft.getText()) && !topRight.getText().equals(""))
		{
			winner = winner + " is the winner";
			topRight.setForeground(Color.RED);
			midCenter.setForeground(Color.RED);
			botLeft.setForeground(Color.RED);
			addScore(botLeft);
			goNext();
			reset();
		}
		/* in this whole section above this comment is to further help
		 * the game check for the winner in the game TIC TAC TOE
		 */ 
		if(score1 >= 3 || score2 >= 3)
		{
			note.setText(winner + " Wins with a score of " + score1 + " - " + score2);
			turnShow.setVisible(false);
			resetB.setVisible(true);
			topLeft.setEnabled(false);
			topCenter.setEnabled(false);
			topRight.setEnabled(false);
			midLeft.setEnabled(false);
			midCenter.setEnabled(false);
			midRight.setEnabled(false);
			botLeft.setEnabled(false);
			botCenter.setEnabled(false);
			botRight.setEnabled(false);
		}	
		/*this paragraph helps out after there's already been three games
		 *since TIC TAC TOE is usually played in games referred to as "best two out of three"
		 *who ever wins at least two games is the winner this paragraph helps that to happen
		 *it also displays the winning p
		 */
	}
	public void addScore(JButton button)
	{
		if(button.getText().equals("X"))
		{
			score1++;
			xWins.setText("X Wins:" + score1);
		}
		/*the article above is an outcome for if the x opponent wins 
		 * it also prints the score
		 */
		else if(button.getText().equals("O"))
		{
			score2++;
			oWins.setText("O Wins:" + score2);
		}
		/*the article above is an outcome for if the o opponent wins 
		 * it also prints the score
		 */
	}
	public void reset()
	{
		topLeft.setText(""); 
		topCenter.setText(""); 
		topRight.setText(""); 
		midLeft.setText(""); 
		midCenter.setText(""); 
		midRight.setText(""); 
		botLeft.setText(""); 
		botCenter.setText(""); 
		botRight .setText("");
		topLeft.setForeground(Color.BLACK);
		topCenter.setForeground(Color.BLACK);
		topRight.setForeground(Color.BLACK);
		midLeft.setForeground(Color.BLACK);
		midCenter.setForeground(Color.BLACK);
		midRight.setForeground(Color.BLACK);
		botLeft.setForeground(Color.BLACK);
		botCenter.setForeground(Color.BLACK);
		botRight.setForeground(Color.BLACK);
		turn = "X";
		numTurns = 0;
		turnShow.setText("It is " + turn + " turn");
	}// the article of code above created multiple text boxes with a space to hold out x and o characters
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() instanceof JButton)
		{
			JButton clicked = (JButton) e.getSource();
			
			if(e.getSource() == PvP)
			{
				gameMode = "PvP";
				reset();
				hideModeChoose();
			}
			if(e.getSource() == PvCpuEasy)
			{
				gameMode = "PvEasy";
				reset();
				hideModeChoose();
			}
			if(e.getSource() == CpuvCpu)
			{
				gameMode = "CpuvCpu";
				reset();
				hideModeChoose();
			}
			
			if(clicked.getText().equals(""))
			{
				if(gameMode.equals("CpuvCpu"))
				{
					while(gameEnd == false && score1 < 3 && score2 < 3 && numTurns <= 9)
					{
						twoBot(e);
					}
					//if the player clicks the CpuvCpu it plays the bots against each other
					reset();
				}
				else if(e.getSource() == topLeft)
				{
					setButton(e);
					checkWin();
					numTurns++;
				}
				else if(e.getSource() == topCenter)
				{
					setButton(e);
					checkWin();
					numTurns++;
				}
				else if(e.getSource() == topRight)
				{
					setButton(e);
					checkWin();
					numTurns++;
				}
				else if(e.getSource() == midLeft)
				{
					setButton(e);
					checkWin();
					numTurns++;
				}
				else if(e.getSource() == midCenter)
				{
					setButton(e);
					checkWin();
					numTurns++;
				}
				else if(e.getSource() == midRight)
				{
					setButton(e);
					checkWin();
					numTurns++;
				}
				else if(e.getSource() == botLeft)
				{
					setButton(e);
					checkWin();
					numTurns++;
				}
				else if(e.getSource() == botCenter)
				{
					setButton(e);
					checkWin();
					numTurns++;
				}
				else if(e.getSource() == botRight)
				{
					setButton(e);
					checkWin();
					numTurns++;
				}
				/*all these things here do literally the EXACT same thing, that being
				 * check and see what opponents turn it is, look to see if that move allowed them
				 *  to win, and then add a turn to turns
				 */	
				if(gameMode.equals("PvEasy"))
				{
					numTurns = 0;
					oneBot(e);
				}
				//if the player clicks the PvBot easy it plays the oBot
				
			}
			if(numTurns > 9)
			{
				String askNext = "It is a Draw";
			    JFrame frame = new JFrame("next");
			    JOptionPane.showMessageDialog(frame, askNext);
				reset();
			}
			if(e.getSource() == resetB)
			{
				score1 = 0;
				score2 = 0;
				numTurns = 0;
				note.setText("Tic-Tac-Toe");
				turnShow.setVisible(true);
				topLeft.setEnabled(true);
				topCenter.setEnabled(true);
				topRight.setEnabled(true);
				midLeft.setEnabled(true);
				midCenter.setEnabled(true);
				midRight.setEnabled(true);
				botLeft.setEnabled(true);
				botCenter.setEnabled(true);
				botRight.setEnabled(true);
				xWins.setText("X Wins:" + score1);
				oWins.setText("O Wins:" + score1);
				resetB.setVisible(false);
			}
		}
	}
	public static void main(String[] args)
	{	
		TicTacToe game = new TicTacToe();
	}
}


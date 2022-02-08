import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToeCom extends JFrame implements ActionListener
{
	private	JButton restart, topLeft, topCenter, topRight, midLeft, midCenter, midRight, botLeft, botCenter, botRight;
	private	JButton reset, PvP, PvCpuEasy, PvCpuHard;
	//here in the code we created all the buttons we're using so far
	private JLabel xWins,oWins, note, field, turnShow;
	//here we created a couple labels for later 
	boolean gameEnd;
	String turn, winner;
	int numTurns, score1, score2;
	Container window;
	
	
	public TicTacToeCom()
	{
		window = getContentPane();
		window.setLayout(null);
		window.setBackground(Color.black);
		setSize(600,755);
		setResizable(false);
		setLocation(1000,250);
		setTitle("Calculator");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		/*in this "paragraph" of code we created the 
		 window in which our board will be placed */
		
		makeButtons();
		//here we're calling on makeButtons
		
		field = new JLabel(new ImageIcon("tic-tac-toe.png"));
		field.setBounds(0, 134, 600, 600);
		field.setBorder(BorderFactory.createLineBorder(Color.black, 10));
		window.add(field);
		/*in this paragraph of code we created a label
		  and told it where to go by setting its bounds */
		 
		winner = "x";
		note = new JLabel("Welcome to Tic-Tac-Toe. Please Select A GameMode");
		note.setBounds(0, 0, 600, 67);
		note.setOpaque(true);
		note.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
		note.setHorizontalAlignment(SwingConstants.CENTER);
		note.setFont(new Font("Arial", Font.BOLD, 20));
		window.add(note);
		//this makes the notification text, that the user reads
		
		score1 = 0;
		xWins = new JLabel("X Wins:" + score1);
		xWins.setBounds(0, 67, 200, 67);
		xWins.setOpaque(true);
		xWins.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
		xWins.setHorizontalAlignment(SwingConstants.CENTER);
		xWins.setFont(new Font("Arial", Font.BOLD, 30));
		window.add(xWins);
		/* here we created an outcome for if the opponent
		  that is playing as the "X" happens to win */
		
		turn = "X";
		turnShow = new JLabel("It is " + turn + " turn");
		turnShow.setBounds(200, 67, 200, 67);
		turnShow.setOpaque(true);
		turnShow.setHorizontalAlignment(SwingConstants.CENTER);
		turnShow.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
		turnShow.setFont(new Font("Arial", Font.BOLD, 30));
		window.add(turnShow);
		// here is how we get the "X" opponent to take their turn
		
		score2 = 0;
		oWins = new JLabel("O Wins:" + score2);
		oWins.setBounds(400, 67, 200, 67);
		oWins.setOpaque(true);
		oWins.setHorizontalAlignment(SwingConstants.CENTER);
		oWins.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
		oWins.setFont(new Font("Arial", Font.BOLD, 30));
		window.add(oWins);
		/* here we created an outcome for if the opponent
		  that is playing as the "O" happens to win */
		
	
		setVisible(true);
	}
	public void makeButtons()
	{

//		PvP = new JButton("Player V.S Player");
//		PvP.setBounds(0, 67, 200, 67);
//		PvP.addActionListener(this);
//		PvP.setHorizontalAlignment(SwingConstants.CENTER);
//		PvP.setFont(new Font("Arial", Font.BOLD, 15));
//		window.add(PvP);
//		
//		PvCpuEasy = new JButton("Player V.S CPU(Easy)");
//		PvCpuEasy.setBounds(200, 67, 200, 67);
//		PvCpuEasy.addActionListener(this);
//		PvCpuEasy.setHorizontalAlignment(SwingConstants.CENTER);
//		PvCpuEasy.setFont(new Font("Arial", Font.BOLD, 15));
//		window.add(PvCpuEasy);
//		
//		PvCpuHard = new JButton("Player V.S CPU(Hard)");
//		PvCpuHard.setBounds(400, 67, 200, 67);
//		PvCpuHard.addActionListener(this);
//		PvCpuHard.setHorizontalAlignment(SwingConstants.CENTER);
//		PvCpuHard.setFont(new Font("Arial", Font.BOLD, 15));
//		window.add(PvCpuHard);
		
		topLeft = new JButton("");
		topLeft.setBounds(15, 154, 170, 170);
		topLeft.addActionListener(this);
		topLeft.setHorizontalAlignment(SwingConstants.CENTER);
		topLeft.setFont(new Font("Arial", Font.BOLD, 15));
		window.add(topLeft);
		//here is where the top left side of our game board is being brought to life
		
		topCenter = new JButton("");
		topCenter.setBounds(210, 154, 170, 170);
		topCenter.addActionListener(this);
		topCenter.setHorizontalAlignment(SwingConstants.CENTER);
		topCenter.setFont(new Font("Arial", Font.BOLD, 15));
		window.add(topCenter);
		//in this area of code we create the top center of our tic tac toe board
		
		topRight = new JButton("");
		topRight.setBounds(410, 154, 170, 170);
		topRight.addActionListener(this);
		topRight.setHorizontalAlignment(SwingConstants.CENTER);
		topRight.setFont(new Font("Arial", Font.BOLD, 15));
		window.add(topRight);
		//here we create the top right of our board
		
		midLeft = new JButton("");
		midLeft.setBounds(15, 350, 170, 170);
		midLeft.addActionListener(this);
		midLeft.setHorizontalAlignment(SwingConstants.CENTER);
		midLeft.setFont(new Font("Arial", Font.BOLD, 15));
		window.add(midLeft);
		/* here in this paragraph of code we 
		 * created a button that we then set the bounds of
		 * thus creating the mid left of out board
		 */
		
		midCenter = new JButton("");
		midCenter.setBounds(210, 350, 170, 170);
		midCenter.addActionListener(this);
		midCenter.setHorizontalAlignment(SwingConstants.CENTER);
		midCenter.setFont(new Font("Arial", Font.BOLD, 15));
		window.add(midCenter);
		/* in the area here we created a button and then
		 * set its bounds, creating our mid center of our game board
		 */
		
		midRight = new JButton("");
		midRight.setBounds(410, 350, 170, 170);
		midRight.addActionListener(this);
		midRight.setHorizontalAlignment(SwingConstants.CENTER);
		midRight.setFont(new Font("Arial", Font.BOLD, 15));
		window.add(midRight);
		/*here in the paragraph above we made a new button 
		 * and set its bounds, creating our mid right section of 
		 * our game board
		 */
		
		botLeft = new JButton("");
		botLeft.setBounds(15, 550, 170, 170);
		botLeft.addActionListener(this);
		botLeft.setHorizontalAlignment(SwingConstants.CENTER);
		botLeft.setFont(new Font("Arial", Font.BOLD, 15));
		window.add(botLeft);
		/* in this section of code we created a button that happens to be new
		 * and told it where to show up at by setting its bounds
		 * creating the bottom left of our board
		 */
		
		botCenter = new JButton("");
		botCenter.setBounds(210, 550, 170, 170);
		botCenter.addActionListener(this);
		botCenter.setHorizontalAlignment(SwingConstants.CENTER);
		botCenter.setFont(new Font("Arial", Font.BOLD, 15));
		window.add(botCenter);
		/* in this section of code we created a button that happens to be new
		 * and told it where to show up at by setting its bounds
		 * creating the bottom center of our board
		 */
		
		botRight = new JButton("");
		botRight.setBounds(410, 550, 170, 170);
		botRight.addActionListener(this);
		botRight.setHorizontalAlignment(SwingConstants.CENTER);
		botRight.setFont(new Font("Arial", Font.BOLD, 15));
		window.add(botRight);
		/* in this section of code we created a button that happens to be new
		 * and told it where to show up at by setting its bounds
		 * creating the bottom right of our board
		 */
		
	}
	public void checkWin()
	{
		if(topLeft.getText().equals(topCenter.getText()) && topCenter.getText().equals(topRight.getText()) && !topLeft.getText().equals(""))
		{
			winner = winner + " is the winner";
			addScore(topLeft);
			reset();
		}
		if(midLeft.getText().equals(midCenter.getText()) && midCenter.getText().equals(midRight.getText()) && !midLeft.getText().equals(""))
		{
			winner = winner + " is the winner";
			addScore(midLeft);
			reset();
		}
		if(botLeft.getText().equals(botCenter.getText()) && botCenter.getText().equals(botRight.getText()) && !botLeft.getText().equals(""))
		{
			winner = winner + " is the winner";
			addScore(botLeft);
			reset();
		}
		if(topLeft.getText().equals(midLeft.getText()) && midLeft.getText().equals(botLeft.getText()) && !topLeft.getText().equals(""))
		{
			winner = winner + " is the winner";
			addScore(topLeft);
			reset();
		}
		if(topCenter.getText().equals(midCenter.getText()) && midCenter.getText().equals(botCenter.getText()) && !midCenter.getText().equals(""))
		{
			winner = winner + " is the winner";
			addScore(topCenter);
			reset();
		}
		if(topRight.getText().equals(midRight.getText()) && midRight.getText().equals(botRight.getText()) && !topRight.getText().equals(""))
		{
			winner = winner + " is the winner";
			addScore(topRight);
			reset();
		}
		if(topLeft.getText().equals(midCenter.getText()) && midCenter.getText().equals(botRight.getText()) && !topLeft.getText().equals(""))
		{
			winner = winner + " is the winner";
			addScore(topLeft);
			reset();
		}
		if(topRight.getText().equals(midCenter.getText()) && midCenter.getText().equals(botLeft.getText()) && !topRight.getText().equals(""))
		{
			winner = winner + " is the winner";
			addScore(topRight);
			reset();
		}
		if(numTurns >= 9)
		{
			reset();
		}
		/* in this whole section above this comment is to further help
		 * the game check for the winner in the game TIC TAC TOE
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
		if(score1 >= 3 || score2 >= 3)
		{
			note.setText(winner + " Wins with a score of " + score1 + " - " + score2);
		}
		/*this paragraph helps out after there's already been three games
		 *since TIC TAC TOE is usually played in games referred to as "best two out of three"
		 *who ever wins at least two games is the winner this paragraph helps that to happen
		 *it also displays the winning p
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
		turn = "X";
		numTurns = 0;
		turnShow.setText("It is " + turn + " turn");
	}
	// the article of code above created multiple text boxes with a space to hold out x and o characters
	public static void main(String[] args)
	{
		TicTacToe game = new TicTacToe();
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() instanceof JButton)
		{
			JButton clicked = (JButton) e.getSource();
			if(clicked.getText().equals(""))
			{
				if(e.getSource() == topLeft)
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
			}
		}
	}
}

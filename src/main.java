import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import net.miginfocom.swing.MigLayout;

import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;

public class main {

	private JFrame frame;
	private JTextField char0;
	private JTextField char1;
	private JTextField char2;
	private JTextField char3;
	private JTextField char4;
	private JLabel scoreLabel;
	private JLabel Attempts;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main window = new main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		game gme = new game();
		
		frame = new JFrame("Simple Wordle by Pakpoom");
		frame.setBounds(100, 100, 500 + 16, 400 + 39);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		frame.setResizable(false);
		
		JLayeredPane layeredPane = new JLayeredPane();
		frame.getContentPane().add(layeredPane);
		
		JPanel startWin = new JPanel();
		startWin.setBounds(0, 0, 500, 400);
		startWin.setBackground(new Color(38, 38, 38));
		JLabel titleLabel = new JLabel("Simple Wordle by Pakpoom");
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		CoolButton startBtn = new CoolButton("Start");
		
		startWin.setLayout(new MigLayout("", "[100px][100px][100px][100px][100px]", "[50px][50px][50px][50px][50px][50px][50px][50px]"));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setVerticalAlignment(SwingConstants.TOP);
		startWin.add(titleLabel, "cell 2 1,alignx left,aligny center");
		
		startWin.add(startBtn, "cell 2 4,alignx center,aligny center");
		
		JPanel gameWin = new JPanel();
		gameWin.setBackground(new Color(38, 38, 38));
		gameWin.setBounds(0, 0, 500, 400);
		
		gameWin.setLayout(new MigLayout("", "[20][80][20][80][20][80][20][80][20][80][20]", "[60][60][100][60][60][60]"));
		
		CoolButton checkBtn = new CoolButton("Check");
		
		scoreLabel = new JLabel("Score: 0");
		scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		scoreLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scoreLabel.setForeground(Color.WHITE);
		gameWin.add(scoreLabel, "cell 1 0 2 1,alignx left,aligny center");
		
		Attempts = new JLabel("5 Attemps left");
		Attempts.setHorizontalAlignment(SwingConstants.CENTER);
		Attempts.setForeground(Color.WHITE);
		Attempts.setFont(new Font("Tahoma", Font.PLAIN, 14));
		gameWin.add(Attempts, "cell 8 0 2 1,alignx right,aligny center");
		
		char0 = new CharBox();
		gameWin.add(char0, "cell 1 2,alignx center,aligny center");
		char0.setColumns(10);
		
		char1 = new CharBox();
		gameWin.add(char1, "cell 3 2,alignx center,aligny center");
		char1.setColumns(10);
		
		char2 = new CharBox();
		gameWin.add(char2, "cell 5 2,alignx center,aligny center");
		char2.setColumns(10);
		
		char3 = new CharBox();
		gameWin.add(char3, "cell 7 2,alignx center,aligny center");
		char3.setColumns(10);
		
		char4 = new CharBox();
		gameWin.add(char4, "cell 9 2,alignx center,aligny center");
		char4.setColumns(10);
		
		JTextField chars[] = {char0, char1, char2, char3, char4}; 
		
		
		gameWin.add(checkBtn, "cell 2 4 7 1,alignx center,aligny center");
		
		JPanel resultWin = new JPanel();
		resultWin.setBackground(new Color(38, 38, 38));
		resultWin.setBounds(0, 0, 500, 400);
		
		resultWin.setLayout(new MigLayout("", "[100px][100px][100px,grow][100px][100px]", "[50px][][50px][50px][50px][50px][50px][34.00px][][50px]"));
		
		JLabel showScoreLabel = new JLabel("Your score is ");
		showScoreLabel.setForeground(Color.WHITE);
		showScoreLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		showScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		showScoreLabel.setVerticalAlignment(SwingConstants.TOP);
		
		resultWin.add(showScoreLabel, "cell 2 1,alignx left,aligny center");
		
		CoolButton restartBtn = new CoolButton("Restart");
		
		JPanel TextHolder = new JPanel();
		TextHolder.setForeground(new Color(255, 255, 255));
		TextHolder.setBorder(null);
		TextHolder.setBackground(new Color(153, 153, 153));
		resultWin.add(TextHolder, "cell 1 3 3 4,alignx center,aligny center");
		TextHolder.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JTextArea descText = new JTextArea();
		descText.setColumns(15);
		descText.setEditable(false);
		descText.setEnabled(false);
		descText.setTabSize(10);
		descText.setRows(4);
		descText.setWrapStyleWord(true);
		descText.setLineWrap(true);
		descText.setBackground(new Color(153, 153, 153));
		descText.setForeground(new Color(255, 255, 255));
		descText.setDisabledTextColor(Color.WHITE);
		descText.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		TextHolder.add(descText);
		
		resultWin.add(restartBtn, "cell 2 8,alignx center,aligny center");
		
		
		startBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				gme.setWord();
				Attempts.setText(gme.attempts + " Attemps left");
				
				layeredPane.removeAll();
				layeredPane.add(gameWin);
			}
		});
		
		checkBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String guess =( 
						char0.getText() +
						char1.getText() +
						char2.getText() +
						char3.getText() +
						char4.getText()
						);
				if (guess.length() < 5) {
					return;
				}
				
				if (!fetchDic.isword(guess)) {
					return;
				}
				
				gme.calculateScore(guess);
				int result[] = gme.score;
				
				
				scoreLabel.setText("Score: " + Arrays.stream(result).sum());
				
				for (int i = 0; i < result.length; i++) {
					if (result[i] == 2) {
						chars[i].setBackground(new Color(126, 181, 81));
						chars[i].setEnabled(false);
					}
					else if (result[i] == 1) {
						chars[i].setBackground(new Color(244, 187, 68));
					}
					else if (result[i] == 0) {
						chars[i].setBackground(new Color(153, 153, 153));
					}
				}
				
				gme.attempts--;
				Attempts.setText(gme.attempts + " Attemps left");
				
				if (gme.attempts == 0 || (Arrays.stream(result).sum() == 10)) {
					layeredPane.removeAll();
					layeredPane.add(resultWin);
					showScoreLabel.setText("Your score is " + Arrays.stream(result).sum() + "!");
					
					String description = fetchDic.getDescription(gme.word);
					descText.setText(gme.word.substring(0,1).toUpperCase() + gme.word.substring(1) + " - " + description);
				}
			}
		});
		
		restartBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(startWin);
				
				
				int result[] = gme.score;
				for (int i = 0; i < result.length; i++) {
					chars[i].setEnabled(true);
					chars[i].setText("");
					chars[i].setBackground(new Color(153, 153, 153));
				}
			}
		});
		
		
		layeredPane.add(startWin);
		
	}
}

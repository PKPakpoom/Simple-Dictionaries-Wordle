import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;


public class game {
	String path = "resources/words.txt";
	
	Random random = new Random();
	Scanner scan;
	File file = new File(path);

	int Index;
	String word;
	public int score[] = {0, 0, 0, 0, 0};
	public int attempts;
	
	public int linesCount(Scanner scan, File file) {
		int lines = 0;
		try {
			scan = new Scanner(file);
		}
		catch(IOException e) {
			System.out.println("FileNotFound");
			System.exit(1);
		}
		while(scan.hasNextLine()) {
	        scan.nextLine();
	        lines++;
	     }
		scan.close();
		return lines;
	}
	public String getLine(Scanner scan, File file, int line) {
		try {
			scan = new Scanner(file);
		}
		catch(IOException e) {
			System.out.println("FileNotFound");
			System.exit(1);
		}
		int lines = 0;
		String str;
		while(scan.hasNextLine() && lines < line - 1) {
	        str = scan.nextLine();
	        lines++;
	     }
		str = scan.nextLine();
		scan.close();
		return str;
	}
	
	public void setWord() {
		int lines = linesCount(scan, file);
		Index = random.nextInt(lines - 1);
		word = getLine(scan, file, Index);
		this.attempts = 5;
		//System.out.println(word);
	}
	
	public void calculateScore(String guess) {
		for (int i = 0; i < guess.length(); i++) {
			if (guess.charAt(i) == word.charAt(i)) {
				score[i] = 2;
			}
			else if (word.indexOf(guess.charAt(i)) != -1) {
				score[i] = 1;
			}
			else {
				score[i] = 0;
			}
		}	
	}
	
}

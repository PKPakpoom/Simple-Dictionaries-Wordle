import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

public class CoolButton extends JButton{
	CoolButton(String title) {
		super(" " + title + " ");
		this.setBackground(new Color(241, 100, 54));
		this.setForeground(new Color(255, 255, 255));
		this.setFont(new Font("Tahoma", Font.PLAIN, 40));
		this.setBorder(null);
	}
}
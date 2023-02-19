import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class CharBox extends JTextField {
	CharBox() {
		super();
		this.setDocument(new JTextFieldLimit(1));
		this.setForeground(Color.WHITE);
		this.setBackground(new Color(153, 153, 153));
		this.setHorizontalAlignment(SwingConstants.CENTER);
		this.setFont(new Font("Tahoma", Font.PLAIN, 60));
		this.setBorder(BorderFactory.createEmptyBorder());
		this.setCaretColor(new Color(241, 100, 54));
		this.setHighlighter(null);
		this.setDisabledTextColor(Color.WHITE);
	}

}

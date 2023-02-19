import javax.swing.text.PlainDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;

public class JTextFieldLimit extends PlainDocument {
  private int limit;

  JTextFieldLimit(int limit) {
   super();
   this.limit = limit;
   }

  public void insertString( int offset, String  str, AttributeSet attr ) throws BadLocationException {
    if (str == null) return;

    if (((getLength() + str.length()) <= limit) && !Character.isDigit(str.charAt(offset)) && !Character.isWhitespace(str.charAt(offset)) && Character.isLowerCase(str.charAt(offset))) {
      super.insertString(offset, str, attr);
    }
  }
}
package util;

import javax.print.attribute.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class SoNumeros extends PlainDocument{
	
	@Override
	public void insertString(int offs, String str, javax.swing.text.AttributeSet a) throws BadLocationException {
		// TODO Auto-generated method stub
		super.insertString(offs, str.replaceAll("[^0-9]", ""), a);
	}
}

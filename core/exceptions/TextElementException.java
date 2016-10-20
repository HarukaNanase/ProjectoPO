package edt.core.exceptions;

import pt.utl.ist.po.ui.InvalidOperation;

public class TextElementException extends InvalidOperation{

	public TextElementException(){
		super("TextElementNotIndexed");
	}
	
}
package edt.core.exceptions;

import pt.utl.ist.po.ui.InvalidOperation;


public class IndexElementException extends InvalidOperation{

	public IndexElementException(){
		super("IndexElementAlreadyExists");
	}
	
}
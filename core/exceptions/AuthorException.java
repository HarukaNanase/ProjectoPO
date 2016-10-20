package edt.core.exceptions;

import pt.utl.ist.po.ui.InvalidOperation;


public class AuthorException extends InvalidOperation{

	public AuthorException(){
		super("AuthorAlreadyExists");
	}
	
}
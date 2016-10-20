package edt.core.exceptions;

import pt.utl.ist.po.ui.InvalidOperation;


public class KeyException extends InvalidOperation{

	public KeyException(){
		super("KeyNotFound");
	}
	
}
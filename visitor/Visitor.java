package edt.visitor;
import edt.core.*;

public abstract class Visitor{
	public Visitor(){

	}



	public abstract String visit(Section s);

	public abstract String visit(Paragraph p);


}
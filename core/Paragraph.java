package edt.core;
import java.io.Serializable;
import edt.visitor.*;
/**
 * Class Paragraph represents an editable TextElement capable of holding Strings of text.
 * 
 * @author Guilherme Portela 82525
 * @author Andre Soares 82542
 * @author Joao Vicente 82552
 * @version 1.0
 * @see java.io.Serializable
 */
public class Paragraph extends TextElement implements Serializable{
	/**
    * Paragraph's text in String form.
    */
	private String _text;

	/**
    * Serial number for serialization.
    */
	private static final long serialVersionUID = 12937219847216L;


	/**
    * Constructor.
    * @param a
    *		Paragraph's text.
    */		
	public Paragraph(String a){
		super();
		_text = a;
	}

	/**
    * @param text
    *           content of the paragraph.
    */
	public void setText(String text){
		_text = text;
	}	

	/**
    * @return paragraph's content in String form.
    */
	public String getContent(){
		return _text;
	}

	/**
    * @return paragraph's size in int form.
    */
	public int getSize(){
		return _text.length();
	}

	public void accept(Visitor v){
		v.visit(this);
	}

}





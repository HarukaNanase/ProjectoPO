package edt.core;

import java.io.Serializable;
import edt.visitor.*;
/**
 * Abstract class <code>TextElement</code> represents an editable labelled string.
 *
 * @author Guilherme Portela 82525
 * @author Andre Soares 82542
 * @author Joao Vicente 82552
 * @version 1.0
 * @see java.io.Serializable
 */
public abstract class TextElement implements Serializable{
	/**
    * Key String representing the text element.
    */
	String _key;

	/**
    * Serial number for serialization.
    */
	private static final long serialVersionUID = 12937219847218L;
	
	/**
    * Constructor.
    */
	public TextElement(){
		_key = "";
	}

	/**
    * @return text element's key.
    */
	public String getKey(){
		return _key;
	}

	/**
    * @param key
    *           ID to be given to a text element's _key.
    */
	public void setKey(String key){
		_key = key;
	}

	 /**
    * @return false if the text element is not indexed by its ID
    */
	protected boolean isIndexed(){
		if(_key.equals("")){
			return false;
		}
		return true;
	}

	/**
    * Acquire text element's content in String form.
    * @return a TextElement content.
    */
	public abstract String getContent();

	/**
    * Acquire text element's size in int form.
    * @return Size of an textelement.
    */
	public abstract int getSize();

	public abstract void accept(Visitor v);

}
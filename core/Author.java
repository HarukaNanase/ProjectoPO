package edt.core;

import java.lang.Comparable;
import java.io.Serializable;

/**
 * Class Author manages Author names and emails.
 *
 * @author Guilherme Portela 82525
 * @author Andre Soares 82542
 * @author Joao Vicente 82552
 * @version 1.0
 * @see java.io.Serializable
 * @see java.lang.Comparable
 */
public class Author implements Comparable<Author>,Serializable{
	/**
    * Name of the author.
    */
	private String _name;
	
	/**
    * Email of the author.
    */
	private String _email;
	
	/**
    * Serial number for serialization.
    */
	private static final long serialVersionUID = 12937219847217L;

	/**
    * Constructor.
    * @param nome
    *           name of the author.
    * @param email
    *           email of the author.
    */
	public Author(String nome, String email){
		_name = nome;
		_email = email;
	}

	/**
    * @return name of the author.
    */
	public String getName(){
		return _name;
	}

	/**
    * @return email of the author.
    */
	public String getEmail(){
		return _email;
	}

	/**
    * @param obj
    *           comparable object.
    * @return true if the comparable obj's name equals any existing Author name.
    */
	public boolean equals(Object obj){
		
		if((((Author)(obj))._name.equals(_name))){
			return true;
		}
		return false;
	}

	/**
    * @param autor
    *           author.
    * @return boolean according to compared authors' names
    */
	public int compareTo(Author autor){
			return _name.compareTo(autor._name);
	}


}

package edt.core;
import java.io.Serializable;
import java.util.*;
import java.io.*;
import edt.core.exceptions.*;
import pt.utl.ist.po.ui.InvalidOperation;
import edt.visitor.*;

/**
 * Class Document represents an editable file capable of holding Paragraphs and Sections in itself.
 *
 * @author Guilherme Portela 82525
 * @author Andre Soares 82542
 * @author Joao Vicente 82552
 * @version 1.0
 * @see java.io.Serializable
 * @see edt.core.Section
 */
public class Document extends Section implements Serializable{
	/**
    *  Document's unique filename.
    */
	private String _filename;
	
	/**
    *  Document's list of authors organized by alphabetical order.
    */
	private ArrayList<Author> _authors;
	
	/**
    *  Document's list of text elements.
    */
	private HashMap<String,TextElement> _textElements;
	
	/**
    *  Serial number for serialization.
    */
	private static final long serialVersionUID = 12937219847214L;
	
	/**
    *  Constructor.
    */
	public Document(){
		super("");
		_filename ="";
		_authors = new ArrayList<Author>();
		_textElements = new HashMap<String,TextElement>();
	}

	/**
    *  @return Returns document filename.
    */
	public String getFilename(){
		return _filename;
	}

	/**
    * @param filename
    *           name to be given to a document's filename.
    */
	public void setFilename(String filename){
		_filename = filename;
	}

	/**
    * @return a list of all the text elements in this document.
    */
	public HashMap<String,TextElement> getTextElementHashMap(){
		return _textElements;
	}

	
	/**
    * @param a
    *           authors to be assigned to the document's author list.
    */
	public void setAuthors(ArrayList<Author> a){
		_authors = a;
	}
	
	
	/**
    * @param t
    *           text elements to be assigned to the document's text element list.
    */
	public void setTextElements(HashMap<String,TextElement> t){
		_textElements = t;
	}

	

	/**
    *  @return the list of the document authors.
    */
	public ArrayList<Author> getAuthorArray(){
		return _authors;
	}

	/**
    * @param author
    *           specific author to be added in alphabetical order, doesn't add if @param author name already exists in the authors list.
    * @Throws AuthorException
    *			Author parameter already exists in the document.
    */
	public void addAuthor(Author author) throws AuthorException{
		ListIterator<Author> i = _authors.listIterator();
		while(i.hasNext()){
			Author a = i.next();
			if(author.compareTo(a) == 0){
				throw new AuthorException();
			}

			if(author.compareTo(a) < 0){
				i.previous();
				i.add(author);
				break;
			}
			continue;
		}
		if(!i.hasNext()){
			_authors.add(author);
		}
		if(_authors.size() == 0){
			_authors.add(author);
		}
		
}

	/**
    * @param index
    *           specific index of author.
    * @return returns author in index position
    */
	public Author getAuthor(int index){
		return _authors.get(index);
	}

	/**
    *  @return the document's title.
    */
	public String getHeadlineAux(){
		return getTitle();
	}

	/**
	* @return the document's headline.
	*/
	public String getHeadline(){
		return "{" + getTitle() + "}";
	}

	/**
	* @return size of the whole document.
	*/
	public int getSize(){
		int size = 0;
		size += getTitle().length();
		for(Paragraph p: getParagraphs()){
			size += p.getSize();
		}
		for (Section s: getSubSections()){
			size += s.getSize();
		}
		return size;
	}

	/**
    * @param identifier
    *           the text element's ID.
    * @return the text element if its key equals the @param identifier.
    */
	public TextElement getTextElement(String identifier){	
		return _textElements.get(identifier);
	}
			
	/**
    * @param identifier
    *           the key to be assigned to a text element.
    * @param obj
    *           text element to be indexed.
    */
	public void indexElement(String identifier, TextElement obj){
			if(_textElements.containsValue(obj)){
				_textElements.remove(obj.getKey());
			}

			if(getTextElement(identifier) != null){
				getTextElement(identifier).setKey("");
				
				obj.setKey(identifier);
				_textElements.put(identifier,obj);
			}
			else{
				obj.setKey(identifier);
				_textElements.put(identifier,obj);
			}
	}
	
	/**
    * Serializes the current object of class 'Document' with the _filename as the new file's name.
    * @throws IOException
    *			IOException - Couldn't save file.
    */
	public void saveDocument() throws IOException{
			
			ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream(_filename));
			objectOut.writeObject(this);
			objectOut.close();	
			
	}

	/**
    * De-serializes the object corresponding to @param filename and loads it into the current document.
    * @param filename
    *           filename of the document to be loaded.
    * @throws IOException
    *			IOException - Couldn't find file with @param filename.
    * @throws ClassNotFoundException
    *			ClassNotFoundException - Class required for de-serialization not found.
    */
	public void loadDocument(String filename) throws IOException,ClassNotFoundException{
			ObjectInputStream objectIn = new ObjectInputStream (new FileInputStream(filename));
			Document loadedDoc = (Document) objectIn.readObject();
			objectIn.close();
			this.setTitle(loadedDoc.getTitle());
			this.setParagraphs(loadedDoc.getParagraphs());
			this.setAuthors(loadedDoc.getAuthorArray());
			this.setSections(loadedDoc.getSubSections());  
			this.setFilename(loadedDoc.getFilename());
			this.setTextElements(loadedDoc.getTextElementHashMap());
	}

	/**
	* Resets the document entirely, by replacing all the attributes with empty ones.
	*/
	public void resetDocument(){
		 this.setTitle("");
		_authors.clear();
		_textElements.clear();
		this.getSubSections().clear();
		this.getParagraphs().clear();
		this.setFilename("");
	}

	public void accept(Visitor v){
		v.visit(this);
	}


}

	
package edt.core;
import java.util.*;
import java.io.*;
import edt.visitor.*;

/**
 * Class Section represents an editable TextElement capable of holding Paragraphs and Subsections in itself.
 *
 * @author Guilherme Portela 82525
 * @author Andre Soares 82542
 * @author Joao Vicente 82552
 * @version 1.0
 * @see java.util
 * @see java.io.Serializable
 */
public class Section extends TextElement implements Serializable{
	/**
    * Section's title in String form.
    */
	private String _title;

	/**
    * List of all this section's paragraphs.
    */
	private ArrayList<Paragraph> _paragraphs;
	
	/**
    * List of all this section's subscetions.
    */
	private ArrayList<Section> _subSections;
	
	/**
    * Serial number for serialization.
    */
	private static final long serialVersionUID = 12937219847215L;

	/**
    * Constructor.
    * @param a
    *		 Section's title.
    */
	public Section(String a){
		super();
		_title = a;
		_paragraphs = new ArrayList<Paragraph>();
		_subSections = new ArrayList<Section>();
	
	}

	/**
    * @return section's title.
    */
	public String getTitle(){
		return _title;
	}

	/**
    * @param title
    *           title to be given to a section's title.
    */
	public void setTitle(String title){
		_title = title;
	}

	/**
    * @return this section's paragraphs.
    */
	public ArrayList<Paragraph> getParagraphs(){
		return _paragraphs;
	}

	/**
    * @return this section's headline ( section key + section title).
    */
	public String getHeadline(){
		return "["+getKey()+"]" +" "+ "{" + _title + "}";
	}

	/**
    * @return the concatenated String of this section's paragraphs content and subsections content without headlines.
    */
	public String getContentWithoutHeadline(){
		String _fullContent = "";
		_fullContent += getTitle();
		for(Paragraph p: getParagraphs()){
			_fullContent += p.getContent();
		}
		for (Section s : getSubSections()){
			_fullContent += s.getContentWithoutHeadlineAux();
		}
		return _fullContent;
	}

	/**
	* Auxiliar Function
	*
    * @return the concatenated String of this section's subsections content without headlines.
    */
	public String getContentWithoutHeadlineAux(){
		String _fullContent = ""; 
		_fullContent += getTitle();
		for(Paragraph p: getParagraphs()){
			_fullContent += p.getContent();
		}
		for(Section s: getSubSections()){
			_fullContent += s.getContentWithoutHeadlineAux();
		}      	
		return _fullContent;
	}

	/**
	*
	* @return the concatenated string of this sections content with headlines.
	*/
	public String getContent(){
		String _contentHeadlined = "";
		_contentHeadlined += getHeadline() +"\n";
		for(Paragraph p: getParagraphs()){
			_contentHeadlined += p.getContent()+"\n";
		}
		for(Section s: getSubSections()){
			_contentHeadlined += s.getContentAux()+"\n";
		}
		return _contentHeadlined;
	}

	/**
	* Auxiliar Function
	* @return the concatenated string of this sections subsections content with headlines.
	*/
	public String getContentAux(){
		String _aux = "";
		_aux += getHeadline()+"\n";
		for(Paragraph p: getParagraphs()){
			_aux += p.getContent() +"\n";
		}
		for(Section s : getSubSections()){
			_aux += s.getContentAux();
		}
		return _aux;
	}

	/**
    * @return Section content size.
    */
	public int getSize(){
		return getContentWithoutHeadline().length();
	}

	/**
    * @return a List of this section's subsections.
    */
	public ArrayList<Section> getSubSections(){
		return _subSections;
	}


	/**
    *@return subSectionIndex through the getKey method.
    */
	public String getSubsectionIndex(){
		String subSectionIndex = "";
		for(Section s: _subSections){
			subSectionIndex += s.getHeadline() +"\n";
		}
		return subSectionIndex;
	}

	/**
    * @param idx
    *           local index in the ArrayList.
    * @param section
    *           specific section provided
    */
	public void addSection(int idx, Section section){
			Section s;
			ListIterator<Section> iterator = _subSections.listIterator();
			boolean added = false;

			while(iterator.hasNext() && iterator.nextIndex() != idx){
				s=iterator.next();
			}
			if(iterator.nextIndex() == idx){
					iterator.add(section);
					added = true;
				}
			
			if(!added){
				_subSections.add(section);
			}
	}

	/**
    * @param index
    *           section index within current section.
    * @return Returns the section placed in the @param index given.
    */
	public Section getSection(int index){
			return getSubSections().get(index);
	}

	/**
	*@param idx
	*			section index within current section.
	*@param doc
	*			document to use.
	*@return boolean depending if operation was sucessful or failure.
	*/
	public boolean removeSection(int idx, Document doc){
			try{
				getSubSections().remove(idx);
				return true;
			}
			catch(IndexOutOfBoundsException ioeb){
				return false;
			}
	}

	/**
    * @param index
    *           local index to add the paragraph.
    * @param paragraph
    *           specific paragraph provided.
    */
	public void addParagraph(int index, Paragraph paragraph){
		try{
		_paragraphs.add(index,paragraph);
		}

		catch(IndexOutOfBoundsException outOfBound){
			_paragraphs.add(paragraph);
		}

	}

	/**
    * @param identifier
    *           paragraph ID.
    * @return Paragraph whose key is equal to @param identifier. NULL if no paragraph is found.
    */
	public Paragraph getParagraph(String identifier){
		for (Paragraph p : _paragraphs){
			if (p.getKey().equals(identifier)){
				return p;
			}
		}
		return null;
		}
	
	
	/**
    * @param a
    *           paragraphs to be assigned to the document's paragraph list.
    */
	public void setParagraphs(ArrayList<Paragraph> a){
		_paragraphs = a;
	}
	/**
    * @param s
    *           sections to be assigned to the document's section list.
    */
	public void setSections(ArrayList<Section> s){
		_subSections = s;
	}

	public void accept(Visitor v){
		v.visit(this);
	}
}
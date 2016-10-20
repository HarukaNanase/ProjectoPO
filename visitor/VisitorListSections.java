package edt.visitor;
import edt.core.*;
public class VisitorListSections{
	VisitorListSections(){
	super();
	}

	public String visit(Section s){
		
		String content = "";

		for(Section sec : s.getSubSections()){
			content += s.getKey();
			content += sec.getTitle();
		}
		return content;
	}

	public String visit(Paragraph p){
		return "";
	}
}
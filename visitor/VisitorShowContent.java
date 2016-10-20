package edt.visitor;
import edt.core.*;
public class VisitorShowContent extends Visitor{
	VisitorShowContent(){
		super();
	}

	public String visit(Section s){
		String content = "";
		content += s.getKey();
		content += s.getTitle();
		for (Paragraph p : s.getParagraphs()){
			visit(p);
		}
		for(Section sec : s.getSubSections()){
			visit(s);
		}
		return content;
	}

	public String visit(Paragraph p){
		String pcontent = "";
		pcontent += p.getContent();
		return pcontent;
		}
}

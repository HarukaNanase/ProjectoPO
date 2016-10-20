package edt.textui.section;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;
import pt.utl.ist.po.ui.InputString;
import edt.core.Section;
import edt.core.Document;


/**
 * Command for indexing a paragraph (nomear um parágrafo 2.2.9) of the current section.
 */
public class IndexParagraph extends Command<Section>{
    private Document _docReceived;
    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public IndexParagraph(Document doc, Section ent) {
        super(MenuEntry.NAME_PARAGRAPH, ent);
        _docReceived = doc;
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        Form f = new Form();
        Display d = new Display();
        InputInteger inputI = new InputInteger(f,Message.requestParagraphId());
        InputString inputS = new InputString (f,Message.requestUniqueId());
        f.parse();
        
        try{
           if(entity().getParagraphs().get(inputI.value()).getKey().equals("")){
                _docReceived.indexElement(inputS.value(),entity().getParagraphs().get(inputI.value()));
           }else{
                _docReceived.indexElement(inputS.value(),entity().getParagraphs().get(inputI.value()));
                d.add(Message.paragraphNameChanged());
                d.display();

           }
        }catch(IndexOutOfBoundsException ioob){
            d.add(Message.noSuchSection(inputI.value()));
            d.display();
        }
    }
}

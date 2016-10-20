package edt.textui.section;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InputInteger;
import edt.core.Section;
import edt.core.Document;


/**
 * Command for indexing ia subsection (nomear secção 2.2.6) the current section .
 */
public class IndexSection extends Command<Section> {
   private Document _docReceived;
    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public IndexSection(Document doc,Section ent) {
        super(MenuEntry.NAME_SECTION, ent);
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
        InputInteger inputI = new InputInteger(f,Message.requestSectionId());
        InputString inputS = new InputString (f,Message.requestUniqueId());
        f.parse();
        
        try{
    
           if(entity().getSubSections().get(inputI.value()).getKey().equals("")){
                _docReceived.indexElement(inputS.value(),entity().getSubSections().get(inputI.value()));
           }else{
                _docReceived.indexElement(inputS.value(),entity().getSubSections().get(inputI.value()));
                d.add(Message.sectionNameChanged());
                d.display();

           }
        }catch(IndexOutOfBoundsException ioob){
            d.add(Message.noSuchSection(inputI.value()));
            d.display();
        }
    }
}

package edt.textui.section;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;
import edt.core.Section;
import edt.core.Document;

/**
 * Command for removing a subsection of the current section.
 */
public class RemoveSection extends Command<Section> {
    private Document _docReceived;
    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public RemoveSection(Document doc,Section ent) {
        super(MenuEntry.REMOVE_SECTION, ent);
        _docReceived = doc;
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        Form f = new Form();
        
        InputInteger input = new InputInteger(f,Message.requestSectionId());
        f.parse();
        try{
            String key = entity().getSubSections().get(input.value()).getKey();
            _docReceived.getTextElementHashMap().remove(key);
            entity().getSubSections().remove(input.value());
        }catch(IndexOutOfBoundsException ioob){
           ;
        }
    }
}

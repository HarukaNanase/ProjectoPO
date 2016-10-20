package edt.textui.section;

import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;

import edt.textui.main.EditSection;
import java.util.*;
import edt.core.Section;
import edt.core.Document;

/**
 * Command for selecting a subsection of the current section and edit it.
 */
public class SelectSection extends Command<Document> {
    /**
    * _secReceived is the section to be received.
    */
    private Section _secReceived;
    
    /**
     * Constructor.
     * 
     * @param ent the target entity.
     *
     * @param sec the target section.
     */

    public SelectSection(Document ent,Section sec) {
        super(MenuEntry.SELECT_SECTION, ent);
        _secReceived = sec;
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
      
        Form f = new Form();
        Display d = new Display();
        InputInteger idx = new InputInteger(f,Message.requestSectionId());
        f.parse();
       
        try{
            EditMenu inSection = new EditMenu(entity(),_secReceived.getSection(idx.value()));
            d.add(Message.newActiveSection(idx.value()));
            d.display();
            inSection.open();
            
        }catch(IndexOutOfBoundsException ioob){
            d.add(Message.noSuchSection(idx.value()));
            d.display();
        }

    }
}

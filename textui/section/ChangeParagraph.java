package edt.textui.section;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;
import pt.utl.ist.po.ui.InputString;
import edt.core.Section;

/**
 * Command for changing the content of a paragraph of the current section.
 */
public class ChangeParagraph extends Command<Section> {

    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public ChangeParagraph(Section ent) {
        super(MenuEntry.EDIT_PARAGRAPH, ent);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        Form f = new Form();
        InputInteger inputI = new InputInteger(f,Message.requestParagraphId());
        InputString inputS = new InputString(f,Message.requestParagraphContent());
        f.parse();
        try{
            entity().getParagraphs().get(inputI.value()).setText(inputS.value());
            
        }catch(IndexOutOfBoundsException ioob){
            Display d = new Display();
            d.add(Message.noSuchParagraph(inputI.value()));
            d.display();
        }
   }
}

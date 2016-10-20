package edt.textui.section;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;
import edt.core.Section;
import edt.core.Paragraph;
import edt.core.Document;

/**
 * Command for removing a paragraph of the current section.
 */
public class RemoveParagraph extends Command<Section> {
    private Document _docReceived;
    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public RemoveParagraph(Document doc,Section ent) {
        super(MenuEntry.REMOVE_PARAGRAPH, ent);
        _docReceived = doc;
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        Form f = new Form();
        InputInteger input = new InputInteger(f,Message.requestParagraphId());
        f.parse();
        try{
            
            entity().getParagraphs().remove(input.value());
        

        }catch(IndexOutOfBoundsException ioob){
            Display d = new Display();
            d.add(Message.noSuchParagraph(input.value()));
            d.display();
        }
    }
}

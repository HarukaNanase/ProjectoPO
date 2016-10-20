package edt.textui.main;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import edt.core.*;
import edt.core.exceptions.TextElementException;


/**
 * Command for showing the text element with a given identifier of the current document in the editor.
 */
public class ShowTextElement extends Command<Document> {

    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public ShowTextElement(Document ent) {
        super(MenuEntry.SHOW_TEXT_ELEMENT, ent);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        Form f = new Form();
        
        InputString inS = new InputString(f,Message.requestElementId());
        f.parse();
        Display d = new Display();
            if(entity().getTextElement(inS.value()) == null){
                d.add(Message.noSuchTextElement(inS.value()));
            }else{
            d.add(entity().getTextElement(inS.value()).getContent());
            }
            
                
            
        d.display();
    }
}

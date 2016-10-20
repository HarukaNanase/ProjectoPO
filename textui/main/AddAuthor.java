package edt.textui.main;

import edt.core.*;
import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import edt.textui.main.Message;
import edt.core.exceptions.*;


/**
 * Command for adding an author to the current document in the editor.
 */
public class AddAuthor extends Command<Document> {

    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public AddAuthor(Document ent) {
        super(MenuEntry.ADD_AUTHOR, ent);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        Form n = new Form();
        Form e = new Form();
        
        InputString inN = new InputString(n,Message.requestAuthorName());
        InputString inE = new InputString(e,Message.requestEmail());
        n.parse();
        e.parse();
        Author author = new Author(inN.value(),inE.value());
        try{
        entity().addAuthor(author);
        }catch(AuthorException ae){
            Display d = new Display();
            d.add(Message.duplicateAuthor(inN.value()));
            d.display();
        }
       
            
    


    }
}

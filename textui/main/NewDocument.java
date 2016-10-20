package edt.textui.main;
import edt.core.*;


import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;
import java.io.IOException;


/**
 * Command for creating a new document in the editor.
 */
public class NewDocument extends Command<Document> {

    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public NewDocument(Document ent) {
        super(MenuEntry.NEW, ent);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        entity().resetDocument();
        }
    }

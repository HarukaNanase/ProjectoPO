package edt.textui.main;

import java.io.IOException;
import edt.core.*;
import edt.textui.main.Message;
import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InvalidOperation;


/**
 * Command for opening an existing document in the editor.
 */
public class OpenDocument extends Command<Document> {

    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public OpenDocument(Document ent) {
        super(MenuEntry.OPEN, ent);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() throws InvalidOperation {
        Form f = new Form();
        
        InputString inS = new InputString(f,Message.openFile());
        f.parse();
        
        try{
            entity().loadDocument(inS.value());
        }
        catch(IOException e){
            Display d = new Display();
            d.add(Message.fileNotFound());
            d.display();
        }
        catch (ClassNotFoundException cnfe){
            Display d = new Display();
            d.add("Nao abri porque nao existe a classe Documento.");
            d.display();}
    }
}

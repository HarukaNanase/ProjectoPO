package edt.textui.main;

import edt.core.*;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InvalidOperation;
import edt.textui.main.Message;
import java.io.IOException;
import pt.utl.ist.po.ui.Display;


/**
 * Command for saving the current document in the editor.
 */
public class SaveDocument extends Command<Document> {

    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public SaveDocument(Document ent) {
        super(MenuEntry.SAVE, ent);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() throws InvalidOperation {
        
        if(entity().getFilename().equals("")){
        Form f = new Form();
        InputString inS = new InputString(f,Message.newSaveAs());
        f.parse();

        entity().setFilename(inS.value());
        
        if(entity().getFilename().equals("")){
            Display d = new Display();
            d.add("Nao guardado. Nome de ficheiro vazio.");
            d.display();
        }

        try{
            entity().saveDocument();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }

        }else{
        
        try{
            entity().saveDocument();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }



        }
    }
}
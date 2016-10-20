package edt.textui.main;
import edt.core.*;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import edt.textui.main.Message;


/**
 * Command for showing the metadata of the current document in the editor.
 */
public class ShowMetadata extends Command<Document> {

    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public ShowMetadata(Document ent) {
        super(MenuEntry.SHOW_METADATA, ent);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        Display d = new Display();
      
        d.add(Message.documentTitle(entity().getTitle())+"\n");
        for(Author a : entity().getAuthorArray()){
            d.add(Message.author(a.getName(),a.getEmail()) +"\n");
        }
        d.add(Message.documentSections(entity().getSubSections().size())+"\n");
        d.add((Message.documentBytes(entity().getSize()) +"\n"));
        d.add(Message.documentIdentifiers(entity().getTextElementHashMap().size())+"\n");
        d.display();

    }
}

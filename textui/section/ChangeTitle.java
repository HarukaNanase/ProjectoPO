package edt.textui.section;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import edt.core.Section;
import edt.core.Document;
import edt.textui.section.Message;


/**
 * Command for changing the title of the current section.
 */
public class ChangeTitle extends Command<Section> {

    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public ChangeTitle(Section ent) {
        super(MenuEntry.CHANGE_TITLE, ent);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        Form f = new Form();
        InputString input = new InputString(f,Message.requestSectionTitle());
        f.parse();
        entity().setTitle(input.value());
    }
}

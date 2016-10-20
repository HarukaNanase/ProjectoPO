package edt.textui.section;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;
import pt.utl.ist.po.ui.InputString;
import edt.core.Section;

/**
 * Command for adding a subsection to current section.
 */
public class InsertSection extends Command<Section> {

    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public InsertSection(Section ent) {
        super(MenuEntry.INSERT_SECTION, ent);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        Form f = new Form();
        InputInteger inputI = new InputInteger(f,Message.requestSectionId());
        InputString inputS = new InputString(f,Message.requestSectionTitle());
        f.parse();
       
        entity().addSection(inputI.value(),new Section(inputS.value()));

    }
}

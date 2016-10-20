package edt.textui.section;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import edt.core.Section;


/**
 * Command for listing all subsections of the current section.
 */
public class ListSections extends Command<Section> {

    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public ListSections(Section ent) {
        super(MenuEntry.LIST_SECTIONS, ent);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        Display d = new Display();
        for(Section s : entity().getSubSections()){
            d.add(Message.sectionIndexEntry(s.getKey(),s.getTitle())+"\n");
            d.add(s.getSubsectionIndex());
        }
        d.display();
    }
}

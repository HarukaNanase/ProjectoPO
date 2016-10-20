package edt.textui.section;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import edt.core.Section;
import edt.core.Paragraph; 


/**
 * Command for showing the content of current section.
 */
public class ShowSection extends Command<Section> {

    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public ShowSection(Section ent) {
        super(MenuEntry.SHOW_CONTENT, ent);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        String content = "";
        Display d = new Display();

        d.add(entity().getHeadline()+"\n");

        for (Paragraph p : entity().getParagraphs()){
           content += p.getContent()+"\n";
        }
        for (Section s : entity().getSubSections()){
            content += s.getContent();
        }
        
        d.add(content);
        d.display();

     }
}

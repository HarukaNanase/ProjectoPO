package edt.textui;
import edt.textui.main.MainMenu;

import edt.core.*;
import edt.parser.Parser;
import java.io.*;
import edt.core.exceptions.*;
/**
 * The main class of the edt application.
 **/
public class Editor {

    public static void main(String[] args) {
        Document doc = new Document();
        String fileName = System.getProperty("import");
       	
        if(fileName != null){
            try {
            Parser parser = new Parser();
            doc = parser.parse(fileName);
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
        
        MainMenu menu = new MainMenu(doc);
        menu.open();
        
        
    
    
    }
}
package es.uniovi.eii.ds.text_editor.command;

import es.uniovi.eii.ds.text_editor.Command;

public abstract class AbstractCommand implements Command {
	
    protected boolean checkArguments(String[] args, int expected, String syntax) {
        if (args.length != expected) {
            System.out.println("Invalid number of arguments => " + syntax);
            return false;
        }
        return true;
    }

}

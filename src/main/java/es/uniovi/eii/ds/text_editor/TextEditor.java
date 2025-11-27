package es.uniovi.eii.ds.text_editor;

import java.util.HashMap;
import java.util.Map;

public class TextEditor {
	
	private Map<String, Command> commands;
	private CommandExecutor executor;
	
	private Command selectedCommand;
	
	// Represents the document of the editor.
	private StringBuilder text = new StringBuilder();

	public TextEditor() {
		this.commands = new HashMap<>();
	}
	
	public void addCommand(String name, Command command) {
		commands.put(name, command);
	}
	
	public void execute(String name, String... params) {
		if(selectedCommand == null) {
		Command command = commands.get(name);
		if(command == null)
			System.out.println("Unknown command");
		else 
			command.execute(params);
		} else {
			selectedCommand.execute(params);
		}
	}

	public void setText(StringBuilder text) {
		this.text = text;
	}
	
	public StringBuilder getText() {
		return this.text;
	}
	
	public void commandFinished() {
		this.selectedCommand = null;
	}
	
	

}

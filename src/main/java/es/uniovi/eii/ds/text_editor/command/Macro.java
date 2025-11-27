package es.uniovi.eii.ds.text_editor.command;

import java.util.ArrayList;
import java.util.List;

import es.uniovi.eii.ds.text_editor.Command;

public class Macro implements Command {
	
	private List<Command> commands = new ArrayList<Command>();
	private String name;
	
	public Macro(String name) {
		this.name = name;
	}

	@Override
	public void execute(String... args) {
		for(Command command : commands) {
			command.execute(args);
		}
	}

	@Override
	public String getName() {
		return name;
	}
	
	public void addCommand(Command command) {
		commands.add(command);
	}

}

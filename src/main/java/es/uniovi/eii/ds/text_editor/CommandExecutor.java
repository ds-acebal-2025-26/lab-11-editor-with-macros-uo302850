package es.uniovi.eii.ds.text_editor;

public interface CommandExecutor {

	void execute(Command command, String... args);
	
}

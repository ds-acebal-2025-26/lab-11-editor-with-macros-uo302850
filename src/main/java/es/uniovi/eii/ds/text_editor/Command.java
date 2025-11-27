package es.uniovi.eii.ds.text_editor;

public interface Command {
	
	void execute(String... args);
	
	String getName();

}

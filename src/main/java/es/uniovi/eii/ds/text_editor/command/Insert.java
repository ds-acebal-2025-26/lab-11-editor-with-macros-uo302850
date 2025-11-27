package es.uniovi.eii.ds.text_editor.command;

import es.uniovi.eii.ds.text_editor.Command;
import es.uniovi.eii.ds.text_editor.TextEditor;

public class Insert implements Command {
	
	private TextEditor editor;
	
	public Insert(TextEditor editor) {
		this.editor = editor;
	}

	@Override
	public void execute(String... args) {
		for (String word : args) {
			editor.getText().append(" ").append(word);
		}
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

}

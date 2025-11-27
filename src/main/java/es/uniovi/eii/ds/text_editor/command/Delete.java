package es.uniovi.eii.ds.text_editor.command;

import es.uniovi.eii.ds.text_editor.Command;
import es.uniovi.eii.ds.text_editor.TextEditor;

public class Delete implements Command {
	
	private TextEditor editor;
	
	public Delete(TextEditor editor) {
		this.editor = editor;
	}

	@Override
	public void execute(String... args) {
		int indexOfLastWord = editor.getText().toString().trim().lastIndexOf(" ");
		if (indexOfLastWord == -1)
			editor.setText(new StringBuilder(""));
		else
			editor.getText().setLength(indexOfLastWord);
	}

	@Override
	public String getName() {
		return "delete";
	}

}

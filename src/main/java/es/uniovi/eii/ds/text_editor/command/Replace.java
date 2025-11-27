package es.uniovi.eii.ds.text_editor.command;

import es.uniovi.eii.ds.text_editor.Command;
import es.uniovi.eii.ds.text_editor.TextEditor;

public class Replace extends AbstractCommand implements Command {
	
	private TextEditor editor;
	
	public Replace(TextEditor editor) {
		this.editor = editor;
	}

	@Override
	public void execute(String... args) {
		if (!checkArguments(args, 2, "replace <find> <replace>"))
			return;
		String find = args[0];
		String replace = args[1];
		editor.setText(new StringBuilder(editor.getText().toString().replace(find, replace)));
	}

	@Override
	public String getName() {
		return "replace";
	}

}

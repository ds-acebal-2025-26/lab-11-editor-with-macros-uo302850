package es.uniovi.eii.ds.text_editor.command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;

import es.uniovi.eii.ds.text_editor.Command;
import es.uniovi.eii.ds.text_editor.TextEditor;

public class OpenFile extends AbstractCommand implements Command {
	
	private TextEditor editor;

	public OpenFile(TextEditor editor) {
		this.editor = editor;
	}

	@Override
	public void execute(String... args) {
		if (!checkArguments(args, 1, "open <file>"))
			return;
		try {
			String filename = args[0];
			editor.setText(new StringBuilder(readFile(filename)));
		} catch (Exception e) {
			System.out.println("Document could not be opened");
		}
	}
	
	private String readFile(String filename) {
		InputStream in = getClass().getResourceAsStream("/" + filename);
		if (in == null)
			throw new IllegalArgumentException("File not found: " + filename);

		try (BufferedReader input = new BufferedReader(new InputStreamReader(in))) {
			StringBuilder result = new StringBuilder();
			String line;
			boolean firstLine = true;
			while ((line = input.readLine()) != null) {
				if (!firstLine)
					result.append(System.lineSeparator());
				result.append(line);
				firstLine = false;
			}
			return result.toString();
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}

	@Override
	public String getName() {
		return "open";
	}

}

package es.uniovi.eii.ds.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import es.uniovi.eii.ds.text_editor.TextEditor;
import es.uniovi.eii.ds.text_editor.command.Delete;
import es.uniovi.eii.ds.text_editor.command.Help;
import es.uniovi.eii.ds.text_editor.command.Insert;
import es.uniovi.eii.ds.text_editor.command.OpenFile;
import es.uniovi.eii.ds.text_editor.command.Replace;

public class Main {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
    public static void main(String[] args) {
        new Main().run();
    }
	
	// Main program loop.
    public void run() {
    	TextEditor editor = new TextEditor();
    	
    	editor.addCommand("open", new OpenFile(editor));
    	editor.addCommand("insert", new Insert(editor));
    	editor.addCommand("delete", new Delete(editor));
    	editor.addCommand("replace", new Replace(editor));
    	editor.addCommand("help", new Help());
    	
		drawLogo();
		editor.execute("help");

		while (true) {
			UserCommand command = promptUser();
			String[] args = command.args;
			
			editor.execute(command.name, args);

			System.out.println(editor.getText());
		}
	}

	//$-- Auxiliary methods ---------------------------------------------------

	// YOU DON'T NEED TO UNDERSTAND OR MODIFY THE CODE BELOW THIS LINE

	private record UserCommand(String name, String[] args) {}

    // Prompts the user and reads a line of input and returns it as a record with
	// the command and its arguments. If EOF is reached (i.e., there are nothing to
	// read), an error occurs or the user types "exit", the program exits. If there
	// are no arguments, the args array is empty.
	//
	// Example:
	//
	//   > insert "no quiero acordarme" --> returns UserInput("insert", ["no", "quiero", "acordarme"])
	//	 > delete                       --> returns UserInput("delete", [])
	//
	private UserCommand promptUser() {
		while (true) {
            System.out.print("> ");
            try {
                String line = in.readLine();
				if (line == null) System.exit(0);
				if (line.equals("exit")) exit();
				if (line.isBlank()) continue;
				String[] parts = line.split("\\s+");
				return new UserCommand(parts[0], Arrays.copyOfRange(parts, 1, parts.length));
            } catch (IOException e) {
                System.out.println("Error reading input");
				System.exit(2);
			}
		}
    }

	private void exit() {
		System.out.println("Goodbye!");
		System.exit(0);
	}	

	private void drawLogo() {
		System.out.println(LOGO);
	}

	private static final String LOGO = """

			███╗   ███╗ █████╗  ██████╗████████╗███████╗██╗  ██╗
			████╗ ████║██╔══██╗██╔════╝╚══██╔══╝██╔════╝╚██╗██╔╝
			██╔████╔██║███████║██║        ██║   █████╗   ╚███╔╝ 
			██║╚██╔╝██║██╔══██║██║        ██║   ██╔══╝   ██╔██╗ 
			██║ ╚═╝ ██║██║  ██║╚██████╗   ██║   ███████╗██╔╝ ██╗
			╚═╝     ╚═╝╚═╝  ╚═╝ ╚═════╝   ╚═╝   ╚══════╝╚═╝  ╚═╝
			""";
}

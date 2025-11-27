package es.uniovi.eii.ds.text_editor.command;

import es.uniovi.eii.ds.text_editor.Command;

public class Help implements Command {
	
	private static final String HELP = """
			┌──────────────────────┬─────────────────────────────────────────────┐
			│ open <file>          │                                             │
			│ insert <text>        │ append text to the end                      │
			│ delete               │ delete the last word                        │
			│ replace <a> <b>      │ replace <a> with <b> in the whole document  │
			├──────────────────────┼─────────────────────────────────────────────┤
			│ record <macro>       │ start recording a macro                     │
			│ stop                 │ stop recording                              │
			│ execute <macro>      │ execute the specified macro                 │
			├──────────────────────┼─────────────────────────────────────────────┤
			│ help                 │                                             │
			│ exit                 │                                             │
			└──────────────────────┴─────────────────────────────────────────────┘
			""";

	@Override
	public void execute(String... args) {
		System.out.println(HELP);
	}

	@Override
	public String getName() {
		return "help";
	}

}

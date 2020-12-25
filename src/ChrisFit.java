public class ChrisFit {

	public static void main(String[] args) {
		// ---------------- edit this to where you want to save your files -----------------
		String location = "/Users/christian/Documents/git/ChrisFit/src";
		// *********************************************************************************
		// =================================================================================
		// ----------------------------- do not edit below!!! ------------------------------
		// =================================================================================
		// *********************************************************************************

		
		// defining constants that will be used
		ConsoleText.intro();
		final String filepath = location + "/userdata.txt";
		Menu.loadFiles(filepath);
				
		Boolean quit = false;
		while (quit == false) {
			quit = Menu.mainMenu(filepath);
		}
		
		String line = FileEditor.tryReadLine(filepath, "LOG");
		System.out.println(line);
		System.out.println("\nGoodbye\n");
	}

}

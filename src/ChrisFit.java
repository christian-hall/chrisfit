import java.io.IOException;

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
		
		// starting file
		Boolean quit = false;
		// check to see if the user file exists
		quit = true; //delete this later
		while (quit == false) {
		}
		try {
			FileManager.appendFile(filepath, "\ntest append");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Main Menu
		//goodbye text
		System.out.println("\nGoodbye\n");
	}

}

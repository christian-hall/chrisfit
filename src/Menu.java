import java.time.LocalDate;

public class Menu {
	
	public static void loadFiles(String filepath) {
		Boolean olduser = FileEditor.verifyFile(filepath);
		if (olduser == false) {
			System.out.println("\nUser file not detected. Welcome new user!");
			String userName = Console.getString("Enter your name: ", true);
			// Get valid birthday here
			LocalDate birthDay = Console.getDate("Enter Year, 4 digits: ", "Enter Birth Month: ", "Enter birthday: ");
			double weightGoal = Console.getDouble("\nEnter your weigh goal in lbs: ");
			FileEditor.writeFile(filepath,
					"*********** DO NOT DELETE ***********\n" + "********* ChrisFit UserFile *********\n" + "USER: "
							+ userName + "\n" + "GOAL: " + weightGoal + "\n"
							+ "*************************************");
		} else {
			String line = FileEditor.readLine(filepath, "USER: ");
			String userName = FileEditor.extractString(line, 6);
			System.out.println("Welcome back, " + userName + "!\n");
		}
	}
	
	public static Boolean mainMenu(String filepath) {
		ConsoleText.mainMenuText();
		int choice = Console.getInt("ENTER CHOICE: ", -1, 2);
		// replace with a switch statement
		switch (choice) {
			case 0: //will always be quit
				return true;
			case 1: // initiate weigh-in
				return false;
			default:
				System.out.println("please enter valid choice");
				return true;
		}
	}
}

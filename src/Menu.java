import java.time.LocalDate;

public class Menu {

	public static void loadFiles(String filepath) {
		Boolean olduser = FileEditor.verifyFile(filepath);
		if (olduser == false) {
			System.out.println("\nUser file not detected...");
			String userName = Console.getString("\nEnter your name: ", true);
			LocalDate birthDay = Console.enterDate("Enter Birth Year, 4 digits: ", "Enter Birth Month, 2 digits: ",
					"Enter Birth Day: ");
			String sex = Console.getString("Enter your sex (M/F): ", "M", "F");
			double height = Console.getDouble("Enter your height in inches: ");
			double poundsperweek = Console.getDouble("How much do you want to lose a week (in pounds)?: ", 0.4, 2.1);
			double weightGoal = Console.getDouble("Enter your weigh goal in lbs: ");
			double activity = getActivity();
			FileEditor.writeFile(filepath,
					"*********** DO NOT DELETE ***********\n" + "********* ChrisFit UserFile *********\nUSER: "
							+ userName + "\nBIRTHDATE: " + birthDay + "\nSEX: " + sex + "\nWEEKLOSS: " + poundsperweek
							+ "\nACTIVITY: " + activity + "\nHEIGHT: " + height + "\nGOAL: " + weightGoal
							+ "\n*************************************");
			System.out.println("\nWelcome, " + userName + "!");
			if (Console.getBirthday(filepath) == true) {
				System.out.println("Happy birthday!");
			}
		} else {
			String line = FileEditor.readLine(filepath, "USER: ");
			String userName = FileEditor.extractString(line, 6);
			System.out.println("Welcome back, " + userName + "!");
			if (Console.getBirthday(filepath) == true) {
				System.out.println("Happy birthday!");
			}
			System.out.println();
		}
	}

	public static double getActivity() {
		System.out.println("\nHow active are you?");
		System.out.println("1 - sedentary (little to no exercise");
		System.out.println("2 - lightly active (1-3 days per week");
		System.out.println("3 - moderately active (3-5 days per week");
		System.out.println("4 - very active (6-7 days per week");
		System.out.println("5 - extra active (phyically active most of the day");
		int choice = Console.getInt("Enter choice: ", 0, 6);
		if (choice == 1) {
			return 1.2;
		} else if (choice == 2) {
			return 1.375;
		} else if (choice == 3) {
			return 1.55;
		} else if (choice == 4) {
			return 1.725;
		} else {
			return 1.9;
		}
	}

	public static Boolean mainMenu(String filepath) {
		ConsoleText.mainMenuText();
		int choice = Console.getInt("ENTER CHOICE: ", -1, 2);
		// replace with a switch statement
		switch (choice) {
		case 0: // will always be quit
			return true;
		case 1: // initiate weigh-in
			return false;
		default:
			System.out.println("please enter valid choice");
			return true;
		}
	}
}

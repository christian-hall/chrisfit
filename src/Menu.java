
public class Menu {
	
	public static void loadFiles(String filepath) {
		Boolean olduser = FileManager.verifyFile(filepath);
		if (olduser == false) {
			System.out.println("\nUser file not detected. Welcome new user!");
			String userName = Console.getString("Enter your name: ", true);
			double weightGoal = Console.getDouble("\nEnter your weigh goal in lbs: ");
			FileManager.writeFile(filepath,
					"*********** DO NOT DELETE ***********\n" + "********* ChrisFit UserFile *********\n" + "USER: "
							+ userName + "\n" + "GOAL: " + weightGoal + "\n"
							+ "*************************************");
		} else {
			String line = FileManager.readLine(filepath, "USER: ");
			String userName = FileManager.extractString(line, 6);
			System.out.println("Welcome back, " + userName + "!\n");
		}
	}
	
	public static void enterWeight(String filepath) {
		
	}
}

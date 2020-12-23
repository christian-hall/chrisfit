
import java.time.LocalDate;
import java.util.Scanner;

public class Console {

	private static Scanner sc = new Scanner(System.in);

	// these next two strings ensure a response is required and checks requirements
	public static String getString(String prompt) {
		return getString(prompt, false);
	}

	public static String getString(String prompt, boolean isRequired) {
		String s = "";
		boolean isValid = false;
		while (!isValid) {
			System.out.print(prompt);
			s = sc.nextLine();
			if (isRequired && s.equals("")) {
				System.out.println("Error! This entry is required. Try again.");
			} else {
				isValid = true;
			}
		}
		return s;
	}

	public static String getString(String prompt, String s1, String s2) {
		String s = "";
		boolean isValid = false;
		while (!isValid) {
			s = getString(prompt, true);
			if (!s.equalsIgnoreCase(s1) && !s.equalsIgnoreCase(s2)) {
				System.out.println("Error! Entry must be '" + s1 + "' or '" + s2 + "'. Try again.");
			} else {
				isValid = true;
			}
		}
		return s;
	}

	public static int getInt(String prompt) {
		int i = 0;
		boolean isValid = false;
		while (!isValid) {
			System.out.print(prompt);
			if (sc.hasNextInt()) {
				i = sc.nextInt();
				isValid = true;
			} else {
				System.out.println("Error! Invalid integer. Try again.");
			}
			sc.nextLine(); // discard any other data entered on the line
		}
		return i;
	}

	public static int getInt(String prompt, int min, int max) {
		int i = 0;
		boolean isValid = false;
		while (!isValid) {
			i = getInt(prompt);
			if (i <= min) {
				System.out.println("Error! Number must be greater than " + min + ".");
			} else if (i >= max) {
				System.out.println("Error! Number must be less than " + max + ".");
			} else {
				isValid = true;
			}
		}
		return i;
	}

	public static double getDouble(String prompt) {
		double d = 0;
		boolean isValid = false;
		while (!isValid) {
			System.out.print(prompt);
			if (sc.hasNextDouble()) {
				d = sc.nextDouble();
				isValid = true;
			} else {
				System.out.println("Error! Invalid number. Try again.");
			}
			sc.nextLine(); // discard any other data entered on the line
		}
		return d;
	}

	public static double getDouble(String prompt, double min, double max) {
		double d = 0;
		boolean isValid = false;
		while (!isValid) {
			d = getDouble(prompt);
			if (d <= min) {
				System.out.println("Error! Number must be greater than " + min + ".");
			} else if (d >= max) {
				System.out.println("Error! Number must be less than " + max + ".");
			} else {
				isValid = true;
			}
		}
		return d;
	}

	public static LocalDate getDate(String yearPrompt, String monthPrompt, String dayPrompt) {
		int year = getInt(yearPrompt);
		int month = getInt(monthPrompt, 0, 13);
		int day = 0;
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
			day = getInt(dayPrompt, 0, 32);
		} else if (month == 4 || month == 6 || month == 9 || month == 11) {
			day = getInt(dayPrompt, 0, 31);
		} else if (day == 2) {
			if (year % 4 == 0) {
				day = getInt(dayPrompt, 0, 30);
			} else if (year % 4 != 0) {
				day = getInt(dayPrompt, 0, 29);
			}
		}			
		LocalDate date = LocalDate.of(year, month, day);
		return date;
	}
}

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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

	public static LocalDate enterDate(String yearPrompt, String monthPrompt, String dayPrompt) {
		int year = getInt(yearPrompt);
		int month = getInt(monthPrompt, 0, 13);
		int day = 1;
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
			day = getInt(dayPrompt, 0, 32);
		} else if (month == 4 || month == 6 || month == 9 || month == 11) {
			day = getInt(dayPrompt, 0, 31);
		} else if (month == 2) {
			if (year % 4 == 0) {
				day = getInt(dayPrompt, 0, 30);
			} else if (year % 4 != 0) {
				day = getInt(dayPrompt, 0, 29);
			}
		}
		LocalDate date = LocalDate.of(year, month, day);
		return date;
	}

	public static LocalDate getDate(String filepath, String key, int index) {
		String dateString = FileEditor.readLine(filepath, key);
		dateString = FileEditor.extractString(dateString, index);
		String[] elements = dateString.split("-");
		int year = Integer.parseInt(elements[0]);
		int month = Integer.parseInt(elements[1]);
		int day = Integer.parseInt(elements[2]);
		return LocalDate.of(year, month, day);
	}

	public static int getAge(String filepath) {
		int age = 0;
		LocalDate birthDate = getDate(filepath, "BIRTHDATE", 11);
		LocalDate today = LocalDate.now();
		int thisYear = today.getYear();
		int thisMonth = today.getMonthValue();
		int thisDay = today.getDayOfMonth();
		int birthYear = birthDate.getYear();
		int birthMonth = birthDate.getMonthValue();
		int birthDay = birthDate.getDayOfMonth();
		if (thisYear % 4 != 0 && birthMonth == 2 && birthDay == 29) {
			birthDay = 28;
		}

		if (thisYear > birthYear) {
			if (thisMonth < birthMonth) {
				age = (thisYear - birthYear - 1);
			} else if (thisMonth > birthMonth) {
				age = (thisYear - birthYear);
			} else if (thisMonth == birthMonth) {
				if (thisDay > birthMonth) {
					age = (thisYear - birthYear);
				} else if (thisDay >= birthDay) {
					age = (thisYear - birthYear - 1);
				}
			}
		}
		return age;
	}

	public static Boolean getBirthday(String filepath) {
		LocalDate birthDate = getDate(filepath, "BIRTHDATE", 11);
		LocalDate today = LocalDate.now();
		int thisYear = today.getYear();
		int thisMonth = today.getMonthValue();
		int thisDay = today.getDayOfMonth();
		int birthMonth = birthDate.getMonthValue();
		int birthDay = birthDate.getDayOfMonth();
		if (thisYear % 4 != 0 && birthMonth == 2 && birthDay == 29) {
			birthDay = 28;
		}
		if (thisMonth - birthMonth == 0 && thisDay - birthDay == 0) {
			return true;
		} else {
			return false;
		}
	}

	public static int dailyCal(String filepath, double todaysWeight) {
		double age = (int) Console.getAge(filepath);
		String sex = FileEditor.extractString(FileEditor.readLine(filepath, "SEX:"), 5);
		double weekloss = (Double.parseDouble(FileEditor.extractString(FileEditor.readLine(filepath, "WEEKLOSS: "), 10))
				* 500);
		double activity = Double.parseDouble(FileEditor.extractString(FileEditor.readLine(filepath, "ACTIVITY: "), 10));
		double height = Double.parseDouble(FileEditor.extractString(FileEditor.readLine(filepath, "HEIGHT: "), 8));

		if (sex.equalsIgnoreCase("m")) {
			return (int) ((activity * (66 + (6.2 * todaysWeight) + (12.7 * height) - (6.76 * age))) - weekloss);
		} else {
			return (int) ((activity * (655.1 + (4.35 * todaysWeight) + (4.7 * height) - (4.7 * age))) - weekloss);
		}
	}

	public static int getIndex(String filepath) {
		String checkFile = FileEditor.tryReadLine(filepath, "LOG");
		if (checkFile.equals("NULL")) {
			return 1;
		} else {
			int highIndex = 0;
			ArrayList<String> logs = new ArrayList<String>(FileEditor.readLogs(filepath, "LOG:"));
			for (String log : logs) {
				// parse string to extract int string
				String indexString = FileEditor.extractString(log, 5);
				String[] indexStrings = indexString.split(" ");
				int index = Integer.parseInt(indexStrings[0]);
				if (index > highIndex) {
					highIndex = index;
				}
			}
			return (highIndex + 1);
		}
	}
}
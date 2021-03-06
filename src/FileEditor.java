import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class FileEditor {

	// checks that a file exists
	public static Boolean verifyFile(String filepath) {
		File userData = new File(filepath);
		if (userData.exists() == false) {
			return false;
		} else {
			return true;		
		}
	}

	public static void writeFile(String filepath, String filetext) {
		try {
			FileWriter writer = new FileWriter(filepath);
			writer.write(filetext);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// isolates and returns a line of text based on what's in it
	public static String readLine(String filepath, String key) {
		String line;
		try (BufferedReader readFile = new BufferedReader(new FileReader(filepath))) {
			while ((line = readFile.readLine()) != null) {
				if (line.contains(key)) {
					return line;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			line = null;
		}
		return line;
	}
	
	// splits a string based on index and returns the second half
	public static String extractString(String line, int index) {
		String isolated = line.substring(index);
		return isolated;
	}
	
	// adds a line to the string, will need this to enter weigh-ins
	public static void appendFile(String filepath, String filetext) throws IOException{
		BufferedWriter writer = new BufferedWriter(new FileWriter(filepath, true));
		writer.write(filetext);
		writer.close();
	}
	
	// tires to isolate the string, returns "NULL" if invalid
	public static String tryReadLine(String filepath, String key) {
		String line;
		try (BufferedReader readFile = new BufferedReader(new FileReader(filepath))) {
			while ((line = readFile.readLine()) != null) {
				if (line.contains(key)) {
					return line;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "NULL";
	}
	
	public static ArrayList<String> readLogs(String filepath, String key) {
		String line;
		ArrayList<String> lines = new ArrayList<String>();
		try (BufferedReader readFile = new BufferedReader(new FileReader(filepath))) {
			while ((line = readFile.readLine()) != null) {
				if (line.contains(key)) {
					lines.add(line);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lines;
	}
}

// Data Structures and Algorithms
// CCT College Dublin
// Marcos Valdeni Lucas 2016280
// Cristian Olimpio Fernandes 2016323

package util;

public class util {
	
	public static boolean equals(String a, String b) {
		if (a.equals(b)) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean validFild(String s) {
		if (checkSpaces(s)) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean checkSpaces(String str) {

		boolean check;

		int letterCount = 0;
		int spaceCount = 0;
		for (char c : str.toCharArray()) {
			if (c == ' ') {
				spaceCount++;
			} else {
				letterCount++;
			}
		}

		if (spaceCount >= letterCount) {
			check = false;
		} else {
			check = true;
		}

		return check;
	}
	
	public static boolean checkNumber(String str) {

		boolean check;

		if (str.matches("[0-9]+")) {
			check = true;
		} else {
			check = false;
		}

		return check;
	}
}

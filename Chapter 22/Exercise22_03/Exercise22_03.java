import java.util.Scanner;

public class Exercise22_03 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a string s1: ");
		String s1 = input.nextLine();
		System.out.print("Enter a string s2: ");
		String s2 = input.nextLine();
		System.out.println(findMatch(s1, s2));
	}
		//This algorithm is O(n) time because worst case is that it only goes through once.
	public static String findMatch(String s1, String s2) {
		boolean match = false;
		String index = "No match found.";
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) == s2.charAt(0)) {
				for (int j = 0; j < s2.length(); j++) {
					if (s1.charAt(i + j) == s2.charAt(j)) {
						match = true;
					}
					else {
						match = false;
					}
				}
				if (match == true) {
					index = "Match found at index " + i;
					return index;
				}
			}
		}
		return index;
	}

}

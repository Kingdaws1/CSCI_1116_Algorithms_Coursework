import java.util.ArrayList;
import java.util.Scanner;

public class Exercise21_01 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a string: ");
		String string = input.next();
		System.out.println("Maximum consecutive substring is " + longestIncreasingOrderFinder(string));
	}
	
	public static String longestIncreasingOrderFinder(String userString) {
		char smallest = userString.charAt(0);
		ArrayList<String> runs = new ArrayList<String>();
		String longest = "" + smallest;
		for (int i = 1; i < userString.length(); i++) {
			if (userString.charAt(i) <= smallest) {
				runs.add(longest);
				smallest = userString.charAt(i);
				longest = "" + smallest;
			}
			else {
				longest += userString.charAt(i);
			}
		}
		for (int i = 0; i < runs.size(); i++) {
			if (runs.size() == 1) {
				longest = runs.get(i);
			}
			else {
				if (i == 0) {
					longest = runs.get(i);
				}
				else {
					if (runs.get(i).length() > longest.length()) {
						longest = runs.get(i);
					}
				}
			}
		}
		return longest;
	}

}

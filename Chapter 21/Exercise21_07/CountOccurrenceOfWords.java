import java.util.*;

public class CountOccurrenceOfWords {
	public static void main(String[] args) {
		// Set text in a string
		String text = "Good morning. Have a good class. " +
			"Have a good visit. Have fun!";

		// Create a TreeMap to hold words as key and count as value
		Map<String, Integer> map = new HashMap<>();

		String[] words = text.split("[\\s+\\p{P}]");
		for (int i = 0; i < words.length; i++) {
			String key = words[i].toLowerCase();
			
			if (key.length() > 0) {
				if (!map.containsKey(key)) {
					map.put(key, 1);
				}
				else {
					int value = map.get(key);
					value++;
					map.put(key, value);
				}
			}
		}
		
		ArrayList<WordOccurrance> list = new ArrayList<WordOccurrance>();
		map.forEach((k, v) -> {
			WordOccurrance x = new WordOccurrance();
			x.count = v;
			x.word = k;
			list.add(x);
		});
		list.sort(null);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).word + "\t" + list.get(i).count);
		}
		// Display key and value for each entry
		//map.forEach((k, v) -> System.out.println(k + "\t" + v));
	}
	
}

class WordOccurrance implements Comparable<WordOccurrance> {
	String word;
	int count;
	
	@Override
	public int compareTo(WordOccurrance o) {
		return compare(this.count, o.count);
	}
	
	public static int compare(int num1, int num2) {
		if (num1 > num2) {
			return 1;
		}
		else if (num1 == num2) {
			return 0;
		}
		else {
			return -1;
		}
	}
	
}
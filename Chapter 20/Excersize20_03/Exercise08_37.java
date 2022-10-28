import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Exercise08_37 {
	
  public static void main(String[] args) {
	  ArrayList<ArrayList<String>> stateCapital = new ArrayList<ArrayList<String>>();
	  
    String[][] stateCapitalArray = {
      {"Alabama", "Montgomery"},
      {"Alaska", "Juneau"},
      {"Arizona", "Phoenix"},
      {"Arkansas", "Little Rock"},
      {"California", "Sacramento"},
      {"Colorado", "Denver"},
      {"Connecticut", "Hartford"},
      {"Delaware", "Dover"},
      {"Florida", "Tallahassee"},
      {"Georgia", "Atlanta"},
      {"Hawaii", "Honolulu"},
      {"Idaho", "Boise"},
      {"Illinois", "Springfield"},
      {"Indiana", "Indianapolis"},
      {"Iowa", "Des Moines"},
      {"Kansas", "Topeka"},
      {"Kentucky", "Frankfort"},
      {"Louisiana", "Baton Rouge"},
      {"Maine", "Augusta"},
      {"Maryland", "Annapolis"},
      {"Massachusettes", "Boston"},
      {"Michigan", "Lansing"},
      {"Minnesota", "Saint Paul"},
      {"Mississippi", "Jackson"},
      {"Missouri", "Jefferson City"},
      {"Montana", "Helena"},
      {"Nebraska", "Lincoln"},
      {"Nevada", "Carson City"},
      {"New Hampshire", "Concord"},
      {"New Jersey", "Trenton"},
      {"New York", "Albany"},
      {"New Mexico", "Santa Fe"},
      {"North Carolina", "Raleigh"},
      {"North Dakota", "Bismarck"},
      {"Ohio", "Columbus"},
      {"Oklahoma", "Oklahoma City"},
      {"Oregon", "Salem"},
      {"Pennsylvania", "Harrisburg"},
      {"Rhode Island", "Providence"},
      {"South Carolina", "Columbia"},
      {"South Dakota", "Pierre"},
      {"Tennessee", "Nashville"},
      {"Texas", "Austin"},
      {"Utah", "Salt Lake City"},
      {"Vermont", "Montpelier"},
      {"Virginia", "Richmond"},
      {"Washington", "Olympia"},
      {"West Virginia", "Charleston"},
      {"Wisconsin", "Madison"},
      {"Wyoming", "Cheyenne"}
    };
    
    for (int i = 0; i < stateCapitalArray.length; i++) {
    	ArrayList<String> name = new ArrayList<String>();
    	for (int j = 0; j < 2; j++) {
    		name.add(stateCapitalArray[i][j]);
    	}
    	stateCapital.add(name);
    }
    stateCapital.trimToSize();
    Collections.shuffle(stateCapital);
    
    Scanner input = new Scanner(System.in);
    
    int correctCount = 0;
    for (int i = 0; i < stateCapital.size(); i++) {
      // Prompt the user with a question
      System.out.print("What is the capital of " + stateCapital.get(i).get(0) + "? ");
      String capital = input.nextLine().trim().toLowerCase();
      
      if (capital.toLowerCase().equals(stateCapital.get(1).get(1).toLowerCase())) {
        System.out.println("Your answer is correct");
        correctCount++;
      }
      else
        System.out.println("The correct answer should be " + stateCapital.get(i).get(1));
    }
    System.out.println("The correct count is " + correctCount);
  }
}
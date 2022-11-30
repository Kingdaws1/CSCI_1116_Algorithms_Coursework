import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Exercise21_11 extends Application {
  private Map<String, Integer>[] mapForBoy = new HashMap[10];
  private Map<String, Integer>[] mapForGirl = new HashMap[10];
  
  private Button btFindRanking = new Button("Find Ranking");
  private ComboBox<Integer> cboYear = new ComboBox<>();
  private ComboBox<String> cboGender = new ComboBox<>();
  private TextField tfName = new TextField();
  private Label lblResult = new Label();
  
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) throws IOException {
	  
	  try {
	      for (int i = 0; i <= 9; i++) {
	        URL url = new URL("http://liveexample.pearsoncmg.com/data/babynamesranking" + (2001 + i) + ".txt");
	        Scanner input = new Scanner(url.openStream());
	        
	        mapForBoy[i] = new HashMap<>();
	        mapForGirl[i] = new HashMap<>();
	        while (input.hasNext()) {
	          int ranking = input.nextInt();
	          String boyname = input.next();
	          input.nextInt(); // Skip the number of boy's name
	          String girlname = input.next();
	          input.nextInt(); // Skip the number of girl's name
	          
	          mapForBoy[i].put(boyname, ranking);
	          mapForGirl[i].put(girlname, ranking);
	        }
	      }
	    } catch (FileNotFoundException e0) {
	    	System.out.println("not connecting to lists");
	    }

	btFindRanking.setOnAction(e -> {
		if (cboGender.getValue() == "Male") {
			if (mapForBoy[cboYear.getValue() - 2001].get(tfName.getText()) == null) {
				lblResult.setText("That name is not ranked.");
			} else {
			int ranking = mapForBoy[cboYear.getValue() - 2001].get(tfName.getText());
			lblResult.setText(cboGender.getValue() + " name " + tfName.getText() + " is ranked #" + ranking + " in year " + cboYear.getValue());
			}
		}
		else {
			if (mapForGirl[cboYear.getValue() - 2001].get(tfName.getText()) == null) {
				lblResult.setText("That name is not ranked.");
			} else {
			int ranking = mapForGirl[cboYear.getValue() - 2001].get(tfName.getText());
			lblResult.setText(cboGender.getValue() + " name " + tfName.getText() + " is ranked #" + ranking + " in year " + cboYear.getValue());
			}
		}
	});
	  
    GridPane gridPane = new GridPane();    
    gridPane.add(new Label("Select a year:"), 0, 0);
    gridPane.add(new Label("Boy or girl?"), 0, 1);
    gridPane.add(new Label("Enter a name:"), 0, 2);
    gridPane.add(cboYear, 1, 0);
    gridPane.add(cboGender, 1, 1);
    gridPane.add(tfName, 1, 2);
    gridPane.add(btFindRanking, 1, 3);
    gridPane.setAlignment(Pos.CENTER);
    gridPane.setHgap(5);
    gridPane.setVgap(5);
  
    BorderPane borderPane = new BorderPane();
    borderPane.setCenter(gridPane);
    borderPane.setBottom(lblResult);
    BorderPane.setAlignment(lblResult, Pos.CENTER);

    // Create a scene and place it in the stage
    Scene scene = new Scene(borderPane, 370, 160);
    primaryStage.setTitle("Exercise21_11"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage

    for (int year = 2001; year <= 2010; year++) {
      cboYear.getItems().add(year);
    }
    cboYear.setValue(2001);
        
    cboGender.getItems().addAll("Male", "Female");
    cboGender.setValue("Male");
    
  }

  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }
}

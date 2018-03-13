package ch.makery.address;

import java.io.IOException;

import ch.makery.address.controller.PersonOverviewController;
import ch.makery.address.model.Person;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * @author abjohnson395@gmail.com
 *
 */
public class MainApp extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;
	
	private ObservableList<Person> personData = FXCollections.observableArrayList(); 
	
	/**
     * Default Constructor
     */
    public MainApp() {
        // Add some sample data
        personData.add(new Person("Hans", "Muster"));
        personData.add(new Person("Ruth", "Mueller"));
        personData.add(new Person("Heinz", "Kurz"));
        personData.add(new Person("Cornelia", "Meier"));
        personData.add(new Person("Werner", "Meyer"));
        personData.add(new Person("Lydia", "Kunz"));
        personData.add(new Person("Anna", "Best"));
        personData.add(new Person("Stefan", "Meier"));
        personData.add(new Person("Martin", "Mueller"));
    }
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Address App");
		
		initRootLayout();
		
		showPersonOverview();
	}
	

	/**
	 * Initializes the root layout
	 */
	private void initRootLayout() {
		try {
			// Loading the root layout from the fxml file
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();
			
			// Showing the scene containing the root layout
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Shows the person overview inside the root layout
	 */
	private void showPersonOverview() {
		try {
			// Loading the person overview
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/PersonOverview.fxml"));
			AnchorPane personOverview = (AnchorPane) loader.load();
			
			// Setting person overview into the center of the root layout
			rootLayout.setCenter(personOverview);
			
	        // Give the controller access to the main app.
	        PersonOverviewController controller = loader.getController();
	        controller.setMainApp(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ObservableList<Person> getPersonData() {
        return personData;
    }
	
	public static void main(String[] args) {
		launch(args);
	}
}

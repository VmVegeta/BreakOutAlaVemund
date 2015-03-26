import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
    	Level level = new Level();
        primaryStage.setScene(new Scene(level, 800, 600, Color.BLACK));
        primaryStage.setTitle("BreakOut");
        primaryStage.setResizable(false);
        primaryStage.show();
        level.requestFocus();
    }
	public static void main(String[] args) {
		launch(args);
	}
}
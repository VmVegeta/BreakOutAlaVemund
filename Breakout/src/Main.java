import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
    	Level level = new Level();
    	level.setOnKeyPressed(e -> { 
    	if(e.getCode() == KeyCode.RIGHT) {
            level.racket.moveRacket(4);;
        }
        else if(e.getCode() == KeyCode.LEFT){
            level.racket.moveRacket(-4);
        }});
        primaryStage.setScene(new Scene(level, 800, 600));
        primaryStage.setTitle("Break Out");
        primaryStage.setResizable(false);
        primaryStage.show();
        
        level.requestFocus();
    }
	public static void main(String[] args) {
		launch(args);

	}



}

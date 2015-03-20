import java.util.ArrayList;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;


public class Level extends Pane {
	
	ArrayList<Brick> bricks = new ArrayList<Brick>(150);
	Rectangle rec = new Rectangle(100,100, 20, 20);
	Ball ball = new Ball();
	Racket racket = new Racket();
	private Timeline animation;
	
	public Level (){
		getChildren().add(racket);
		getChildren().add(ball);
		
		run();
	}
	
	public void run() {
		animation = new Timeline(new KeyFrame(Duration.millis(50), e -> ball.moveBall()));
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.play();
	}

	public void setStage(){
		for(int i = 0; i <= 10; i++){
			for(int j = 0; j <= 15; j++){
				bricks.add(new Brick(100+j*52,100+i*27));
			}
		}
	}
	public void level1(){
		
	}
	public void draw(){
		for(int i = 0; i < bricks.size(); i++)
		if(bricks.get(i).isDestroyed() == false){
			
		}
	}

}

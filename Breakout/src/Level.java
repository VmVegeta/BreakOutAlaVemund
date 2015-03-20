import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class Level extends Pane{
	
	ArrayList<Brick> bricks = new ArrayList<Brick>(150);
	Rectangle rec = new Rectangle(100,100, 20, 20);
	Ball ball = new Ball();
	Racket racket = new Racket();
	
	public Level (){
		getChildren().add(racket);
		getChildren().add(ball);
		setLevel1();
		inintTimeline();
		this.requestFocus();
	}
	
	private void inintTimeline(){
		AnimationTimer timer = new AnimationTimer(){

			@Override
			public void handle(long now) {
				ball.moveBall();
				keyPressed();
				
			}

			
		};
		timer.start();
	}

	public void setLevel1(){
		int k = 0;
		for(int i = 0; i <= 10; i++){
			for(int j = 0; j <= 15; j++){
				bricks.add(new Brick(100+j*52,100+i*27));
				k++;
			}
		}
		
	}
	private void keyPressed() {
		this.setOnKeyPressed(e -> {
            if(e.getCode() == KeyCode.RIGHT) {
                racket.moveRacket(2);;
            }
            else if(e.getCode() == KeyCode.LEFT){
                racket.moveRacket(-2);
            }
        });
		
	}
	
	public void draw(){
		for(int i = 0; i < bricks.size(); i++)
		if(bricks.get(i).isDestroyed() == false){
			
		}
	}

}

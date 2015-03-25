import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class Level extends Pane{
	
	ArrayList<Brick> bricks = new ArrayList<Brick>();
	Rectangle rec = new Rectangle(100,100, 20, 20);
	Ball ball = new Ball();
	Racket racket = new Racket();
	public int wishToMoveRacket = 0;
	
	public Level (){
		setLevel1();
		getChildren().add(racket);
		getChildren().add(ball);
		for(Brick brick: bricks){
			getChildren().add(brick);
		}
		inintTimeline();
	}
	
	private void inintTimeline(){
		AnimationTimer timer = new AnimationTimer(){

			@Override
			public void handle(long now) {
				ball.moveBall();
				keyPressed();
				if(wishToMoveRacket == 1){
					racket.moveRacket(5);
				}
				if(wishToMoveRacket == -1){
					racket.moveRacket(-5);
				}
				checkCollisionWithRacket();
				checkCollisionWithBrick();
				
			}

			
		};
		timer.start();
	}

	public void setLevel1(){
		int k = 0;
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 15; j++){
				bricks.add(new Brick(100 + j * 52, 100 + i * 27));
			}
		}
		
	}
	private void keyPressed() {
		this.setOnKeyPressed(e -> {
            if(e.getCode() == KeyCode.RIGHT) {
                wishToMoveRacket = 1;
            }
            else if(e.getCode() == KeyCode.LEFT){
                wishToMoveRacket = -1;
            }
        this.setOnKeyReleased(k -> {
        	wishToMoveRacket = 0;
        });
        });
		
	}
	
	public void draw(){
		for(int i = 0; i < bricks.size(); i++){
		if(bricks.get(i).isDestroyed() == false){
			getChildren().add(bricks.get(i));
		}else{
			bricks.remove(i);
		}
		}
	}
	private void checkCollisionWithRacket() {
		if(ball.getBottom() <= (racket.getPosY()+1) && ball.getBottom() >= (racket.getPosY()-2)  
				&& ball.getX() >= racket.getPosX() && ball.getX() <= (racket.getPosX()+racket.getwidth())){
			ball.switchDirection();
		}
		
	}
	private void checkCollisionWithBrick(){
		for(int i = 0; i < bricks.size(); i++){
			if(ball.getX() >= bricks.get(i).getbrickX() && ball.getX() <= (bricks.get(i).getbrickX() + 50)
					&& ball.getTop() <= bricks.get(i).getbrickY() && ball.getTop() >= (bricks.get(i).getbrickY() -3)){
				bricks.get(i).setDestroyed(true);
				ball.switchDirection();
			}
		}
	}

}

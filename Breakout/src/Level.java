import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Level extends Pane{

	ArrayList<Brick> bricks = new ArrayList<Brick>();
	Racket racket = new Racket();
	Ball ball = new Ball(racket.getPosX(), racket.getPosY());
	TextField timeFrame = new TextField();
	TextField numberOfBallsLeft = new TextField();
	Label intel = new Label("press space to start");
	private int wishToMoveRacket = 0;
	private int ballsLeft = 3;
	private double time;
	private int levelCounter = 0;
	private AnimationTimer timer;

	public Level (){
		showLevel();
		inintTimeline();
		spacePressed();
	}

	private void inintTimeline(){
		timer = new AnimationTimer(){

			@Override
			public void handle(long now) {
				ball.moveBall();
				keyPressed();
				if(wishToMoveRacket == 1){
					racket.moveRacket(8);
				}
				if(wishToMoveRacket == -1){
					racket.moveRacket(-8);
				}
				checkCollision();
				timeFrame.setText(Double.toString(elapsedTime()));
				numberOfBallsLeft.setText("number of balls left: " + ballsLeft);
			}
		};
	}

	private void showLevel() {
		setLevel1();
		showIntel();
		showElapsedTime();
		showBallsLeft();
		getChildren().add(racket);
		getChildren().add(ball);
		getChildren().add(timeFrame);
		getChildren().add(numberOfBallsLeft);
		getChildren().add(intel);
	}

	private void setLevel1(){
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 15; j++){
				bricks.add(new Brick(50 + j * 47, 60 + i * 22));
			}
		}
		for(Brick brick: bricks){
			if(brick.isDestroyed() == false){
				getChildren().add(brick);
			}
		}
	}

	private void setLevel2(){
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 15; j++){
				bricks.add(new BrickLevel2(50 + j * 47, 60 + i * 22));
			}
		}
		for(Brick brick: bricks){
			if(brick.isDestroyed() == false){
				getChildren().add(brick);
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
	
	private void spacePressed(){
		this.setOnKeyPressed(e -> {
			if(e.getCode() == KeyCode.SPACE) {
				timer.start();
				start();
				spacePressed();
				getChildren().remove(intel);
			}
		});
	}

	private void checkCollisionWithRacket() {
		if(ball.getBottom() <= (racket.getPosY()+1) && ball.getBottom() >= (racket.getPosY()-2)  
				&& ball.getX() + 3 >= racket.getPosX() && ball.getX() -3 <= (racket.getPosX()+racket.getwidth())){
			ball.switchDirectionY();
			ball.setSpeed(wishToMoveRacket);
		}
	}
	
	private void checkCollisionWithBrick(){
		for(int i = 0; i < bricks.size(); i++){
			if(bricks.get(i).isDestroyed() == true){
				getChildren().remove(bricks.get(i));
				bricks.remove(i);
			}
		}
		for(int i = 0; i < bricks.size(); i++){
			if((ball.getX() + 6) >= bricks.get(i).getTranslateX() && (ball.getX() -6) <= (bricks.get(i).getTranslateX() + bricks.get(i).getWidth())
					&& ball.getTop() <= (bricks.get(i).getTranslateY() + bricks.get(i).getHeight() +1) 
					&& ball.getTop() >= (bricks.get(i).getTranslateY() + bricks.get(i).getHeight() - 3)){

				bricks.get(i).setDestroyed(true);
				ball.setBallDirectionY(3);

			}else if((ball.getX() + 6) >= bricks.get(i).getTranslateX() && (ball.getX() - 6) <= (bricks.get(i).getTranslateX() + bricks.get(i).getWidth())
					&& ball.getBottom() <= (bricks.get(i).getTranslateY() +1) && ball.getBottom() >= (bricks.get(i).getTranslateY() - 3)){

				bricks.get(i).setDestroyed(true);
				ball.setBallDirectionY(-3);

			}else if((ball.getY() + 6) >= bricks.get(i).getTranslateY() && (ball.getY() - 6) <= (bricks.get(i).getTranslateY() + bricks.get(i).getHeight())
					&& ball.getRigth() <= (bricks.get(i).getTranslateX() + 1) && ball.getRigth() >= (bricks.get(i).getTranslateX() - 3)){

				bricks.get(i).setDestroyed(true);
				ball.setBallDirectionX(-3);

			}else if((ball.getY() + 6) >= bricks.get(i).getTranslateY() && (ball.getY() - 6) <= (bricks.get(i).getTranslateY() + bricks.get(i).getHeight())
					&& ball.getLeft() <= (bricks.get(i).getTranslateX() + bricks.get(i).getWidth() + 1)
					&& ball.getLeft() >= (bricks.get(i).getTranslateX() + bricks.get(i).getWidth() - 3)){

				bricks.get(i).setDestroyed(true);
				ball.setBallDirectionX(3);
			}	
		}
	}

	private void checkCollision(){
		if (ball.getY() > 600){
			ballsLeft--;
			if(ballsLeft == 0){
				Label lost = new Label("U r a loser!!");
				lost.setLayoutX(280);
				lost.setLayoutY(150);
				lost.setUnderline(true);
				lost.setWrapText(true);
				lost.setTextFill(Color.DARKORANGE);
				lost.setStyle("-fx-font-size:70;");
				getChildren().add(stop());
				getChildren().remove(ball);
				getChildren().remove(racket);
				getChildren().add(lost);
				timer.stop();
			}else{
				ball.setX(racket.getPosX() + 45);
				ball.setY(racket.getPosY() - 10);
			}
		}
		if (bricks.size() == 0){
			if(levelCounter++ == 3){
				Label victory = new Label("Victory!!!");
				victory.setLayoutX(280);
				victory.setLayoutY(150);
				victory.setUnderline(true);
				victory.setWrapText(true);
				victory.setTextFill(Color.DARKORANGE);
				victory.setStyle("-fx-font-size:70;");
				getChildren().add(stop());
				getChildren().remove(ball);
				getChildren().remove(racket);
				getChildren().add(victory);
				timer.stop();
			}else if(levelCounter == 1){
				setLevel2();
				ball.setX(racket.getPosX() + 45);
				ball.setY(racket.getPosY() - 10);
			}else if(levelCounter == 2){
				setLevel3();
				ball.setX(racket.getPosX() + 45);
				ball.setY(racket.getPosY() - 10);
			}

		}
		if (ball.getY() < 300){
			checkCollisionWithBrick();
		}else if (ball.getY() > 540){
			checkCollisionWithRacket();
		}
	}

	private void setLevel3() {
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 15; j++){
				bricks.add(new BrickLevel3(50 + j * 47, 60 + i * 22));
			}
		}
		for(Brick brick: bricks){
			if(brick.isDestroyed() == false){
				getChildren().add(brick);
			}
		}
	}

	private  void showElapsedTime() {
		timeFrame.setLayoutY(570);
		timeFrame.setLayoutX(10);
	}

	public void start() {
		time = System.currentTimeMillis();
	}

	public TextField stop(){
		double timeSpent = elapsedTime();
		TextField timeScore = new TextField("Time spendt: " + Double.toString(timeSpent));
		timeScore.setLayoutX(10);
		timeScore.setLayoutY(570);
		return timeScore;
	}

	public double elapsedTime(){
		long now= System.currentTimeMillis();
		return (now - time) / 1000.0;
	}

	private void showBallsLeft() {
		int x = 610;
		int y = 570;
		numberOfBallsLeft.setLayoutX(x);
		numberOfBallsLeft.setLayoutY(y);
	}

	private void showIntel() {
		intel.setLayoutX(350);
		intel.setLayoutY(500);
		intel.setStyle("-fx-font-size:20;");
	}
}
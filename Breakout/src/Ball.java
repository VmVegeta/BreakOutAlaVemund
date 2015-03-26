import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class Ball extends Circle{
	private int radius = 7;
	private int x = 300;
	private int y = 300;
	private double ballDirectionX = 3;
	private double ballDirectionY = -3; 

	
	public Ball(int x, int y){
		this.x = x + 45;
		this.y = y - radius;
		this.setCenterX(x + 45);
		this.setCenterY(y - radius);
		this.setRadius(radius);
		this.setFill(Color.RED);
	}

	public void moveBall() {
		if (x <= radius){
			switchDirectionX();;
		}
		if(x >= 810 - radius){
			switchDirectionX();
		}
		if(y <= 0){
			switchDirectionY();
		}
		x += ballDirectionX;
		y += ballDirectionY;
		this.setCenterX(x);
		this.setCenterY(y);
	}

	public void setBallDirectionX(int ballDirectionX) {
		this.ballDirectionX = ballDirectionX;
	}

	public void setBallDirectionY(int ballDirectionY) {
		this.ballDirectionY = ballDirectionY;
	}

	public void switchDirectionY() {
		this.ballDirectionY *= -1;
	}
	public void switchDirectionX(){
		this.ballDirectionX *= -1;
	}

	public int getRigth(){
		return x+radius;
	}

	public int getLeft(){
		return x-radius;
	}

	public int getTop(){
		return y-radius;
	}

	public int getBottom(){
		return y+radius;
	}

	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setSpeed(int speed){
		ballDirectionX += speed;
	}
}
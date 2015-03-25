import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class Ball extends Pane{
	private int radius = 7;
	private int x = 300;
	private int y = 300;
	private double ballDirectionX = 3;
	private double ballDirectionY = -3; 
	
	Circle circle = new Circle(x, y, radius, Color.RED);
	
	
	public Ball(){
		getChildren().add(circle);
	}

	public void moveBall() {
		if (x <= radius){
			setBallDirectionX(3);
		}
		if(x >= 810 - radius){
			setBallDirectionX(-3);
		}
		if(y <= 0){
			setBallDirectionY(3);
		}
		x += ballDirectionX;
		y += ballDirectionY;
		circle.setCenterX(x);
		circle.setCenterY(y);
		
	}

	public void setBallDirectionX(int ballDirectionX) {
		this.ballDirectionX = ballDirectionX;
	}

	public void setBallDirectionY(int ballDirectionY) {
		this.ballDirectionY = ballDirectionY;
	}

	public void switchDirection() {
		this.ballDirectionY *= -1;
		
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

}

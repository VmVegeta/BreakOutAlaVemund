import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class Ball extends Pane{
	private double radius = 7;
	private double x = 300;
	private double y = 300;
	private double ballDirectionX = 3;
	private double ballDirectionY = -3;
	
	Circle circle = new Circle(x, y, radius, Color.RED);
	
	public Ball(){
		getChildren().add(circle);
	}

	public void moveBall() {
		if (x == radius){
			setBallDirectionX(3);
		}
		if(x >= 810 - radius){
			setBallDirectionX(-3);
		}
		if(y == 0){
			setBallDirectionY(3);
		}
		x += ballDirectionX;
		y += ballDirectionY;
		circle.setCenterX(x);
		circle.setCenterY(y);
		
	}

	public void setBallDirectionX(double ballDirectionX) {
		this.ballDirectionX = ballDirectionX;
	}

	public void setBallDirectionY(double ballDirectionY) {
		this.ballDirectionY = ballDirectionY;
	}

	public void switchDirection() {
		this.ballDirectionY *= -1;
		
	}

}

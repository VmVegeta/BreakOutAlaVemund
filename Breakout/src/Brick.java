import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Brick extends Pane{
	private int brickX;
	private int brickY;
	private boolean destroyed;
	Rectangle rectangle = new Rectangle(brickX, brickY, 50, 25);
	
	Brick(int x, int y){
		this.brickX = x;
		this.brickY = y;
		getChildren().add(rectangle);
		rectangle.setFill(Color.BLUE);
		
		int random = (int) Math.random()*5;
		
		if(random == 0){
			destroyed = true;
		}
	}
	public void drawBrick(){
		if (destroyed == false){
			getChildren().add(rectangle);
			rectangle.setFill(Color.BLUE);
		}
	}
	

	public int getbrickX() {
		return brickX;
	}

	public int getbrickY() {
		return brickY;
	}

	public boolean isDestroyed() {
		return destroyed;
	}

	public void setDestroyed(boolean destroyed) {
		this.destroyed = destroyed;
	}
	

}

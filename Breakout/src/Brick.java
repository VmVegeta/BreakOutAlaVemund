import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class Brick extends Pane{
	private int brickX;
	private int brickY;
	private boolean destroyed;
	Rectangle rectangle = new Rectangle(brickX, brickY, 50, 25);
	
	Brick(int x, int y){
		this.brickX = x;
		this.brickY = y;
		
		int random = (int) Math.random()*5;
		
		if(random == 0){
			destroyed = true;
		}
		getChildren().add(rectangle);
	}
	
//	public drawBrick(){
//		getChildren().add(rectangle);
//	}

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

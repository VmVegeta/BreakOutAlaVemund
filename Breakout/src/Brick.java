import javafx.scene.shape.Rectangle;

public class Brick {
	private int brickX;
	private int brickY;
	private boolean destroyed;
	
	Brick(int x, int y){
		this.brickX = x;
		this.brickY = y;
		
		Rectangle rectangle = new Rectangle(x, y, 50, 25);
		
		int random = (int) Math.random()*5;
		
		if(random == 0){
			destroyed = true;
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

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Brick extends Rectangle{
	
	private boolean destroyed;
	
	Brick(int x, int y){
		this.setTranslateX(x);
		this.setTranslateY(y);
		this.setHeight(25);
		this.setWidth(50);
		this.setFill(Color.BLUE);
		
		int random = (int) Math.random()*5;
		
		if(random == 0){
			destroyed = true;
		}
	}

	public boolean isDestroyed() {
		return destroyed;
	}

	public void setDestroyed(boolean destroyed) {
		this.destroyed = destroyed;
	}
	

}

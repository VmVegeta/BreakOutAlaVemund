import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Brick extends Rectangle{
	
	private boolean destroyed;
	
	Brick(int x, int y){
		this.setTranslateX(x);
		this.setTranslateY(y);
		this.setHeight(20);
		this.setWidth(45);
		this.setFill(Color.BLUE);
		
		double random = Math.random();
		
		if(random <= 0.2){
			destroyed = true;
		}else{
			destroyed = false;
		}
	}

	public boolean isDestroyed() {
		return destroyed;
	}

	public void setDestroyed(boolean destroyed) {
		this.destroyed = destroyed;
	}
	

}

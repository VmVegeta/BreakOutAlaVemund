import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Brick extends Rectangle{

	protected boolean destroyed;

	Brick(int x, int y){
		this.setTranslateX(x);
		this.setTranslateY(y);
		this.setHeight(20);
		this.setWidth(45);
		switch(y){
		case 60:
		case 82: this.setFill(Color.PINK);
		break;
		case 104:
		case 126:
		case 148: this.setFill(Color.LIGHTGREEN);
		break;
		case 170:
		case 192: this.setFill(Color.YELLOW);
		break;
		case 214:
		case 236:
		case 258: this.setFill(Color.AQUA);
		}
		

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
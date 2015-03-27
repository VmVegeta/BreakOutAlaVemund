import javafx.scene.paint.Color;


public class BrickLevel2 extends Brick{
	protected boolean takeTwoHits;
	protected int y;

	BrickLevel2(int x, int y) {
		super(x, y);
		this.y = y;
		double random = Math.random();
		if (random <= 0.3){
			this.takeTwoHits = true;
			switch(y){
			case 60:
			case 82: this.setFill(Color.CRIMSON);
			break;
			case 104:
			case 126:
			case 148: this.setFill(Color.DARKGREEN);
			break;
			case 170:
			case 192: this.setFill(Color.DARKGOLDENROD);
			break;
			case 214:
			case 236:
			case 258: this.setFill(Color.BLUE);
			}
		}
	}
	
	@Override
	public void setDestroyed(boolean destroyed) {
		if (takeTwoHits == true){
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
			takeTwoHits = false;
		}else{
			this.destroyed = destroyed;
		}
	}
}
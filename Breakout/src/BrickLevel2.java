import javafx.scene.paint.Color;


public class BrickLevel2 extends Brick{
	private boolean takeTwoHits;

	BrickLevel2(int x, int y) {
		super(x, y);
		double random = Math.random();
		if (random >= 0.2){
			takeTwoHits = true;
			this.setFill(Color.YELLOWGREEN);
		}
		
	}
	@Override
	public void setDestroyed(boolean destroyed) {
		if (takeTwoHits == true){
			this.setFill(Color.BLUE);
			takeTwoHits = false;
		}else{
			this.destroyed = destroyed;
		}
	}
	

}

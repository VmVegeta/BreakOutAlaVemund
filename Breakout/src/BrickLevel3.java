import javafx.scene.paint.Color;


public class BrickLevel3 extends Brick{
	private boolean takeThreeHits;
	private boolean takeTwoHits;

	BrickLevel3(int x, int y) {
		super(x, y);
		double random = Math.random();
		if (random <= 0.1){
			takeThreeHits = true;
			takeTwoHits = true;
			this.setFill(Color.CRIMSON);
		}else if(random >= 0.8){
			takeTwoHits = true;
			this.setFill(Color.GREENYELLOW);
		}
	}
	
	@Override
	public void setDestroyed(boolean destroyed) {
		if (takeThreeHits == true){
			this.setFill(Color.GREENYELLOW);
			takeThreeHits = false;
		}else if(takeTwoHits == true){
			this.setFill(Color.BLUE);
			takeTwoHits = false;
		}else{
			this.destroyed = destroyed;
		}
	}
}
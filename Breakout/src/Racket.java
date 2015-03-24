import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class Racket extends Pane{
	private int posX = 400;
	private int posY = 550;
	Rectangle rec = new Rectangle(posX, posY, 90, 10);
	
	public Racket() {
		rec.setArcHeight(5);
		rec.setArcWidth(5);
		rec.setFill(Color.BLACK);
		getChildren().add(rec);
	}
	public void moveRacket(int direction){
		posX += direction;
		rec.setX(posX);
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}
	

}

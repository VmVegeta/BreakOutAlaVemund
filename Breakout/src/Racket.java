import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class Racket extends Pane{
	private int posX = 400;
	private int posY = 550;
	private int width = 90;
	private int heigth = 10;
	Rectangle rec = new Rectangle(posX, posY, width, heigth);

	public Racket() {
		rec.setArcHeight(5);
		rec.setArcWidth(5);
		rec.setFill(Color.DARKORANGE);
		getChildren().add(rec);
	}
	
	public void moveRacket(int direction){
		posX += direction;
		if(posX <= 0){
			posX = 0;
		}else if(posX >= 810-90){
			posX = 810-90;
		}
		rec.setX(posX);
	}
	
	public int getwidth(){
		return width;
	}
	
	public int getheigth(){
		return heigth;
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

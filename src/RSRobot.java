import java.awt.AWTException;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;

public class RSRobot {
	Robot _rsBot;
	int _dropX, _dropY, _dropTimes;
	Point _dropPoint;
	public RSRobot() throws AWTException {
		_dropX = 1744;
		_dropY = 736;
		_dropTimes = 1;
		_dropPoint = new Point(_dropX, _dropY);

		_rsBot = new Robot();
	}
	public Color getColor(Point point){
		point = this.getCurrentPos();
		return 	_rsBot.getPixelColor((int)point.getX(), (int)point.getY());
	}
	public Point getCurrentPos(){
		return MouseInfo.getPointerInfo().getLocation();
	}
	public void mouseLeftClick(){
		_rsBot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		_rsBot.delay((int)(90 + 20*Math.random()));
		_rsBot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	}
	public void mouseRightClick(){
		_rsBot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
		_rsBot.delay((int)(90 + 20*Math.random()));
		_rsBot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
	}
	public void mouseMove(Point point){
		double x = point.getX();
		double y = point.getY();
		Rectangle rectangle = new Rectangle((int)x, (int)y, 5, 5);

	}
	public void getMouseLoc(){
		System.out.println(this.getCurrentPos());
	}
	public void dropItems(){
		//drop for willow logs will need to check the point color for other items
		//right clicks the second item in your inventory to check if the color next to drop is the color it is looking for
		//if it is moves to drop left clicks to drop the item
		//continues through the entire inventory
		this.mouseMove(_dropPoint);
		this.mouseRightClick();
		_dropPoint = new Point(_dropX,_dropY+54);
		if(this.getColor(_dropPoint) == new Color(255,144, 64)){
			this.mouseLeftClick();
			_dropTimes++;
			if(_dropTimes < 5){
				_dropPoint = new Point(_dropX+48, _dropY-54);
				this.mouseMove(_dropPoint);
			} else {
				_dropTimes = 0;
				//1696
				_dropPoint = new Point(_dropX-144, _dropY+44);
				this.mouseMove(_dropPoint);
			}
			dropItems();
		}
	}

}

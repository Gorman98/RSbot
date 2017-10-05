import java.awt.AWTException;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.InputEvent;

public class RSRobot {
	Robot _rsBot;
	public RSRobot() throws AWTException {
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
	public void mouseMove(Rectangle rectangle){
		
	}
	public void getMouseLoc(){
		System.out.println(this.getCurrentPos());
	}
}

import java.awt.AWTException;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;

public class RSRobot extends Robot{
	Rectangle[][] inventoryCoordinates;
	public RSRobot() throws AWTException {

	}

	/**
	 * Gives the pixel color of the specified point.
	 *
	 * @param point pixel location
	 * @return color at the pixel location
	 */
	public Color getColor(Point point) {
		return getPixelColor(point.x, point.y);
	}

	/**
	 * Returns the current position of the mouse on the screen.
	 *
	 * @return current mouse location
	 */
	public Point mouseLoc() {
		return MouseInfo.getPointerInfo().getLocation();
	}

	/**
	 * Simulates a left click with a downpress of 90-110 ms.
	 */
	public void leftClick() {
		mousePress(InputEvent.BUTTON1_DOWN_MASK);
		delay((int)(90 + 20 * Math.random()));
		mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
	}

	/**
	 * Simulates a right click with a downpress of 90-110 ms.
	 */
	public void rightClick() {
		mousePress(InputEvent.BUTTON3_DOWN_MASK);
		delay((int)(90 + 20 * Math.random()));
		mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
	}

	/**
	 * Moves the mouse from its current position to a random location in the target rectangle. This is performed along a bezier curve in time steps to prevent macro detection.
	 *
	 * @param rect the target rectangle
	 */
	public void moveMouseTo(Rectangle rect) {

	}

	/**
	 * Selects the menu option at index number where the first option index is 0.
	 *
	 * @param number index of the menu option to be selected
	 */
	public void menuOption(int number) {

	}

	/**
	 * Drops items from specified inventory slot(s).
	 *
	 * @param point contains the inventory slot coordinates of the item to be dropped. (0, 0) is the top left slot.
	 */
	public void dropItems(Point[] slot) {
		//drop for willow logs will need to check the point color for other items
		//right clicks the second item in your inventory to check if the color next to drop is the color it is looking for
		//if it is moves to drop left clicks to drop the item
		//continues through the entire inventory
		/*@author Ryan I'm leaving this in for now, but it will need to be re-implemented using specified inventory array coordinates and the menuOption method.
		moveMouseTo(_dropPoint);
		rightClick();
		_dropPoint = new Point(_dropX,_dropY+54);
		if(getColor(_dropPoint) == new Color(255,144, 64)){
			leftClick();
			_dropTimes++;
			if(_dropTimes < 5) {
				_dropPoint = new Point(_dropX+48, _dropY-54);
				moveMouseTo(_dropPoint);
			}
			else {
				_dropTimes = 0;
				//1696
				_dropPoint = new Point(_dropX-144, _dropY+44);
				this.mouseMove(_dropPoint);
			}
			dropItems();
		}*/
	}
}

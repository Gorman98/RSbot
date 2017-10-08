import java.awt.AWTException;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.KeyEvent;
import java.awt.GraphicsEnvironment;
import java.awt.GraphicsDevice;

public class RSRobot extends Robot{
	Rectangle[][] inventoryCoordinates;
	Rectangle[][] moveCoordinates;
	Rectangle resolution;
	public RSRobot() throws AWTException {
    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice[] screen = ge.getScreenDevices();
    resolution = screen[0].getDefaultConfiguration().getBounds();
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
	 * Allows Robot's mouseMove to accept a Point object
	 *
	 * @param point screen coordinates
	 */
	public void mouseMove(Point point) {
		mouseMove(point.x, point.y);
	}

	/**
	 * Moves the mouse from its current position to a random location in the target rectangle. This is performed along a bezier curve in time steps to prevent macro detection.
	 *
	 * @param rect the target rectangle
	 */
	public void mouseMove(Rectangle rect) {
    Point start = mouseLoc();
		Point end = new Point((int)(rect.x + rect.width * Math.random()), (int)(rect.y + rect.height * Math.random()));
		Point mid = new Point((int)(0.6 * start.x + 0.4 * end.x + (end.x - start.x) / 2 * Math.random()), (int)(0.6 * start.x + 0.4 * end.x + (end.x - start.x) / 2 * Math.random()));
		Point current = new Point(start);

    for (double t = 0; t <= 1; t += 0.05) {
			delay((int)(45 + 10 * Math.random()));
			current.x = (int)((1 - t) * (1 - t) * start.x + 2 * (1 - t) * t * mid.x + t * t * end.x);
			current.y = (int)((1 - t) * (1 - t) * start.y + 2 * (1 - t) * t * mid.y + t * t * end.y);
			mouseMove(current);
		}
	}

	/**
	 * Simulates typing a character with a downpress of 90-110 ms. Input must be a lower-case character.
	 *
	 * @param input the key to be pressed
	 */
	public void keyType(char input) throws Exception {
		int mask;
		switch(input) {
			case 'a': mask = KeyEvent.VK_A;
			        break;
			case 'b': mask = KeyEvent.VK_B;
							break;
			case 'c': mask = KeyEvent.VK_C;
							break;
			case 'd': mask = KeyEvent.VK_D;
							break;
			case 'e': mask = KeyEvent.VK_E;
							break;
			case 'f': mask = KeyEvent.VK_F;
							break;
			case 'g': mask = KeyEvent.VK_G;
							break;
			case 'h': mask = KeyEvent.VK_H;
							break;
			case 'i': mask = KeyEvent.VK_I;
							break;
			case 'j': mask = KeyEvent.VK_J;
							break;
			case 'k': mask = KeyEvent.VK_K;
							break;
			case 'l': mask = KeyEvent.VK_L;
							break;
			case 'm': mask = KeyEvent.VK_M;
			   			break;
			case 'n': mask = KeyEvent.VK_N;
							break;
			case 'o': mask = KeyEvent.VK_O;
							break;
			case 'p': mask = KeyEvent.VK_P;
							break;
			case 'q': mask = KeyEvent.VK_Q;
							break;
			case 'r': mask = KeyEvent.VK_R;
							break;
			case 's': mask = KeyEvent.VK_S;
							break;
			case 't': mask = KeyEvent.VK_T;
							break;
			case 'u': mask = KeyEvent.VK_U;
							break;
			case 'v': mask = KeyEvent.VK_V;
							break;
			case 'w': mask = KeyEvent.VK_W;
							break;
			case 'x': mask = KeyEvent.VK_X;
							break;
			case 'y': mask = KeyEvent.VK_Y;
							break;
			case 'z': mask = KeyEvent.VK_Z;
							break;
			default: throw(new Exception("INVALID_INPUT"));
		}
		keyPress(mask);
		delay((int)(90 + 20 * Math.random()));
		keyRelease(mask);
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
		/*@authoer Kyle drop for willow logs will need to check the point color for other items
		right clicks the second item in your inventory to check if the color next to drop is the color it is looking for
		if it is moves to drop left clicks to drop the item
		continues through the entire inventory
		*/
		/*@author Ryan I'm leaving this in for now, but it will need to be re-implemented using specified 
		 * inventory array coordinates and the menuOption method.
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
	public Color getPixelColor(){
		return(getPixelColor((int)this.mouseLoc().getX(), (int)this.mouseLoc().getY()));
	}
}

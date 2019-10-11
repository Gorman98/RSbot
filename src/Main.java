import java.awt.AWTException;
import java.awt.Point;
import java.awt.Color;

public class Main {
	RSRobot _bot;

	public Main() throws AWTException {
		// TODO Auto-generated constructor stub
		_bot = new RSRobot();
		while (true) {
			Point point = _bot.mouseLoc();
			Color color = _bot.getPixelColor();
			System.out.println("Point: " + point);
			System.out.println("Color: " + color);
		}

	}

	public static void main(String[] args) throws AWTException {
		// TODO Auto-generated method stub
		new Main();
	}

}

import java.awt.AWTException;

public class Main {
	RSRobot _bot;
	public Main() throws AWTException {
		// TODO Auto-generated constructor stub
		_bot = new RSRobot();
		while(true){
			_bot.getMouseLoc();
		}


	}
	public static void main(String[] args) throws AWTException {
		// TODO Auto-generated method stub
		new Main();
	}

}

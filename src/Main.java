import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame{
	private static final int WIDTH =800;
	private static final int HEIGHT=600;
	
	public Main () {
		super("State Nickname Trivia Game");
		setSize(WIDTH, HEIGHT);
		
		
		setBackground(Color.BLACK);
		
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	
	}

	public static void main(String[] args) {
		Game game = new Game();

		
	}


}

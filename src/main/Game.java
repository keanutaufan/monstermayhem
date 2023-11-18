package main;

import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Game extends JFrame {
	
	private BufferedImage img;
	
	public Game() {
		importImg();
		setSize(720, 640);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		add(new GameScreen(img));
		setVisible(true);
	}
	
	private void importImg() {
		
		InputStream inputStream = getClass().getResourceAsStream("/images/logo.png");
		
		if (inputStream != null) {
	        try {
	            img = ImageIO.read(inputStream);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    } else {
	        System.err.println("Error loading image. InputStream is null.");
	    }
	}

	public static void main(String[] args) {

		System.out.println("hi mom");
		
		Game game = new Game();
	}

}

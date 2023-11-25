package helpers;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class LoadSave {

	public static BufferedImage getSpriteAtlas() {
		
		BufferedImage img = null;
		InputStream inputStream = LoadSave.class.getClassLoader().getResourceAsStream("spriteatlas.png");
		
		if (inputStream != null) {
	        try {
	            img = ImageIO.read(inputStream);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    } else {
	        System.err.println("Error loading image. InputStream is null.");
	    }
		
		return img;
	}
	
	public static BufferedImage loadImage(String path) {
		BufferedImage img = null;
		InputStream inputStream = LoadSave.class.getClassLoader().getResourceAsStream(path);
		
		if (inputStream != null) {
	        try {
	            img = ImageIO.read(inputStream);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    } else {
	        System.err.println("Error loading image. InputStream is null.");
	    }
		
		return img;
	}
	
}

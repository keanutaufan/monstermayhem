package scenes;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;

import main.Game;

public class Playing extends GameScene implements SceneMethods {

	private BufferedImage img; 
	private ArrayList<BufferedImage> sprites = new ArrayList<>();
	
	public Playing(Game game) {
		super(game);
		importImg();
		loadSprite();
	}

	@Override
	public void render(Graphics g) {
		for (int i = 0; i < 23; i++) {
			for (int j = 0; j < 40; j++) {
				g.drawImage(sprites.get(new Random().nextInt(29)), 32 * j, 32 * i, null);
			}
		}
	}
	
	private void importImg() {
		
		InputStream inputStream = getClass().getResourceAsStream("/images/spriteatlas.png");
		
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
	
	private void loadSprite() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 10; j++) {
				sprites.add(img.getSubimage(32 * j, 32 * i, 32, 32));
			}
		}
	}

}

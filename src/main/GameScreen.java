package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import javax.swing.JPanel;

public class GameScreen extends JPanel {
	
	private BufferedImage img; 
	private ArrayList<BufferedImage> sprites = new ArrayList<>();
	
	public GameScreen(BufferedImage img) {
		this.img = img;
		loadSprite();
	}
	
	private void loadSprite() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 10; j++) {
				sprites.add(img.getSubimage(32 * j, 32 * i, 32, 32));
			}
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				g.drawImage(sprites.get(new Random().nextInt(29)), 32 * j, 32 * i, null);
			}
		}
		
//		g.setColor(Color.BLACK);
//		g.fillRect(0, 0, getWidth(), getHeight());
//		
//		g.drawImage(img, (getWidth() - img.getWidth()) / 2, 0, null);
//		
//		g.setColor(Color.WHITE);
//		g.setFont(new Font("Montserrat", Font.BOLD, 20));
//		String text = "Press Screen";
//		g.drawString(text, (getWidth() - g.getFontMetrics().stringWidth(text)) / 2, (getHeight() + img.getHeight()) / 2 + 20);
	}	
}

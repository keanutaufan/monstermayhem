package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class GameScreen extends JPanel {
	
	private BufferedImage img; 
	
	public GameScreen(BufferedImage img) {
		this.img = img;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		g.drawImage(img, (getWidth() - img.getWidth()) / 2, 0, null);
		
		g.setColor(Color.WHITE);
		g.setFont(new Font("Montserrat", Font.BOLD, 20));
		String text = "Press Screen";
		g.drawString(text, (getWidth() - g.getFontMetrics().stringWidth(text)) / 2, (getHeight() + img.getHeight()) / 2 + 20);
	}
	
}

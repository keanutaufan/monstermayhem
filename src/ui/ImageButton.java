package ui;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class ImageButton {
	private int x, y;
	private Rectangle bounds;
	private boolean hover;
	private boolean pressed;
	
	private BufferedImage normalImage;
	private BufferedImage hoverImage;
	private BufferedImage pressImage;
	
	public ImageButton(int x, int y, BufferedImage normalImage, BufferedImage hoverImage, BufferedImage pressImage) {
		this.x = x;
		this.y = y;
		
		this.normalImage = normalImage;
		this.hoverImage = hoverImage;
		this.pressImage = pressImage;
		
		this.hover = false;
		this.pressed = false;
		
		this.bounds = new Rectangle(x, y, normalImage.getWidth(), normalImage.getHeight());
	}
	
	public void draw(Graphics g) {
		if (pressed) {
			g.drawImage(pressImage, x, y, null);
		} else if (hover) {
			g.drawImage(hoverImage, x, y, null);
		} else {
			g.drawImage(normalImage, x, y, null);
		}
	}
	
	public Rectangle getBounds() {
		return bounds;
	}
	
	public void setHover(boolean hover) {
		this.hover = hover;
	}
	
	public void setPressed(boolean pressed) {
		this.pressed = pressed;
	}
}

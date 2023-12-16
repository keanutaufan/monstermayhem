package ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class ToggleButton extends ImageButton {
	public boolean on;
	
	private BufferedImage onImage;
	private BufferedImage offImage;
	
	public ToggleButton(int x, int y, BufferedImage onImage, BufferedImage offImage) {
		super(x, y, onImage, null, null);
		on = false;
		
		this.onImage = onImage;
		this.offImage = offImage;
	}
	
	@Override
	public void draw(Graphics g) {
		if (on) {
			g.drawImage(onImage, x, y, null);
		} else {
			g.drawImage(offImage, x, y, null);
		}
	}
	
	public void setOn(boolean on) {
		this.on = on;
	}
	
	public boolean isOn() {
		return on;
	}
}

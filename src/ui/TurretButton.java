package ui;

import java.awt.image.BufferedImage;

import turrets.TurretTypes;

public class TurretButton extends ImageButton {
	
	private TurretTypes type;
	
	public TurretButton(int x, int y, BufferedImage normalImage, TurretTypes type) {
		super(x, y, normalImage, normalImage, normalImage);
		this.type = type;
	}
	
	public TurretTypes getType() {
		return type;
	}

}

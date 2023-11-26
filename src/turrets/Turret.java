package turrets;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Turret {
	private int x, y;
	private int cost;
	
	private BufferedImage image;
	private Rectangle bounds;
	private TurretTypes turretType;
	
	public Turret(int x, int y, TurretTypes turretType, int cost, BufferedImage image) {
		this.x = x;
		this.y = y;
		
		this.turretType = turretType;
		this.cost = cost;
		
		this.image = image;
		this.bounds = new Rectangle(x, y, image.getWidth(), image.getHeight());
	}
	
	public void draw(Graphics g) {
		g.drawImage(image, x, y, image.getWidth(), image.getHeight(), null);
	}
}

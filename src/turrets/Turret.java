package turrets;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import bullets.AlmightyBullet3000;
import bullets.Bullet;
import managers.SpriteManager;

abstract public class Turret {
	static final SpriteManager spriteManager = new SpriteManager();
	
	private int x, y;
	private float dmg, cooldown;
	private int health;
	
	private BufferedImage image;
	private Rectangle bounds;
	private TurretTypes turretType;
	
	private ArrayList<Bullet> bullets;
	
	private long lastShootTime;
	
	public Turret(int x, int y, int initialHealth, TurretTypes turretType, BufferedImage image) {
		this.x = x;
		this.y = y;
		this.health = initialHealth;
		
		this.turretType = turretType;
		
		this.image = image;
		this.bounds = new Rectangle(x, y, image.getWidth(), image.getHeight());
		
		bullets = new ArrayList<>();
		
		setDefaultDmg();
		setDefaultCooldown();
	}
	
	public float getDmg() {
		return dmg;
	}

	public float getCooldown() {
		return cooldown;
	}

	private void setDefaultCooldown() {
		cooldown = helpers.Constants.Turrets.GetDefaultCooldown(turretType);
	}

	private void setDefaultDmg() {
		dmg = helpers.Constants.Turrets.GetStartDmg(turretType);
	}

	public void draw(Graphics g) {
		g.drawImage(image, x, y, image.getWidth(), image.getHeight(), null);
	}
	
	public void updateBullets() {
		for (int i = 0; i < bullets.size(); i++) {
			Bullet b = bullets.get(i);
			b.move();
			if (b.getX() >= 1280) {
				bullets.remove(i);
				break;
			}
		}
	}
	
	public void shoot() {
		long currentTime = System.currentTimeMillis();
		
		if (currentTime - lastShootTime >= cooldown) {
			bullets.add(new AlmightyBullet3000(x + 100, y + 30));
			lastShootTime = currentTime;
		}
	}
	
	public void drawBullets(Graphics g) {
		bullets.forEach(b -> b.draw(g));
	}
	
	public void hurt(int damage) {
		health -= damage;
	}
	
	public Rectangle getBounds() {
		return bounds;
	}
	
	public ArrayList<Bullet> getBullets() {
		return bullets;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getHealth() {
		return health;
	}
	
	public void reset() {
		bullets.clear();
	}
	
}

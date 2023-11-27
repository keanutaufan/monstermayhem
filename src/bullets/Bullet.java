package bullets;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import enemies.Enemy;

abstract public class Bullet {
	private double x, y;
	private double speed;
	private int damage;
	
	private BufferedImage image;
	
	public Bullet(double x, double y, BufferedImage image, int speed) {
		this.x = x;
		this.y = y;
		this.image = image;
		
		this.speed = speed;
	}
	
	public void move() {
		this.x += speed;
	}
	
	public boolean hit(Enemy enemy) {
		if (enemy.getBounds().contains(x, y)) {
			return true;
		}
		return false;
	}
	
	public void draw(Graphics g) {
		g.drawImage(image, (int)x, (int)y, null);
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}
	
	public double getSpeed() {
		return speed;
	}

	public int getDamage() {
		return damage;
	}
}

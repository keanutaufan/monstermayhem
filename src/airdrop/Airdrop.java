package airdrop;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import helpers.LoadSave;

abstract public class Airdrop {
	static final BufferedImage images = LoadSave.loadImage("airdrops.png");
	
	private double x, y;
	private int value;
	private BufferedImage image;
	private Rectangle bounds;
	private double speed;
	
	public Airdrop(int x, int y, int value, BufferedImage image, double speed) {
		this.x = x;
		this.y = y;
		this.value = value;
		this.image = image;
		this.bounds = new Rectangle(x, y, image.getWidth(), image.getHeight());
		this.speed = speed;
	}
	
	public void move() {
		this.y += speed;
		this.bounds.y += speed;
	}
	
	public void draw(Graphics g) {
		g.drawImage(image, (int)x, (int)y, null);
	}
	
	public int getValue() {
		return value;
	}
	
	public Rectangle getBounds() {
		return bounds;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
}

package managers;

import static helpers.Constants.Enemies.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import enemies.Crusty;
import enemies.Enemy;
import enemies.Gopher;
import helpers.LoadSave;
import scenes.Playing;

public class EnemyManager {

	private Playing playing;
	private BufferedImage[] enemyImgs;
	private ArrayList<Enemy> enemies = new ArrayList<>();
	
	private int HealthBarWidth = 80;
	
	public EnemyManager(Playing playing) {
		this.playing = playing;
		enemyImgs = new BufferedImage[2];
		addEnemy(9, 3, GOPHER);
		addEnemy(10, 4, CRUSTY);
		loadEnemyImgs();
	}
	
	private void addEnemy(int x, int y, int enemyType) {
		switch (enemyType) {
			case GOPHER:
				enemies.add(new Gopher(120 * x, (120 * y) - 45, 0));
				break;
			case CRUSTY:
				enemies.add(new Crusty(120 * x, (120 * y) - 45, 0));
				break;
		}
	}

	private void loadEnemyImgs() {
		BufferedImage atlas= LoadSave.loadImage("enemies.png");
		
		for (int i = 0; i < 2; i++) {
			enemyImgs[i] = atlas.getSubimage(109 * i, 0, 109, 148);
		}
	}

	public void update() {
		for (Enemy e : enemies) {
			if (e.isAlive()) {
				e.move(GetSpeed(e.getEnemyType()), 0);
			}
		}
	}
	
	public void draw(Graphics g) {
		for (Enemy e : enemies) {
			if (e.isAlive()) {
				drawEnemy(e, g);
				drawHealthBar(e, g);
			}
		}
	}

	private void drawHealthBar(Enemy e, Graphics g) {
		g.setColor(Color.RED);
		g.fillRect((int) e.getX() + 10, (int) e.getY() - 10, 80, 5);
		g.setColor(Color.GREEN);
		g.fillRect((int) e.getX() + 10, (int) e.getY() - 10, getNewBarWidth(e), 5);
	}

	private int getNewBarWidth(Enemy e) {
		return (int)(HealthBarWidth * e.getHealthBarFloat());
	}
	
	private void drawEnemy(Enemy enemy, Graphics g) {
		g.drawImage(enemyImgs[enemy.getEnemyType()], (int)enemy.getX(), (int)enemy.getY(), null);
	}
	
	public ArrayList<Enemy> getEnemies() {
		return enemies;
	}
	
}

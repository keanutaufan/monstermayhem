package managers;

import static helpers.Constants.Enemies.*;

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
			e.move(GetSpeed(e.getEnemyType()), 0);
		}
	}
	
	public void draw(Graphics g) {
		for (Enemy e : enemies) {
			drawEnemy(e, g);
		}
	}

	private void drawEnemy(Enemy enemy, Graphics g) {
		g.drawImage(enemyImgs[enemy.getEnemyType()], (int)enemy.getX(), (int)enemy.getY(), null);
	}
	
}

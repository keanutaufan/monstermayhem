package managers;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import enemies.Enemy;
import helpers.LoadSave;
import scenes.Playing;

public class EnemyManager {

	private Playing playing;
	private BufferedImage[] enemyImgs;
	private ArrayList<Enemy> enemies = new ArrayList<>();
	
	public EnemyManager(Playing playing) {
		this.playing = playing;
		enemyImgs = new BufferedImage[4];
		addEnemy(new Random().nextInt(10), new Random().nextInt(20));
		loadEnemyImgs();
	}
	
	private void addEnemy(int x, int y) {
		enemies.add(new Enemy(32 * x, 32 * y, 0, 0));
	}

	private void loadEnemyImgs() {
		BufferedImage atlas= LoadSave.getSpriteAtlas();
		for (int i = 0; i < 4; i++) {
			enemyImgs[i] = atlas.getSubimage(32 * i, 32 * 1, 32, 32);
		}
	}

	public void update() {
		for (Enemy e : enemies) {
			e.move(0.5f, 0);
		}
	}
	
	public void draw(Graphics g) {
		for (Enemy e : enemies) {
			drawEnemy(e, g);
		}
	}

	private void drawEnemy(Enemy enemy, Graphics g) {
		g.drawImage(enemyImgs[1], (int)enemy.getX(), (int)enemy.getY(), null);
	}
	
}

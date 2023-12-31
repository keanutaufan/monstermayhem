package managers;

import static helpers.Constants.Enemies.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import enemies.Crusty;
import enemies.Dash;
import enemies.Duke;
import enemies.Enemy;
import enemies.Gopher;
import helpers.LoadSave;
import helpers.SoundHandler;
import main.GameStates;
import scenes.Playing;
import turrets.Turret;

public class EnemyManager {

	private Playing playing;
	private BufferedImage[] enemyImgs;
	private ArrayList<Enemy> enemies = new ArrayList<>();
	
	private int HealthBarWidth = 80;
	
	private long lastAttackTime;
    private static final long ATTACK_COOLDOWN = 1500;
	
	public EnemyManager(Playing playing) {
		this.playing = playing;
		enemyImgs = new BufferedImage[4];
		
//		addEnemy(9, 3, GOPHER);
//		addEnemy(10, 4, CRUSTY);
//		addEnemy(10, 2, DUKE);
//		addEnemy(10, 4, DASH);
		lastAttackTime = System.currentTimeMillis();
		loadEnemyImgs();
	}
	
	public void addEnemy(int x, int y, int enemyType) {
		switch (enemyType) {
			case GOPHER:
				enemies.add(new Gopher(120 * x, (120 * y) - 45, 0));
				break;
			case CRUSTY:
				enemies.add(new Crusty(120 * x, (120 * y) - 45, 0));
				break;
			case DUKE:
				enemies.add(new Duke(120 * x, (120 * y) - 45, 0));
				break;
			case DASH:
				enemies.add(new Dash(120 * x, (120 * y) - 45, 0));
				break;
		}
	}

	private void loadEnemyImgs() {
		BufferedImage atlas= LoadSave.loadImage("enemies.png");
		
		for (int i = 0; i < 4; i++) {
			enemyImgs[i] = atlas.getSubimage(130 * i, 0, 130, 150);
		}
	}

	public void update() {
		
		for (Enemy e : enemies) {
			if (e.getX() <= 20) {
				e.kill();
				GameStates.gameState = GameStates.GAME_OVER;
			}
			if (e.isAlive()) {
				if (!e.isAttacking()) {
					e.move(GetSpeed(e.getEnemyType()), 0);					
				}
				
				boolean attacking = false;
				
				Turret[][] turrets = playing.getTurretManager().getTurretMap();
				for (int i = 0; i < turrets.length; i++) {
					for (int j = 0; j < turrets[i].length; j++) {
						Turret t = turrets[i][j];
						if (t == null) {
							continue;
						}
						if (t.getX() + t.getBounds().width >= e.getX() &&
							e.getX() >= t.getX() &&
							t.getY() >= e.getY() - 45 && 
							t.getY() <= e.getY() + 45
						) {
							e.setAttacking(true);
							attacking = true;
							
							long currentTime = System.currentTimeMillis();
							if (currentTime - lastAttackTime >= ATTACK_COOLDOWN) {
								SoundHandler.RunSound("assets/turret_attacked_sound.wav");
								e.attack(t);
					            lastAttackTime = currentTime;
					        }
						}
					}
				}
				
				e.setAttacking(attacking);
				
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
		g.fillRect((int) e.getX() + 20, (int) e.getY() - 10, 80, 5);
		g.setColor(Color.GREEN);
		g.fillRect((int) e.getX() + 20, (int) e.getY() - 10, getNewBarWidth(e), 5);
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

	public void reset() {
		enemies.clear();
	}
	
}

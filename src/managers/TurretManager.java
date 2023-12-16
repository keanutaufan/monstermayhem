package managers;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

import bullets.Bullet;
import enemies.Enemy;
import helpers.LoadSave;
import turrets.Turret;
import turrets.TurretTypes;

public class TurretManager {
	private final Color PLANT_AREA_COLOR = new Color(0.0f, 0.0f, 1.0f, 0.2f);
	private final Color REMOVE_AREA_COLOR = new Color(1.0f, 0.0f, 0.0f, 0.2f);
	
	
	private Turret[][] turretMap;
	private Rectangle[][] plantArea;
	
	private SpriteManager spriteManager;
	private ArrayList<Enemy> enemies;
	
	public TurretManager(SpriteManager spriteManager, ArrayList<Enemy> enemies) {
		this.spriteManager = spriteManager;
		this.enemies = enemies;
		
		initTurretMap();
		initPlantArea();
	}
	
	private void initTurretMap() {
		Turret[][] turretMap = {
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
		};
		
		this.turretMap = turretMap;
	}
	
	private void initPlantArea() {
		plantArea = new Rectangle[5][7];
		for (int y = 0; y < plantArea.length; y++) {
			for (int x = 0; x < plantArea[y].length; x++) {
				plantArea[y][x] = new Rectangle((x+1) * 120, (y+1) * 120, 120, 120);
			}
		}
	}
	
	public boolean plantAt(int r, int c, Turret turret) {
		if (turretMap[r][c] != null) {
			return false;
		}
		
		turretMap[r][c] = turret;
		
		return true;
	}
	
	public boolean removeAt(int r, int c) {
		if (turretMap[r][c] == null) {
			return false;
		}
		
		turretMap[r][c] = null;
		return true;
	}
	
	public void draw(Graphics g) {
		for (int i = 0; i < turretMap.length; i++) {
			for (int j = 0; j < turretMap[i].length; j++) {
				if (turretMap[i][j] != null) {
					turretMap[i][j].draw(g);
					turretMap[i][j].drawBullets(g);
				}
			}
		}
	}
	
	public void update() {
		for (int i = 0; i < turretMap.length; i++) {
			for (int j = 0; j < turretMap[i].length; j++) {
				Turret t = turretMap[i][j];
				if (t != null) {
					t.updateBullets();
					if (t.getHealth() <= 0) {
						turretMap[i][j] = null;
					}
					
					boolean turretIsBeingAttacked = false;
					for (Enemy e : enemies) {
						if (e.isAlive() && e.isAttacking()) {
							if (t.getX() + t.getBounds().width >= e.getX() &&
								e.getX() >= t.getX() &&
								t.getY() >= e.getY() - 45 && 
								t.getY() <= e.getY() + 45) {
								turretIsBeingAttacked = true;
								break;
							}
						}
					}
					
					t.setAttacked(turretIsBeingAttacked);
				}
			}
		}
	}
	
	public void drawPlantArea(Graphics g) {
		for (int i = 0; i < plantArea.length; i++) {
			for (int j = 0; j < plantArea[i].length; j++) {
				if (turretMap[i][j] == null) {
					Rectangle rect = plantArea[i][j];
					g.setColor(PLANT_AREA_COLOR);
					g.fillRect(rect.x, rect.y, (int)rect.getWidth(), (int)rect.getHeight());
				}
			}
		}
	}
	
	public void drawRemoveArea(Graphics g) {
		for (int i = 0; i < plantArea.length; i++) {
			for (int j = 0; j < plantArea[i].length; j++) {
				if (turretMap[i][j] != null) {
					Rectangle rect = plantArea[i][j];
					g.setColor(REMOVE_AREA_COLOR);
					g.fillRect(rect.x, rect.y, (int)rect.getWidth(), (int)rect.getHeight());
				}
			}
		}
	}
	
	
	
	public void drawPlaceholder(Graphics g, int x, int y, TurretTypes type) {
		g.drawImage(spriteManager.getSprite(type.getValue()), x - 60, y - 60, null);
	}
	
	public void drawPlaceholder(Graphics g, int x, int y) {
		g.drawImage(spriteManager.getSprite(13), x - 43, y - 50, null);
	}

	public Turret[][] getTurretMap() {
		return turretMap;
	}
	
	public Rectangle[][] getPlantArea() {
		return plantArea;
	}
	
	public void reset() {
		Turret[][] turretMap = {
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null },
		};
		
		this.turretMap = turretMap;
	}
	
}

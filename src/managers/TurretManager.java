package managers;

import java.awt.Graphics;

import turrets.Turret;
import turrets.TurretTypes;

public class TurretManager {
	private Turret[][] turretMap;
	private SpriteManager spriteManager;
	
	public TurretManager(SpriteManager spriteManager) {
		this.spriteManager = spriteManager;
		initTurretMap();
	}
	
	private void initTurretMap() {
		Turret[][] turretMap = {
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null },
				{ null, null, null, null, null },
		};
		
		this.turretMap = turretMap;
	}
	public boolean plantAt(int r, int c, Turret turret) {
		if (turretMap[r][c] == null) {
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
				turretMap[i][j].draw(g);
			}
		}
	}
	
	public void drawPlaceholder(Graphics g, int x, int y, TurretTypes type) {
		g.drawImage(spriteManager.getSprite(type.getValue()), x - 60, y - 60, null);
	}
}

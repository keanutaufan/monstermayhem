package scenes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;

import bullets.Bullet;
import enemies.Enemy;
import main.Game;
import managers.EnemyManager;
import managers.TurretManager;
import turrets.DesertTank;
import turrets.GrayTank;
import turrets.GreenTank;
import turrets.NavyTank;
import turrets.Turret;
import turrets.TurretTypes;
import ui.ImageButton;
import ui.TurretButton;
import managers.SpriteManager;

public class Playing extends GameScene implements SceneMethods {
	
//	private int[][] level;
//	private TileManager tileManager;
	private final Color UI_BG_COLOR = new Color(189, 108, 74);
	
	private EnemyManager enemyManager;
	private SpriteManager spriteManager;
	private ArrayList<TurretButton> buyTurretButtons;
	private ImageButton removeTurretButton;
	
	private int[][] bgLayout;
	private int airdrop;
	
	private boolean plantingMode;
	private boolean removeMode;
	private TurretTypes turretToPlant;
	private TurretManager turretManager;
	private ArrayList<Turret> turrets = new ArrayList<>();
	
	private int placeholderX;
	private int placeholderY;
	
	public Playing(Game game) {
		super(game);
		airdrop = 0;
		plantingMode = false;
		removeMode = false;
//		level = LevelBuilder.getLevelData();
//		tileManager = new TileManager();
		enemyManager = new EnemyManager(this);		
		spriteManager = new SpriteManager();
		turretManager = new TurretManager(spriteManager);
		
		initBGLayout();
		initUIComponents();
		
		
	}
	
	private void initBGLayout() {
		// 1280 x 720, for 120 x 120 tiles
		// maps out to ~11 x 6
		int[][] bgLayout = {
				{ 2, 1, 0, 1, 0, 1, 0, 1, 0, 2, 2 },
				{ 2, 0, 1, 0, 1, 0, 1, 0, 1, 2, 2 },
				{ 2, 1, 0, 1, 0, 1, 0, 1, 0, 2, 2 },
				{ 2, 0, 1, 0, 1, 0, 1, 0, 1, 2, 2 },
				{ 2, 1, 0, 1, 0, 1, 0, 1, 0, 2, 2 },
				{ 2, 0, 1, 0, 1, 0, 1, 0, 1, 2, 2 },
		};
		
		this.bgLayout = bgLayout;
	}
	
	private void initUIComponents() {
		buyTurretButtons = new ArrayList<>();
		final int X_OFFSET = 200;
		
		buyTurretButtons.add(new TurretButton(X_OFFSET + 0 * 87, 0, spriteManager.getSprite( 8), TurretTypes.GREEN_TANK));
		buyTurretButtons.add(new TurretButton(X_OFFSET + 1 * 87, 0, spriteManager.getSprite( 9), TurretTypes.DESERT_TANK));
		buyTurretButtons.add(new TurretButton(X_OFFSET + 2 * 87, 0, spriteManager.getSprite(10), TurretTypes.GRAY_TANK));
		buyTurretButtons.add(new TurretButton(X_OFFSET + 3 * 87, 0, spriteManager.getSprite(11), TurretTypes.NAVY_TANK));
		
		BufferedImage img = spriteManager.getSprite(13);
		removeTurretButton = new ImageButton(X_OFFSET + 4 * 87 + 10, 0, img, img, img);
	}
	
	private void drawUIComponents(Graphics g) {
		g.setColor(UI_BG_COLOR);
		g.fillRect(100, 0, 560, 100);
		buyTurretButtons.forEach(b -> b.draw(g));
		
		g.drawImage(spriteManager.getSprite(12), 110, 0, null);
		
		g.setColor(Color.WHITE);
		g.drawString(airdrop + "", 150, 80);
		
		removeTurretButton.draw(g);
	}

	public void update() {
		enemyManager.update();
		turretManager.update();
		attackEnemyIfRange();
	}

	@Override
	public void render(Graphics g) {
		drawLevel(g);
		enemyManager.draw(g);
		drawUIComponents(g);
		
		turretManager.draw(g);
		
		if (plantingMode) {
			turretManager.drawPlantArea(g);
			turretManager.drawPlaceholder(g, placeholderX, placeholderY, turretToPlant);
		}
		else if (removeMode) {
			turretManager.drawRemoveArea(g);
			turretManager.drawPlaceholder(g, placeholderX, placeholderY);
		}
	}
	
	public void drawLevel(Graphics g) {
//		for (int i = 0; i < level.length; i++) {
//			for (int j = 0; j < level[i].length; j++) {
//				int id = level[i][j];
//				g.drawImage(tileManager.getSprite(id), j * 32, i * 32, null);
//			}
//		}
		
		for (int y = 0; y < bgLayout.length; y++) {
			for (int x = 0; x < bgLayout[y].length; x++) {
				int id = bgLayout[y][x];
				g.drawImage(spriteManager.getSprite(id + 4), x * 120, y * 120, null);				
			}
		}
	}
	
	@Override
	public void handleMouseClick(int x, int y) {
		buyTurretButtons.forEach(b -> {
			if (b.getBounds().contains(x, y)) {
				setPlantingMode(true);
				setRemoveMode(false);
				turretToPlant = b.getType();
			}
		});
		
		if (removeTurretButton.getBounds().contains(x, y)) {
			setRemoveMode(true);
			setPlantingMode(false);
		}
		
		if (plantingMode) {
			Rectangle[][] plantArea = turretManager.getPlantArea();
			for (int r = 0; r < plantArea.length; r++) {
				for (int c = 0; c < plantArea[r].length; c++) {
					Rectangle rect = plantArea[r][c];
					if (rect.contains(x, y)) {
						Turret turret;
						switch (turretToPlant) {
						case GREEN_TANK:
							turret = new GreenTank((int)rect.getX(), (int)rect.getY());
							break;
						case DESERT_TANK:
							turret = new DesertTank((int)rect.getX(), (int)rect.getY());
							break;
						case GRAY_TANK:
							turret = new GrayTank((int)rect.getX(), (int)rect.getY());
							break;
						case NAVY_TANK:
							turret = new NavyTank((int)rect.getX(), (int)rect.getY());
							break;
						default:
							turret = new GreenTank((int)rect.getX(), (int)rect.getY());
							break;
						}
						
						boolean success = turretManager.plantAt(r, c, turret);
						
						if (success) {
							setPlantingMode(false);
							turrets.add(turretManager.getTurretMap()[r][c]);
						}
					}
				}
			}
		}
		
		else if (removeMode) {
			Rectangle[][] plantArea = turretManager.getPlantArea();
			for (int r = 0; r < plantArea.length; r++) {
				for (int c = 0; c < plantArea[r].length; c++) {
					Rectangle rect = plantArea[r][c];
					if (rect.contains(x, y)) {					
						boolean success = turretManager.removeAt(r, c);
						
						if (success) {
							setRemoveMode(false);
							for (int i = 0; i < turrets.size(); i++) {
								if (turrets.get(i).getBounds().contains(rect)) {
									turrets.remove(i);
									break;
								}
							}
						}
					}
				}
			}
		}
		
	}
	
	private void attackEnemyIfRange() {
		for (Turret t : turrets) {
			for (Enemy e : enemyManager.getEnemies()) {
				if (e.isAlive()) {
					if (inRange(t, e)) {
						t.shoot();
						
						for (Bullet b : t.getBullets()) {
							if (b.hit(e)) {
								e.hurt(t.getDmg());
								t.getBullets().remove(b);
								break;
							}
						}
					} else {
						// Do Nothing
					}
				}
			}
		}
	}

	private boolean inRange(Turret t, Enemy e) {
		return (t.getY() >= e.getY() - 45 && t.getY() <= e.getY() + 45) && (t.getX() + 50 < e.getX());
	}

	@Override
	public void handleMouseOver(int x, int y) {
		placeholderX = x;
		placeholderY = y;
	}

	@Override
	public void handleMousePress(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleMouseRelease(int x, int y) {
		// TODO Auto-generated method stub
		
	}
	
	public boolean getPlantingMode() {
		return plantingMode;
	}
	
	public void setPlantingMode(boolean plantingMode) {
		this.plantingMode = plantingMode;
	}
	
	public void setRemoveMode(boolean removeMode) {
		this.removeMode = removeMode;
	}

}

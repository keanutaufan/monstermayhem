package scenes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;

import helpers.LevelBuilder;
import main.Game;
import managers.EnemyManager;
import managers.TileManager;
import managers.TurretManager;
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
	private TurretTypes turretToPlant;
	private TurretManager turretManager;
	
	private int placeholderX;
	private int placeholderY;
	
	public Playing(Game game) {
		super(game);
		airdrop = 0;
		plantingMode = false;
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
				{ 2, 1, 0, 1, 0, 1, 0, 1, 0, 2, 2 },
				{ 2, 1, 0, 1, 0, 1, 0, 1, 0, 2, 2 },
				{ 2, 1, 0, 1, 0, 1, 0, 1, 0, 2, 2 },
				{ 2, 1, 0, 1, 0, 1, 0, 1, 0, 2, 2 },
				{ 2, 1, 0, 1, 0, 1, 0, 1, 0, 2, 2 },
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
	}
	
	@Override
	public void render(Graphics g) {
		drawLevel(g);
		enemyManager.draw(g);
		drawUIComponents(g);
		
		if (plantingMode) {
			turretManager.drawPlantArea(g);
			turretManager.drawPlaceholder(g, placeholderX, placeholderY, turretToPlant);
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
				turretToPlant = b.getType();
			}
		});
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

}

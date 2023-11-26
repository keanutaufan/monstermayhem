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
import ui.ImageButton;
import managers.SpriteManager;

public class Playing extends GameScene implements SceneMethods {
	
//	private int[][] level;
//	private TileManager tileManager;
	private final Color UI_BG_COLOR = new Color(189, 108, 74);
	private EnemyManager enemyManager;
	
	private SpriteManager spriteManager;
	private ArrayList<ImageButton> buyTurretButtons;
	private ImageButton removeTurretButton;
	
	private int[][] bgLayout;
	private int airdrop;
	
	public Playing(Game game) {
		super(game);
		airdrop = 0;
//		level = LevelBuilder.getLevelData();
//		tileManager = new TileManager();
		enemyManager = new EnemyManager(this);
		
		spriteManager = new SpriteManager();
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
		
		for (int i = 0; i < 4; i++) {
			BufferedImage img = spriteManager.getSprite(8 + i);
			buyTurretButtons.add(new ImageButton(X_OFFSET + i * 87, 0, img, img, img));
		}
		
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
				g.drawImage(spriteManager.getSprite(id), x * 120, y * 120, null);				
			}
		}
	}
	
	@Override
	public void handleMouseClick(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleMouseOver(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleMousePress(int x, int y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleMouseRelease(int x, int y) {
		// TODO Auto-generated method stub
		
	}

}

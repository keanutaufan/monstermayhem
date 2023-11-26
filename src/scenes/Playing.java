package scenes;

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
import managers.SpriteManager;

public class Playing extends GameScene implements SceneMethods {
	
//	private int[][] level;
//	private TileManager tileManager;
	private EnemyManager enemyManager;
	
	private SpriteManager spriteManager;
	private int[][] bgLayout;
	
	public Playing(Game game) {
		super(game);
//		level = LevelBuilder.getLevelData();
//		tileManager = new TileManager();
		enemyManager = new EnemyManager(this);
		
		spriteManager = new SpriteManager();
		initBGLayout();
		
		
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

	public void update() {
		enemyManager.update();
	}
	
	@Override
	public void render(Graphics g) {
		drawLevel(g);
		enemyManager.draw(g);
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

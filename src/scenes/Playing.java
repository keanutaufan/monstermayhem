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
import managers.TileManager;

public class Playing extends GameScene implements SceneMethods {
	
	private int[][] level;
	private TileManager tileManager;
	
	public Playing(Game game) {
		super(game);
		level = LevelBuilder.getLevelData();
		tileManager = new TileManager();
	}

	@Override
	public void render(Graphics g) {
		for (int i = 0; i < level.length; i++) {
			for (int j = 0; j < level[i].length; j++) {
				int id = level[i][j];
				g.drawImage(tileManager.getSprite(id), j * 32, i * 32, null);
			}
		}
	}

}

package managers;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import helpers.LoadSave;

public class SpriteManager {
	BufferedImage atlas;
	ArrayList<BufferedImage> sprites;
	
	public SpriteManager() {
		atlas = LoadSave.loadImage("level_sprites.png");
		sprites = new ArrayList<>();
		
		loadTurrets();
		loadTiles();
		loadLevelUIElements();
	}
	
	public BufferedImage getSprite(int id) {
		return sprites.get(id);
	}
	
	private void loadTurrets() {
		for (int i = 0; i < 4; i++) {
			sprites.add(atlas.getSubimage(i * 120, 0, 120, 120));
		}
	}
	
	private void loadTiles() {
		for (int i = 0; i < 4; i++) {
			sprites.add(atlas.getSubimage(i * 120, 120, 120, 120));
		}
	}
	
	private void loadLevelUIElements() {
		for (int i = 0; i < 6; i++) {
			sprites.add(atlas.getSubimage(i * 87, 240, 87, 100));
		}
	}
	
	
}

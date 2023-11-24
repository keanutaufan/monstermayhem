package managers;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import helpers.LoadSave;
import objects.Tile;

public class TileManager {

	public Tile GRASS, WATER, ROAD;
	public BufferedImage atlas;
	public ArrayList<Tile> tiles = new ArrayList<>();
	
	public TileManager() {
		loadAtlas();
		createTiles();
	}

	private void createTiles() {
		tiles.add(WATER = new Tile(getSprite(0, 0)));
		tiles.add(GRASS = new Tile(getSprite(9, 0)));
		tiles.add(ROAD = new Tile(getSprite(8, 0)));
	}

	private void loadAtlas() {
		atlas = LoadSave.getSpriteAtlas();
	}
	
	public BufferedImage getSprite(int id) {
		return tiles.get(id).getSprite();
	}
	
	private BufferedImage getSprite(int x, int y) {
		return atlas.getSubimage(x * 32, y * 32, 32, 32);
	}
	
}

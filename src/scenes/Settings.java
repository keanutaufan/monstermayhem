package scenes;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import helpers.LoadSave;
import main.Game;
import main.GameStates;
import ui.ImageButton;

public class Settings extends GameScene implements SceneMethods {
	
	BufferedImage bg;
	
	ImageButton btnBack;

	public Settings(Game game) {
		super(game);
		bg = LoadSave.loadImage("big_grass.png");
		
		initButtons();
	}
	
	private void initButtons() {
		BufferedImage buttonAtlas = LoadSave.loadImage("settings_buttons.png");
		
		BufferedImage backNormalImage = buttonAtlas.getSubimage(0, 0, 288, 96);
		BufferedImage backHoverImage = buttonAtlas.getSubimage(0, 96, 288, 96);
		BufferedImage backPressImage = buttonAtlas.getSubimage(0, 192, 288, 96);
		btnBack = new ImageButton(928, 579, backNormalImage, backHoverImage, backPressImage);
	}
	
	private void renderButtons(Graphics g) {
		btnBack.draw(g);
	}

	@Override
	public void render(Graphics g) {
		for (int y = 0; y < 15; y++) {
			for (int x = 0; x < 27; x++) {
				g.drawImage(bg, x * 48, y * 48, null);
			}
		}	
		
		renderButtons(g);
	}

	@Override
	public void handleMouseClick(int x, int y) {
		if (btnBack.getBounds().contains(x, y)) {
			GameStates.gameState = GameStates.MENU;
		}
	}

	@Override
	public void handleMouseOver(int x, int y) {
		btnBack.setHover(false);
		
		if (btnBack.getBounds().contains(x, y)) {
			btnBack.setHover(true);
		}
	}

	@Override
	public void handleMousePress(int x, int y) {
		if (btnBack.getBounds().contains(x, y)) {
			btnBack.setPressed(true);
		}
	}

	@Override
	public void handleMouseRelease(int x, int y) {
		btnBack.setPressed(false);
		btnBack.setHover(false);
	}

}

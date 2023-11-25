package scenes;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import helpers.LoadSave;
import main.Game;
import main.GameStates;
import ui.ImageButton;

public class Menu extends GameScene implements SceneMethods {
	
	BufferedImage bg;
	BufferedImage logo;
	
	ImageButton btnPlay, btnSettings, btnExit;
	
	public Menu(Game game) {
		super(game);
		bg = LoadSave.loadImage("big_grass.png");
		logo = LoadSave.loadImage("logo.png");
		
		initButtons();
	}
	
	private void initButtons() {
		BufferedImage buttonAtlas = LoadSave.loadImage("menu_buttons.png");
		
		BufferedImage playNormalImage = buttonAtlas.getSubimage(0, 0, 320, 96);
		BufferedImage playHoverImage = buttonAtlas.getSubimage(0, 96, 320, 96);
		BufferedImage playPressImage = buttonAtlas.getSubimage(0, 192, 320, 96);
		btnPlay = new ImageButton(496, 381, playNormalImage, playHoverImage, playPressImage);
		
		BufferedImage settingsNormalImage = buttonAtlas.getSubimage(320, 0, 160, 96);
		BufferedImage settingsHoverImage = buttonAtlas.getSubimage(320, 96, 160, 96);
		BufferedImage settingsPressImage = buttonAtlas.getSubimage(320, 192, 160, 96);
		btnSettings = new ImageButton(432, 520, settingsNormalImage, settingsHoverImage, settingsPressImage);
		
		BufferedImage exitNormalImage = buttonAtlas.getSubimage(480, 0, 160, 96);
		BufferedImage exitHoverImage = buttonAtlas.getSubimage(480, 96, 160, 96);
		BufferedImage exitPressImage = buttonAtlas.getSubimage(480, 192, 160, 96);
		btnExit = new ImageButton(720, 520, exitNormalImage, exitHoverImage, exitPressImage);
	}
	
	private void renderButtons(Graphics g) {
		btnPlay.draw(g);
		btnSettings.draw(g);
		btnExit.draw(g);
	}
	
	@Override
	public void render(Graphics g) {
		for (int y = 0; y < 15; y++) {
			for (int x = 0; x < 27; x++) {
				g.drawImage(bg, x * 48, y * 48, null);
			}
		}
		
		g.drawImage(logo, 312, 0, null);
		renderButtons(g);
	}

	@Override
	public void handleMouseClick(int x, int y) {
		if (btnPlay.getBounds().contains(x, y)) {
			GameStates.gameState = GameStates.PLAYING;
		} else if (btnSettings.getBounds().contains(x, y)) {
			
		} else if (btnExit.getBounds().contains(x, y)) {
			System.exit(0);
		}
	}

	@Override
	public void handleMouseOver(int x, int y) {
		btnPlay.setHover(false);
		btnSettings.setHover(false);
		btnExit.setHover(false);
		
		if (btnPlay.getBounds().contains(x, y)) {
			btnPlay.setHover(true);
		} else if (btnSettings.getBounds().contains(x, y)) {
			btnSettings.setHover(true);
		} else if (btnExit.getBounds().contains(x, y)) {
			btnExit.setHover(true);
		}
		
	}

	@Override
	public void handleMousePress(int x, int y) {
		if (btnPlay.getBounds().contains(x, y)) {
			btnPlay.setPressed(true);
		} else if (btnSettings.getBounds().contains(x, y)) {
			btnSettings.setPressed(true);
		} else if (btnExit.getBounds().contains(x, y)) {
			btnExit.setPressed(true);
		}
	}

	@Override
	public void handleMouseRelease(int x, int y) {
		btnPlay.setPressed(false);
		btnPlay.setHover(false);
		
		btnSettings.setPressed(false);
		btnSettings.setHover(false);
		
		btnExit.setPressed(false);
		btnExit.setHover(false);
	}

}

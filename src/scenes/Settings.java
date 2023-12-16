package scenes;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import helpers.LoadSave;
import main.Game;
import main.GameStates;
import ui.ImageButton;
import ui.ToggleButton;

public class Settings extends GameScene implements SceneMethods {
	
	BufferedImage bg;
	BufferedImage titleImage;
	BufferedImage textImage;
	
	ImageButton btnBack;
	
	ToggleButton sfxOnButton;
	ToggleButton sfxOffButton;
	
	private boolean sfxOn;

	public Settings(Game game) {
		super(game);
		bg = LoadSave.loadImage("big_grass.png");
		titleImage = LoadSave.loadImage("settings_title.png");
		textImage = LoadSave.loadImage("settings_texts.png");
		
		sfxOn = true;
		
		initButtons();
	}
	
	private void initButtons() {
		BufferedImage buttonAtlas = LoadSave.loadImage("settings_buttons.png");
		
		BufferedImage backNormalImage = buttonAtlas.getSubimage(0, 0, 288, 96);
		BufferedImage backHoverImage = buttonAtlas.getSubimage(0, 96, 288, 96);
		BufferedImage backPressImage = buttonAtlas.getSubimage(0, 192, 288, 96);
		btnBack = new ImageButton(928, 579, backNormalImage, backHoverImage, backPressImage);
		
		BufferedImage sfxOnOffImage = buttonAtlas.getSubimage(0, 288, 128, 64);
		BufferedImage sfxOnOnImage = buttonAtlas.getSubimage(0, 352, 128, 64);
		sfxOnButton = new ToggleButton(268, 331, sfxOnOnImage, sfxOnOffImage);
		sfxOnButton.setOn(sfxOn);
		
		BufferedImage sfxOffOffImage = buttonAtlas.getSubimage(128, 288, 128, 64);
		BufferedImage sfxOffOnImage = buttonAtlas.getSubimage(128, 352, 128, 64);
		sfxOffButton = new ToggleButton(437, 331, sfxOffOnImage, sfxOffOffImage);
		sfxOffButton.setOn(!sfxOn);
	}
	
	private void renderButtons(Graphics g) {
		btnBack.draw(g);
		sfxOnButton.draw(g);
		sfxOffButton.draw(g);
	}

	@Override
	public void render(Graphics g) {
		for (int y = 0; y < 15; y++) {
			for (int x = 0; x < 27; x++) {
				g.drawImage(bg, x * 48, y * 48, null);
			}
		}
		
		g.drawImage(titleImage, 354, 26, null);
		g.drawImage(textImage, 114, 334, null);
		
		renderButtons(g);
	}

	@Override
	public void handleMouseClick(int x, int y) {
		if (btnBack.getBounds().contains(x, y)) {
			GameStates.gameState = GameStates.MENU;
		} else if (sfxOnButton.getBounds().contains(x, y)) {
			sfxOnButton.setOn(true);
			sfxOffButton.setOn(false);
			sfxOn = true;
		} else if (sfxOffButton.getBounds().contains(x, y)) {
			sfxOnButton.setOn(false);
			sfxOffButton.setOn(true);
			sfxOn = false;
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
	
	public boolean sfxIsOn() {
		return sfxOn;
	}

}

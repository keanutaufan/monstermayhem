package scenes;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JButton;

import helpers.LoadSave;
import main.Game;
import main.GameStates;
import ui.ImageButton;

public class GameOver extends GameScene implements SceneMethods {
	
	BufferedImage bg;
	ImageButton btnPlay, btnSettings, btnExit;
	
	public GameOver(Game game) {
		super(game);
		initButtons();
	}

	private void initButtons() {
		BufferedImage buttonAtlas = LoadSave.loadImage("menu_buttons.png");
		
		BufferedImage playNormalImage = buttonAtlas.getSubimage(10, 10, 300, 76);
		BufferedImage playHoverImage = buttonAtlas.getSubimage(10, 106, 300, 76);
		BufferedImage playPressImage = buttonAtlas.getSubimage(10, 202, 300, 76);
		btnPlay = new ImageButton(470, 381, playNormalImage, playHoverImage, playPressImage);
		
		BufferedImage settingsNormalImage = buttonAtlas.getSubimage(330, 10, 140, 76);
		BufferedImage settingsHoverImage = buttonAtlas.getSubimage(330, 106, 140, 76);
		BufferedImage settingsPressImage = buttonAtlas.getSubimage(330, 202, 140, 76);
		btnSettings = new ImageButton(470, 480, settingsNormalImage, settingsHoverImage, settingsPressImage);
		
		BufferedImage exitNormalImage = buttonAtlas.getSubimage(490, 10, 140, 76);
		BufferedImage exitHoverImage = buttonAtlas.getSubimage(490, 106, 140, 76);
		BufferedImage exitPressImage = buttonAtlas.getSubimage(490, 202, 140, 76);
		btnExit = new ImageButton(630, 480, exitNormalImage, exitHoverImage, exitPressImage);
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 1280, 720);
		g.setFont(new Font("Monserrat", Font.BOLD, 60));
		g.setColor(Color.RED);
		g.drawString("GAME", 530, 300);
		g.drawString("OVER", 534, 360);
		btnPlay.draw(g);
		btnSettings.draw(g);
		btnExit.draw(g);
	}

	@Override
	public void handleMouseClick(int x, int y) {
		if (btnPlay.getBounds().contains(x, y)) {
			replayGame();
			GameStates.gameState = GameStates.PLAYING;
		} else if (btnSettings.getBounds().contains(x, y)) {
			GameStates.gameState = GameStates.SETTINGS;
		} else if (btnExit.getBounds().contains(x, y)) {
			GameStates.gameState = GameStates.MENU;
		}
	}

	private void replayGame() {
		game.getPlaying().resetEverything();
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

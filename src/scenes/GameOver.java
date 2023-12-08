package scenes;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import helpers.LoadSave;
import main.Game;
import ui.ImageButton;

public class GameOver extends GameScene implements SceneMethods {
	
	public GameOver(Game game) {
		super(game);
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 1280, 720);
		g.setFont(new Font("Monserrat", Font.BOLD, 60));
		g.setColor(Color.RED);
		g.drawString("GAME", 530, 300);
		g.drawString("OVER", 534, 360);
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

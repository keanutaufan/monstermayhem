package scenes;

import java.awt.Color;
import java.awt.Graphics;
import main.Game;

public class Menu extends GameScene implements SceneMethods {
	
	public Menu(Game game) {
		super(game);
	}
	
	@Override
	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		String text = "This is MENU, Left click screen to go to playing";
		g.drawString(text, 200, 320);
	}

}

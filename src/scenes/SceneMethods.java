package scenes;

import java.awt.Graphics;

public interface SceneMethods {

	public void render(Graphics g);
	public void handleMouseClick(int x, int y);
	public void handleMouseOver(int x, int y);
	public void handleMousePress(int x, int y);
	public void handleMouseRelease(int x, int y);
	
}

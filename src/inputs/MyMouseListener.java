package inputs;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import main.Game;
import main.GameStates;

public class MyMouseListener implements MouseListener, MouseMotionListener {
	
	private Game game;
	
	public MyMouseListener(Game game) {
		this.game = game;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		switch(GameStates.gameState) {
		case MENU:
			game.getMenu().handleMouseOver(e.getX(), e.getY());
			break;
		case PLAYING:
			game.getPlaying().handleMouseOver(e.getX(), e.getY());
			break;
		case SETTINGS:
			game.getSettings().handleMouseOver(e.getX(), e.getY());
			break;
		case GAME_OVER:
			game.getGameOver().handleMouseOver(e.getX(), e.getY());
			break;
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			switch(GameStates.gameState) {
			case MENU:
				game.getMenu().handleMouseClick(e.getX(), e.getY());
				break;
			case PLAYING:
				game.getPlaying().handleMouseClick(e.getX(), e.getY());
				break;
			case SETTINGS:
				game.getSettings().handleMouseClick(e.getX(), e.getY());
				break;
			case GAME_OVER:
				game.getGameOver().handleMouseClick(e.getX(), e.getY());
				break;
			}
		} else if (e.getButton() == MouseEvent.BUTTON3) {
			switch(GameStates.gameState) {
			case MENU:
				break;
			case PLAYING:
				game.getPlaying().setPlantingMode(false);
				game.getPlaying().setRemoveMode(false);
				break;
			case SETTINGS:
				break;
			case GAME_OVER:
				break;
			}
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		switch(GameStates.gameState) {
		case MENU:
			game.getMenu().handleMousePress(e.getX(), e.getY());
			break;
		case PLAYING:
			game.getPlaying().handleMousePress(e.getX(), e.getY());
			break;
		case SETTINGS:
			game.getSettings().handleMousePress(e.getX(), e.getY());
			break;
		case GAME_OVER:
			game.getGameOver().handleMousePress(e.getX(), e.getY());
			break;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		switch(GameStates.gameState) {
		case MENU:
			game.getMenu().handleMouseRelease(e.getX(), e.getY());
			break;
		case PLAYING:
			game.getPlaying().handleMouseRelease(e.getX(), e.getY());
			break;
		case SETTINGS:
			game.getSettings().handleMouseRelease(e.getX(), e.getY());
			break;
		case GAME_OVER:
			game.getGameOver().handleMouseRelease(e.getX(), e.getY());
			break;
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}

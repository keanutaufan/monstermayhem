package helpers;

import enemies.Crusty;
import enemies.Gopher;

public class Constants {

	public static class Enemies {
		
		public static final int GOPHER = 0;
		public static final int CRUSTY = 1;
		
		public static float GetSpeed(int enemyType) {
			switch (enemyType) {
			case GOPHER:
				return 2f;
			case CRUSTY:
				return 0.5f;
			}
			
			return 0;
		}
	
	}
	
}

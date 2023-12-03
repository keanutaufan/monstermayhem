package helpers;

import enemies.Crusty;
import enemies.Gopher;
import turrets.TurretTypes;

public class Constants {

	public static class Enemies {
		
		public static final int GOPHER = 0;
		public static final int CRUSTY = 1;
		public static final int DUKE = 2;
		public static final int DASH = 3;
		
		public static float GetSpeed(int enemyType) {
			switch (enemyType) {
			case GOPHER:
				return 0.5f;
			case CRUSTY:
				return 0.3f;
			case DUKE:
				return 0.4f;
			case DASH:
				return 0.8f;
			}
			
			return 0;
		}
		
		public static int GetStartHealth(int enemyType) {
			switch (enemyType) {
			case GOPHER:
				return 75;
			case CRUSTY:
				return 200;
			case DUKE:
				return 150;
			case DASH:
				return 60;
			}
			
			return 0;
		}
	
	}
	
	public static class Turrets {
		
		public static final int GREEN_TANK = 0;
		public static final int DESERT_TANK = 1;
		public static final int GRAY_TANK = 2;
		public static final int NAVY_TANK = 3;
		
		public static float GetStartDmg(TurretTypes turretType) {
			switch (turretType) {
				case GREEN_TANK:
					return 10;
				case DESERT_TANK:
					return 15;
				case GRAY_TANK:
					return 20;
				case NAVY_TANK:
					return 25;
			}
			
			return 0;
		}
		
		public static float GetDefaultCooldown(TurretTypes turretType) {
			switch (turretType) {
				case GREEN_TANK:
					return 2000;
				case DESERT_TANK:
					return 2000;
				case GRAY_TANK:
					return 2000;
				case NAVY_TANK:
					return 2000;
			}
			
			return 0;
		}
		
	}
	
}

package helpers;

import enemies.Crusty;
import enemies.Gopher;
import turrets.TurretTypes;

public class Constants {

	public static class Enemies {
		
		public static final int GOPHER = 0;
		public static final int CRUSTY = 1;
		
		public static float GetSpeed(int enemyType) {
			switch (enemyType) {
			case GOPHER:
				return 0.7f;
			case CRUSTY:
				return 0.5f;
			}
			
			return 0;
		}
		
		public static int GetStartHealth(int enemyType) {
			switch (enemyType) {
			case GOPHER:
				return 69;
			case CRUSTY:
				return 150;
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
					return 20;
				case DESERT_TANK:
					return 35;
				case GRAY_TANK:
					return 50;
				case NAVY_TANK:
					return 75;
			}
			
			return 0;
		}
		
		public static float GetDefaultRange(TurretTypes turretType) {
			switch (turretType) {
				case GREEN_TANK:
					return 666;
				case DESERT_TANK:
					return 666;
				case GRAY_TANK:
					return 666;
				case NAVY_TANK:
					return 666;
			}
			
			return 0;
		}
		
		public static float GetDefaultCooldown(TurretTypes turretType) {
			switch (turretType) {
				case GREEN_TANK:
					return 10;
				case DESERT_TANK:
					return 10;
				case GRAY_TANK:
					return 10;
				case NAVY_TANK:
					return 10;
			}
			
			return 0;
		}
		
	}
	
}

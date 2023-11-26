package turrets;

public enum TurretTypes {
	GREEN_TANK(0),
	DESERT_TANK(1),
	GRAY_TANK(2),
	NAVY_TANK(3);
	
	private final int value;
	
	private TurretTypes(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
}

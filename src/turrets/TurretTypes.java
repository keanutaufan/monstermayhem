package turrets;

public enum TurretTypes {
	GREEN_TANK(0, 100),
	DESERT_TANK(1, 120),
	GRAY_TANK(2, 120),
	NAVY_TANK(3, 200);
	
	private final int value;
	private final int cost;
	
	private TurretTypes(int value, int cost) {
		this.value = value;
		this.cost = cost;
	}
	
	public int getValue() {
		return value;
	}
	
	public int getCost() {
		return cost;
	}
}

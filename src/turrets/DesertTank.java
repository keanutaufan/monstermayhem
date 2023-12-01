package turrets;

public class DesertTank extends Turret {
	public DesertTank(int x, int y) {
		super(x, y, TurretTypes.DESERT_TANK, spriteManager.getSprite(1));
	}
}

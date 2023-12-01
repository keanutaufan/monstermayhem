package turrets;

public class NavyTank extends Turret {
	public NavyTank(int x, int y) {
		super(x, y, TurretTypes.NAVY_TANK, spriteManager.getSprite(3));
	}
}

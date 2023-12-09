package turrets;

public class NavyTank extends Turret {
	public NavyTank(int x, int y) {
		super(x, y, 500, TurretTypes.NAVY_TANK, spriteManager.getSprite(3));
	}
}

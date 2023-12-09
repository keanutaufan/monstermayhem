package turrets;

public class GreenTank extends Turret {
	public GreenTank(int x, int y) {
		super(x, y, 200, TurretTypes.GREEN_TANK, spriteManager.getSprite(0));
	}
}

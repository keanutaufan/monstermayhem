package turrets;

public class GrayTank extends Turret {
	public GrayTank(int x, int y) {
		super(x, y, TurretTypes.GRAY_TANK, spriteManager.getSprite(2));
	}
}

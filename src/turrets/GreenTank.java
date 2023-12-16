package turrets;

public class GreenTank extends Turret {
	public GreenTank(int x, int y) {
		super(
				x, 
				y, 
				200, 
				TurretTypes.GREEN_TANK, 
				images.getSubimage(0, 0, 120, 120),
				images.getSubimage(0, 120, 120, 120));
	}
}

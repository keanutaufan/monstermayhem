package turrets;

public class GreenTank extends Turret {
	public GreenTank(int x, int y) {
		super(
				x, 
				y, 
				4, 
				TurretTypes.GREEN_TANK, 
				images.getSubimage(0, 0, 120, 120),
				images.getSubimage(0, 120, 120, 120),
				images.getSubimage(0, 240, 120, 120),
				images.getSubimage(0, 360, 120, 120));
	}
}

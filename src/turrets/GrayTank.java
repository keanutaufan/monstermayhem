package turrets;

public class GrayTank extends Turret {
	public GrayTank(int x, int y) {
		super(
				x, 
				y, 
				7, 
				TurretTypes.GRAY_TANK, 
				images.getSubimage(240, 0, 120, 120),
				images.getSubimage(240, 120, 120, 120),
				images.getSubimage(240, 240, 120, 120),
				images.getSubimage(240, 360, 120, 120));
	}
}

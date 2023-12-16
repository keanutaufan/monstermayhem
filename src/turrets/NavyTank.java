package turrets;

public class NavyTank extends Turret {
	public NavyTank(int x, int y) {
		super(
				x, 
				y, 
				10, 
				TurretTypes.NAVY_TANK, 
				images.getSubimage(360, 0, 120, 120),
				images.getSubimage(360, 120, 120, 120),
				images.getSubimage(360, 240, 120, 120),
				images.getSubimage(360, 360, 120, 120));
	}
}

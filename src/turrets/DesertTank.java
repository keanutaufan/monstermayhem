package turrets;

public class DesertTank extends Turret {
	public DesertTank(int x, int y) {
		super(
				x, 
				y, 
				7, 
				TurretTypes.DESERT_TANK, 
				images.getSubimage(120, 0, 120, 120),
				images.getSubimage(120, 120, 120, 120),
				images.getSubimage(120, 240, 120, 120),
				images.getSubimage(120, 360, 120, 120));
	}
}

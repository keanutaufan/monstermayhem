package bullets;

import helpers.LoadSave;

public class AlmightyBullet3000 extends Bullet {
	public AlmightyBullet3000(int x, int y) {
		super(x, y, LoadSave.loadImage("bullet.png"), 10);
	}
}

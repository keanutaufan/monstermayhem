package airdrop;

import java.awt.image.BufferedImage;

public class CrystalAirdrop extends Airdrop {
	static final BufferedImage image = images.getSubimage(225, 0, 75, 75);
			
	public CrystalAirdrop(int x, int y) {
		super(x, y, 1000, image, 1);
	}
}

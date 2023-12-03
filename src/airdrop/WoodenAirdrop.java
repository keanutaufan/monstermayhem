package airdrop;

import java.awt.image.BufferedImage;

public class WoodenAirdrop extends Airdrop {
	static final BufferedImage image = images.getSubimage(0, 0, 75, 75);
			
	public WoodenAirdrop(int x, int y) {
		super(x, y, 100, image, 1);
	}
}

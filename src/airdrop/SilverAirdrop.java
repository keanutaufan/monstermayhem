package airdrop;

import java.awt.image.BufferedImage;

public class SilverAirdrop extends Airdrop {
	static final BufferedImage image = images.getSubimage(75, 0, 75, 75);
			
	public SilverAirdrop(int x, int y) {
		super(x, y, 300, image, 1);
	}
}

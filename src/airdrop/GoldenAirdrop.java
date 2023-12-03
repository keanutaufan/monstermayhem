package airdrop;

import java.awt.image.BufferedImage;

public class GoldenAirdrop extends Airdrop {
	static final BufferedImage image = images.getSubimage(150, 0, 75, 75);
			
	public GoldenAirdrop(int x, int y) {
		super(x, y, 500, image, 1);
	}
}

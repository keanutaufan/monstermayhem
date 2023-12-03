package managers;

import java.awt.Graphics;
import java.util.ArrayList;

import airdrop.Airdrop;
import airdrop.AirdropTypes;
import airdrop.CrystalAirdrop;
import airdrop.GoldenAirdrop;
import airdrop.SilverAirdrop;
import airdrop.WoodenAirdrop;

public class AirdropManager {
	static final SpriteManager spriteManager = new SpriteManager();
	private ArrayList<Airdrop> airdrops;
	
	public AirdropManager() {
		airdrops = new ArrayList<>();
	}
	
	public void update() {
		airdrops.forEach(a -> a.move());
		
		for (int i = 0; i < airdrops.size(); i++) {
			Airdrop a = airdrops.get(i);
			if (a.getY() > 1400) {
				airdrops.remove(i);
				break;
			}
		}
	}
	
	public void draw(Graphics g) {
		airdrops.forEach(a -> a.draw(g));
	}
	
	public void spawnAt(int x, int y, AirdropTypes type) {
		switch(type) {
		case WOODEN_AIRDROP:
			airdrops.add(new WoodenAirdrop(x, y));
			break;
		case SILVER_AIRDROP:
			airdrops.add(new SilverAirdrop(x, y));
			break;
		case GOLDEN_AIRDROP:
			airdrops.add(new GoldenAirdrop(x, y));
			break;
		case CRYSTAL_AIRDROP:
			airdrops.add(new CrystalAirdrop(x, y));
			break;
		default:
			break;
		}
	}
	
	public int collectAirdropAt(int x, int y) {
		int value = 0;
		
		for (int i = 0; i < airdrops.size(); i++) {
			Airdrop a = airdrops.get(i);
			if (a.getBounds().contains(x, y)) {
				value = a.getValue();
				airdrops.remove(i);
				break;
			}
		}
		
		return value;
	}
}

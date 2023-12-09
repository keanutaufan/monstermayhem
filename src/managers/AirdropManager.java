package managers;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import airdrop.Airdrop;
import airdrop.AirdropTypes;
import airdrop.CrystalAirdrop;
import airdrop.GoldenAirdrop;
import airdrop.SilverAirdrop;
import airdrop.WoodenAirdrop;
import events.AirdropCycle;

public class AirdropManager {
	static final SpriteManager spriteManager = new SpriteManager();
	private ArrayList<Airdrop> airdrops;
	
    private int airdropSpawnTick = 0;
    private int airdropSpawnTickLimit = 60 * 10;
    private Random random = new Random();
	
	public AirdropManager() {
		airdrops = new ArrayList<>();
	}
	public void update() {
		airdropSpawnTick++;

        if (airdropSpawnTick >= airdropSpawnTickLimit) {
        	spawnAirdrop();
            airdropSpawnTick = 0;
        }
		
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
	
	private void spawnAirdrop() {
		double randomValue = random.nextDouble() * 100;

        int spawnX = random.nextInt(1280);
        int spawnY = -100;

        if (randomValue < 90) {
        	spawnAt(spawnX, spawnY, AirdropTypes.WOODEN_AIRDROP);
        } else if (randomValue < 98) {
        	spawnAt(spawnX, spawnY, AirdropTypes.SILVER_AIRDROP);
        } else if (randomValue < 99.8) {
        	spawnAt(spawnX, spawnY, AirdropTypes.GOLDEN_AIRDROP);
        } else {
        	spawnAt(spawnX, spawnY, AirdropTypes.CRYSTAL_AIRDROP);
        }
     
    }
	
	public ArrayList<Airdrop> getAirdrops() {
		return airdrops;
	}
	
	public void reset() {
		airdrops.clear();
		airdropSpawnTick = 0;
	}
	
}

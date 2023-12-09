package managers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

import events.Wave;
import scenes.Playing;

public class WaveManager {

	private Playing playing;
	private ArrayList<Wave> waves = new ArrayList<>();
	private int enemySpawnTickLimit = 60 * 5; // spawn enemy every 5 seconds 
	private int enemySpawnTick = -(60 * 5); // headstart
	private int enemyIndex, waveIndex;
	private int waveTickLimit = 60 * 5; // time until next wave, 5 seconds
	private int waveTick = 0;
	public boolean waveStartTimer, waveTickTimerOver;
	private Random random = new Random();
	
	public WaveManager(Playing playing) {
		this.playing = playing;
		createWaves();
	}
	
	public void update() {
		if (enemySpawnTick < enemySpawnTickLimit) {
			enemySpawnTick++;
		}
		if (waveStartTimer) {
			waveTick++;
			if (waveTick >= waveTickLimit) {
				waveTickTimerOver = true;
			}
		}
		if (waveIndex >= 9) {
			ArrayList<Integer> bonusEnemies = new ArrayList<>();
			
			for (int i = 0; i < random.nextInt(20) + 5; i++) {
				bonusEnemies.add(random.nextInt(4));
			}
			
			waves.add(new Wave(bonusEnemies));
		}
	}
	
	public void increaseWaveIndex() {
		waveIndex++;
		waveTickTimerOver = false;
		waveStartTimer = false;
	}
	
	public int getNextEnemy() {
		enemySpawnTick = 0;
		return waves.get(waveIndex).getEnemyList().get(enemyIndex++);
	}
	
	private void createWaves() {
		// Wave 0: Intro
		waves.add(new Wave(new ArrayList<>(Arrays.asList(0))));
		
		// Wave 1: Early Game
        waves.add(new Wave(new ArrayList<>(Arrays.asList(0, 0, 0))));
        
        // Wave 2: Introducing tanky enemies
        waves.add(new Wave(new ArrayList<>(Arrays.asList(0, 1, 0, 1))));

        // Wave 3: Mix of enemies and new enemiy type
        waves.add(new Wave(new ArrayList<>(Arrays.asList(0, 2, 0, 2, 0, 1, 1))));

        // Wave 4: Increased number of tanky enemies
        waves.add(new Wave(new ArrayList<>(Arrays.asList(1, 1, 1, 2, 0, 2, 0, 1))));

        // Wave 5: Faster enemies introduced
        waves.add(new Wave(new ArrayList<>(Arrays.asList(2, 0, 3, 0, 3, 1, 2, 1, 3, 1, 3))));

        // Wave 6: Faster enemies with some tanky ones
        waves.add(new Wave(new ArrayList<>(Arrays.asList(3, 0, 3, 1, 0, 0, 1, 2, 3, 2, 1, 0))));

	    // Wave 7: Intense mix of all enemy types
	    waves.add(new Wave(new ArrayList<>(Arrays.asList(0, 1, 2, 3, 2, 1, 0, 0, 1, 2, 3, 2, 1, 0))));
	
	    // Wave 8: More emphasis on balanced enemies
	    waves.add(new Wave(new ArrayList<>(Arrays.asList(2, 0, 2, 1, 2, 0, 1, 2, 1, 2, 1, 0, 2, 1, 2, 2))));
	
	    // Wave 9: Final challenging wave
	    waves.add(new Wave(new ArrayList<>(Arrays.asList(3, 2, 1, 0, 3, 2, 1, 0, 0, 1, 2, 3, 2, 1, 0, 3, 2, 1, 0, 3))));
	     
	}

	public ArrayList<Wave> getWaves() {
		return waves;
	}

	public boolean isTimeForNewEnemy() {
		return enemySpawnTick >= enemySpawnTickLimit;
	}
	
	public boolean areThereMoreEnemiesInWave() {
		return enemyIndex < waves.get(waveIndex).getEnemyList().size();
	}

	public boolean areThereMoreWaves() {
		return waveIndex + 1 < waves.size();
	}

	public void startWaveTimer() {
		waveStartTimer = true;
	}

	public boolean isWaveTimerOver() {
		return waveTickTimerOver;
	}

	public void resetEnemyIndex() {
		enemyIndex = 0;
	}

	public void reset() {
		waves.clear();
		createWaves();
		enemyIndex = 0;
		waveIndex = 0;
		waveStartTimer = false;
		waveTickTimerOver = false;
		waveTick = 0;
		enemySpawnTick = -(60 * 5);
	}
	
}

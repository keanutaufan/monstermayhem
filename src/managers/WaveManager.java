package managers;

import java.util.ArrayList;
import java.util.Arrays;

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
		// Wave 0: Pre-intro
		waves.add(new Wave(new ArrayList<>(Arrays.asList(0))));
		
		// Wave 1: Easy introduction
        waves.add(new Wave(new ArrayList<>(Arrays.asList(0, 0, 0))));
        
        // Wave 2: Introducing tanky enemies
        waves.add(new Wave(new ArrayList<>(Arrays.asList(0, 1, 0, 1))));

        // Wave 3: Mix of common and balanced enemies
        waves.add(new Wave(new ArrayList<>(Arrays.asList(0, 2, 0, 2, 0))));

        // Wave 4: Increased number of tanky enemies
        waves.add(new Wave(new ArrayList<>(Arrays.asList(1, 1, 1))));

        // Wave 5: Faster enemies introduced
        waves.add(new Wave(new ArrayList<>(Arrays.asList(2, 0, 2, 0, 3))));

        // Wave 6: Mix of tanky and balanced enemies
        waves.add(new Wave(new ArrayList<>(Arrays.asList(1, 2, 1, 2, 1))));

        // Wave 7: Faster enemies with some tanky ones
        waves.add(new Wave(new ArrayList<>(Arrays.asList(3, 0, 3, 1, 0))));

        // Wave 8: Intense mix of all enemy types
        waves.add(new Wave(new ArrayList<>(Arrays.asList(0, 1, 2, 3, 2, 1, 0))));

        // Wave 9: More emphasis on balanced enemies
        waves.add(new Wave(new ArrayList<>(Arrays.asList(2, 0, 2, 1, 2, 0))));

        // Wave 10: Final challenging wave
        waves.add(new Wave(new ArrayList<>(Arrays.asList(3, 2, 1, 0, 3, 2, 1, 0))));

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

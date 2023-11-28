package enemies;

import java.awt.Rectangle;

public abstract class Enemy {
	
	protected float x, y;
	protected Rectangle bounds;
	protected int health;
	protected int maxHealth;
	protected int ID;
	protected int enemyType;
	protected boolean alive = true;
	
	public Enemy(float x, float y, int ID, int enemyType) {
		this.x = x;
		this.y = y;
		this.ID = ID;
		this.enemyType = enemyType;
		bounds= new Rectangle((int)x, (int)y, 120, 120);
		setStartHealth();
	}

	private void setStartHealth() {
		health = helpers.Constants.Enemies.GetStartHealth(enemyType);
		maxHealth = health;
	}
	
	public float getHealthBarFloat() {
		return health /(float) maxHealth;
	}
	
	public void hurt(int dmg) {
		this.health -= dmg;
		if (health <= 0) {
			alive = false;
		}
	}
	
	public void move(float x, float y) {
		this.x -= x;
		this.y += y;
	}
	
	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public Rectangle getBounds() {
		return bounds;
	}

	public int getHealth() {
		return health;
	}

	public int getID() {
		return ID;
	}

	public int getEnemyType() {
		return enemyType;
	}
	
	public boolean isAlive() {
		return alive;
	}
	
}

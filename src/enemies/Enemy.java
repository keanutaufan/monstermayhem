package enemies;

import java.awt.Rectangle;

import turrets.Turret;

public abstract class Enemy {
	
	protected float x, y;
	protected Rectangle bounds;
	protected int health;
	protected int maxHealth;
	protected int ID;
	protected int enemyType;
	protected boolean alive = true;
	protected boolean attacking = false;
	
	public Enemy(float x, float y, int ID, int enemyType) {
		this.x = x;
		this.y = y;
		this.ID = ID;
		this.enemyType = enemyType;
		bounds = new Rectangle((int)x, (int)y, 120, 120);
		setStartHealth();
	}

	private void setStartHealth() {
		health = helpers.Constants.Enemies.GetStartHealth(enemyType);
		maxHealth = health;
	}
	
	public float getHealthBarFloat() {
		return health /(float) maxHealth;
	}
	
	public void hurt(float dmg) {
		this.health -= dmg;
		if (health <= 0) {
			alive = false;
		}
	}
	
	public void attack(Turret turret) {
		turret.hurt(1);
	}
	
	public void move(float x, float y) {
		this.x -= x;
		this.y += y;
		bounds = new Rectangle((int) this.x, (int) this.y, 120, 120);
	}
	
	public void kill() {
		alive = false;
		health = 0;
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
	
	public boolean isAttacking() {
		return attacking;
	}
	
	public void setAttacking(boolean attacking) {
		this.attacking = attacking;
	}
	
}

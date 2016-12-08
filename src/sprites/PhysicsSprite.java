/**
 * 
 */
package sprites;

import javafx.scene.paint.Color;

/**
 * @author joelmanning
 *
 */
public class PhysicsSprite extends Sprite {
	
	public static final double GRAVITY = 0.1;
	
	private double vx;
	private double vy;
	
	/**
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param color
	 */
	public PhysicsSprite(double x, double y, double width, double height,
			double vx, double vy, Color color) {
		super(x, y, width, height, color);
		this.vx = vx;
		this.vy = vy;
	}
	
	public void tick(int timePassed){
		setX(getX() + vx * timePassed);
		setY(getY() + (vy + GRAVITY * timePassed / 2) * timePassed);
		setVy(getVy() + GRAVITY * timePassed);
	}
	
	public void tick(){
		tick(1);
	}

	/**
	 * @return the vx
	 */
	public double getVx() {
		return vx;
	}

	/**
	 * @return the vy
	 */
	public double getVy() {
		return vy;
	}

	/**
	 * @param vx the vx to set
	 */
	public void setVx(double vx) {
		this.vx = vx;
	}

	/**
	 * @param vy the vy to set
	 */
	public void setVy(double vy) {
		this.vy = vy;
	}
	
}

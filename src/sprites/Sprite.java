package sprites;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Sprite {
	
	private double x;
	private double y;
	private double width;
	private double height;
	private Color color;
	
	public Sprite(double x, double y, double width, double height, Color color){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color;
	}
	
	public void tick(int time){
		
	}
	
	public void tick(){
		tick(1);
	}
	
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void draw(GraphicsContext context){
		context.setFill(color);
		context.fillRect(x, y, width, height);
	}

}

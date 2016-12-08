package main;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import sprites.PhysicsSprite;
import sprites.Sprite;

public class Game {
	
	public static final int RELOAD_TIME = 20;
	
	public static Game instance;
	private Main main;
	private List<Sprite> sprites = new ArrayList<Sprite>();
	private int reload;
	
	public Game() {
		instance = this;
		main = Main.getInstance();
	}
	
	public static Game getInstance() {
		return instance;
	}
	
	public void initialize() {
		sprites.add(new Sprite(100, 100, 50, 50, Color.WHITESMOKE));
	}
	
	public void renderFrame(GraphicsContext context, int frame) {
		
		if(main.isPressed("BACK_SPACE"))
			System.exit(0);
		
		context.clearRect(0, 0, main.WIDTH, main.HEIGHT);
		context.setFill(Color.BLACK);
		context.fillRect(0, 0, main.WIDTH, main.HEIGHT);
		
		if(main.isPressed("A"))
			for(Sprite sprite : sprites)
				sprite.setX(sprite.getX() - 10);
		else if(main.isPressed("D"))
			for(Sprite sprite : sprites)
				sprite.setX(sprite.getX() + 10);
		else if(main.isPressed("T") && reload == 0) {
			sprites.add(new PhysicsSprite(sprites.get(0).getX(), sprites.get(0)
					.getY(), 10, 10, 40, 0, Color.BLANCHEDALMOND));
			reload = RELOAD_TIME;
		}
		for(Sprite sprite : sprites) {
			sprite.draw(context);
			if(sprite instanceof PhysicsSprite) {
				((PhysicsSprite) sprite).tick();
			}
		}
		if(reload > 0) {
			reload--;
		}
	}
	
}

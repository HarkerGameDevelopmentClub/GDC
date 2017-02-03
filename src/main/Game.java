package main;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import sprites.Coal;
import sprites.PhysicsSprite;
import sprites.Player;
import sprites.Sprite;

public class Game {
	
	
	public static Game instance;
	private Main main;
	public List<Sprite> sprites = new ArrayList<Sprite>();
	
	public Game() {
		instance = this;
		main = Main.getInstance();
	}
	
	public static Game getInstance() {
		return instance;
	}
	
	public void initialize() {
		sprites.add(new Player(100, 100, 50, 50, 0, 0, true, Color.WHITESMOKE)); // False for now since we don't have a floor
	}
	
	public void renderFrame(GraphicsContext context, int frame) {
		
		if(main.isPressed("BACK_SPACE"))
			System.exit(0);
		
		context.clearRect(0, 0, main.WIDTH, main.HEIGHT);
		context.setFill(Color.BLACK);
		context.fillRect(0, 0, main.WIDTH, main.HEIGHT);
		
		for(int i = sprites.size()-1; i >= 0; i--) {
			Sprite sprite = sprites.get(i);
			if(sprite instanceof Player)
				((Player)sprite).parseInput();
			sprite.tick();
			sprite.draw(context);
		}
	}
	
}

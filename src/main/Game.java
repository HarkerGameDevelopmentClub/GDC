package main;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import sprites.Coal;
import sprites.PhysicsSprite;
import sprites.Sprite;

public class Game {
	
	public static final int RELOAD_TIME = 20;
	
	public static Game instance;
	private Main main;
	private List<Sprite> sprites = new ArrayList<Sprite>();
	private Sprite player;
	private int reload;
	
	public Game() {
		instance = this;
		main = Main.getInstance();
	}
	
	public static Game getInstance() {
		return instance;
	}
	
	public void initialize() {
		player = new Sprite(100, 100, 50, 50, Color.WHITESMOKE);
		sprites.add(player);
	}
	
	public void renderFrame(GraphicsContext context, int frame) {
		
		if(main.isPressed("BACK_SPACE"))
			System.exit(0);
		
		context.clearRect(0, 0, main.WIDTH, main.HEIGHT);
		context.setFill(Color.BLACK);
		context.fillRect(0, 0, main.WIDTH, main.HEIGHT);
		
		if(main.isPressed("A"))
			player.setX(player.getX() - 10);
		else if(main.isPressed("D"))
			player.setX(player.getX() + 10);
		if(main.isPressed("T") && reload == 0) {
			sprites.add(new Coal(player.getX(), player.getY(), 40, 10));
			reload = RELOAD_TIME;
		}
		for(Sprite sprite : sprites) {
			sprite.tick();
			sprite.draw(context);
		}
		if(reload > 0) {
			reload--;
		}
	}
	
}

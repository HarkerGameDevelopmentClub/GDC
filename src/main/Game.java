package main;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import sprites.Sprite;

public class Game {
	
	static Game instance;
	Main main;
	List<Sprite> sprites = new ArrayList<Sprite>();
	
	public Game(){
		instance = this;
		main = Main.getInstance();
	}
	
	public static Game getInstance(){
		return instance;
	}

	public void initialize(){
		sprites.add(new Sprite(100, 100, 50, 50, Color.WHITESMOKE));
	}
	
	public void renderFrame(GraphicsContext context, int frame){
		
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
		
		for(Sprite sprite : sprites)
			sprite.draw(context);
	}
	
}

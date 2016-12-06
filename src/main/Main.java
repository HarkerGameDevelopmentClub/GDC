package main;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.HashMap;
import java.util.HashSet;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Main extends Application implements EventHandler<KeyEvent> {
	
	public Game game;
	public double TITLE_HEIGHT = 40;
	public double WIDTH = 1920;
	public double HEIGHT = 1080 - TITLE_HEIGHT;
	
	private HashSet<String> input = new HashSet<String>();
	private HashMap<String, Integer> blocked = new HashMap<String, Integer>();
	
	private static Main instance;
	
	public static void main(String[] args) {
        launch(args);
    }

	@Override
	public void start(Stage stage) {
		
		instance = this;
		
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		WIDTH = size.getWidth();
		HEIGHT = size.getHeight() - TITLE_HEIGHT;
		
		game = new Game();
		
		Canvas canvas = new Canvas(WIDTH, HEIGHT);
		GraphicsContext context = canvas.getGraphicsContext2D();

		Scene scene = new Scene(new Group(canvas));
		stage.setScene(scene);
		stage.setResizable(false);
		stage.setWidth(WIDTH);
		stage.setHeight(HEIGHT + TITLE_HEIGHT);
		
		stage.setTitle("GDC Game");
		
		stage.show();
		
		new AnimationTimer(){
			int i = 0;
			
			@Override
			public void handle(long arg0) {
				i++;
				instance.handle(i);
				game.renderFrame(context, i);
			}
			
		}.start();
		
		scene.setOnKeyPressed(this);
		scene.setOnKeyReleased(this);
		
		game.initialize();
	}
	
	public static Main getInstance(){
		return instance;
	}
	
	
	public void blockKey(String key, int ticks) {
		blocked.put(key, ticks);
		input.remove(key);
	}
	
	public void handle(int frame) {
		HashSet<String> toRemove = new HashSet<String>();
		
		for (String key : blocked.keySet()) {
			int ticksLeft = blocked.get(key);
			if (ticksLeft > 1)
				blocked.put(key, ticksLeft - 1);
			else
				toRemove.add(key);
		}
		
		for(String key : toRemove)
			blocked.remove(key);
	}

	@Override
	public void handle(KeyEvent event) {
		//System.out.println(event.getCode().toString());
		String code = event.getCode().toString();
		
		if(event.getEventType() == KeyEvent.KEY_PRESSED && !blocked.containsKey(code))
			input.add(code);
		else if(event.getEventType() == KeyEvent.KEY_RELEASED)
			input.remove(code);
	}
	
	public HashSet<String> getInput(){
		return input;
	}
	
	public boolean isPressed(String str){
		return input.contains(str);
	}
}

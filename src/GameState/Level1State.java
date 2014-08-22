package GameState;

import Game.GamePanel;
import TileMap.*;

import java.awt.Color;
import java.awt.Graphics2D;

public class Level1State extends GameState {
	
	private TileMap tileMap;

	public Level1State(GameStateManager gsm) {
		this.gsm = gsm;
			init();
	}

	@Override
	public void init() {

		tileMap = new TileMap(16);
		tileMap.LoadTiles("/Tilesets/Tilesheet-1.jpg");
		tileMap.loadMap("/Maps/level1-1.map");
		tileMap.setPosition(0, 0);
		
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Graphics2D g) {
		
		//clear screen
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);
		
		
		//draw map
		tileMap.draw(g);
		
	}

	@Override
	public void keyPressed(int k) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(int k) {
		// TODO Auto-generated method stub
		
	}

}

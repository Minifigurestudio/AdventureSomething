package GameState;

import Audio.AudioPlayer;

import java.awt.*;
import java.awt.event.KeyEvent;

import TileMap.Background;

public class MenuState extends GameState {

	private Background bg;
	
	private int currentChoice = 0;
	private String[] options = {
			"Start",
			"Options",
			"Quit"
	};
	
	private Color titleColor;
	private Font titleFont;
	
	private Font font;
	
	public MenuState(GameStateManager gsm)
	{
		this.gsm = gsm;
		try
		{
			bg = new Background("/Graphics/Backgrounds/Castle3.jpg", 1);
			bg.setVector(0, 0);
			
			titleColor = new Color(128,0,0);
			titleFont = new Font("Times New Roman", Font.BOLD, 38);
			font = new Font("Times New Roman" , Font.PLAIN, 19);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void init() {		
		}
	public void update() {
		bg.update();
	}
	public void draw(Graphics2D g) {

		//draw bg
		bg.draw(g);
		
		//draw title
		g.setColor(titleColor);
		g.setFont(titleFont);
		g.drawString("AdventureSomething", 225, 220);
		//draw menu options
		g.setFont(font);
		for(int i = 0; i < options.length; i++)
		{
			if(i == currentChoice)
			{
				g.setColor(Color.WHITE);
			}
			else
			{
				g.setColor(Color.RED);
			}
			g.drawString(options[i], 380, 302 + i * 23);
		}
	}
	private void select()
	{
		if(currentChoice == 0)
		{
			// start
		}
		if(currentChoice == 1)
		{
			// help
		}
		if(currentChoice == 2)
		{
			System.exit(0);
		}
	}
	public void keyPressed(int k) {
		if(k == KeyEvent.VK_ENTER)
		{
			select();
		}
		else if(k == KeyEvent.VK_UP)
		{
			currentChoice--;
			if(currentChoice == -1)
			{
				currentChoice = options.length - 1;
			}
		}
		else if(k == KeyEvent.VK_DOWN)
		{
			currentChoice++;
			if(currentChoice == options.length)
			{
				currentChoice = 0;
			}
		}
	}
	public void keyReleased(int k) {}
	
}

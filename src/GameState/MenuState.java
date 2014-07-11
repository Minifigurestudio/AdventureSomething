package GameState;

import Audio.AudioPlayer;
import Game.GamePanel;

import java.awt.*;
import java.awt.event.KeyEvent;
import javax.swing.JButton;

import TileMap.Background;

public class MenuState extends GameState {

	private Background bg;
	
	float Volume = 0.0f;
	
	private boolean o1 = true;
	private boolean o2 = false;
	
	private int currentChoice = 0;
	private String[] options = {
			"Start",
			"Options",
			"Quit"
	};
	private String[] options2 = {
			"Audio",
			"Controls",
			"Back"
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
			titleFont = new Font("Impact", Font.BOLD, 38);
			font = new Font("Impact" , Font.PLAIN, 19);
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
		bg.draw(g, GamePanel.HEIGHT, GamePanel.WIDTH);
		
		//draw title
		g.setColor(titleColor);
		g.setFont(titleFont);
		g.drawString("AdventureSomething", 225, 50);
		//draw menu options
		g.setFont(font);
		if(o1 == true){
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
		else if(o2 == true)
		{
			for(int i = 0; i < options2.length; i++)
			{
				if(i == currentChoice)
				{
					g.setColor(Color.WHITE);
				}
				else
				{
					g.setColor(Color.RED);
				}
				g.drawString(options2[i], 380, 302 + i * 23);
			}
		}
	}
	private void select()
	{
		if(o1 == true)
		{
			if(currentChoice == 0)
			{
				// start
			}
			if(currentChoice == 1)
			{
				currentChoice = 0;
				o1 = false;
				o2 = true;
			}
			if(currentChoice == 2)
			{
				System.exit(0);
			}
		}
		else if(o2 == true)
		{
			if(currentChoice == 0)
			{
				// audio
			}
			if(currentChoice == 1)
			{
				// controls
			}
			if(currentChoice == 2)
			{
				currentChoice = 0;
				o1 = true;
				o2 = false;
			}
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
			if(o1 == true)
			{
				if(currentChoice < 0)
				{
					currentChoice = options.length - 1;
				}
			}
			else if(o2 == true)
			{
				if(currentChoice < 0)
				{
					currentChoice = options2.length - 1;
				}
			}
		}
		else if(k == KeyEvent.VK_DOWN)
		{
			currentChoice++;
			if(o1 == true)
			{
				if(currentChoice > options.length - 1)
				{
					currentChoice = 0;
				}
			}
			else if(o2 == true)
			{
				if(currentChoice > options2.length - 1)
				{
					currentChoice = 0;
				}
			}
		}
	}
	public void keyReleased(int k) {}
}

package GameState;

import Audio.AudioPlayer;
import Game.GamePanel;

import java.awt.*;
import java.awt.event.KeyEvent;

import TileMap.Background;

public class MenuState extends GameState {
	
	//music
	private AudioPlayer bgMusic = new AudioPlayer("/Music/Menu1-1.mp3");
	//Volume percentage visualization
	double x1 = 50;
	
	
	private Background bg;
	
	private boolean o1 = true; //main menu
	private boolean s1 = false; //start menu
	private boolean o2 = false; //options menu
	private boolean a1 = false; //audio menu
	
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
	private String[] start1 = {
			"New Game",
			"Load Game",
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
			bgMusic.play(gsm.Volume);
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
		//Draw options menu
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
				if(i == 0)
				{
					g.drawString(((float)Math.round((x1/50) * 100)) + "%", 500, 302 + i * 23);
				}
			}
		}
		else if(s1 = true)
		{
			for(int i = 0; i < start1.length; i++)
			{
				if(i == currentChoice)
				{
					g.setColor(Color.WHITE);
				}
				else
				{
					g.setColor(Color.RED);
				}
				g.drawString(start1[i], 380, 302 + i * 23);
			}
		}
	}
	private void select()
	{
		//OPTION 1 CHOICES
		if(o1 == true)
		{
			if(currentChoice == 0)
			{
				s1 = true;
				o1 = false;
				o2 = false;
			}
			if(currentChoice == 1)
			{
				//Enter options menu
				currentChoice = 0;
				o1 = false;
				o2 = true;
			}
			if(currentChoice == 2)
			{
				//Close game
				System.exit(0);
			}
		}
		//OPTIONS 2 CHOICES
		else if(o2 == true)
		{
			if(currentChoice == 0)
			{
				// Change Audio
			}
			if(currentChoice == 1)
			{
				// Adjust Controls
			}
			if(currentChoice == 2)
			{
				//Go Back
				currentChoice = 0;
				o1 = true;
				o2 = false;
				bgMusic.play(gsm.Volume);
			}
		}
		//STAT CHOICES
		else if(s1 == true)
		{
			if(currentChoice == 0)
			{
				// NEW GAMES
			}
			if(currentChoice == 1)
			{
				//LOAD GAME
			}
			if(currentChoice == 2)
			{
				//Go Back
				currentChoice = 0;
				o1 = true;
				o2 = false;
				s1 = false;
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
		//Adjust Audio
		else if(k == KeyEvent.VK_LEFT)
		{
			if(o2 == true & currentChoice == 0)
			{
				if(gsm.Volume != -50.0f)
				{
					gsm.Volume -= 1.0f;
					x1 = x1 - 1;
				}
			}
		}
		else if(k == KeyEvent.VK_RIGHT)
		{
			if(o2 == true & currentChoice == 0)
			{
				if(gsm.Volume != 0.0f)
				{
					gsm.Volume += 1.0f;
					x1 = x1 + 1;
				}
			}
		}
	}
	public void keyReleased(int k) {}
}

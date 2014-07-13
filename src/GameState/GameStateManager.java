package GameState;

public class GameStateManager {
	
	public float Volume = -0.0f;
	
	private GameState[] gameStates;
	private int currentState;
	
	public static final int NUMGAMESTATES = 2;
	public static final int MENUSTATE = 0;
	public static final int LEVEL1STATE = 1;
	
	public GameStateManager()
	{
		gameStates = new GameState[NUMGAMESTATES];
		
		currentState = MENUSTATE;
		loadState (currentState);
	}
	
	private void loadState(int state) {
		if(state == MENUSTATE)
			gameStates[state] = new MenuState(this);
		
		//INIT
		gameStates[currentState].init();
		
	}
	
	private void unloadState(int state) {
		gameStates[state] = null;
	}
	
	public void setState(int state) {
		unloadState(currentState);
		currentState = state;
		loadState(currentState);
	}
	
	public void update()
	{
		gameStates[currentState].update();
	}
	
	public void draw(java.awt.Graphics2D g)
	{
		gameStates[currentState].draw(g);
	}
	public void keyPressed(int k)
	{
		gameStates[currentState].keyPressed(k);
	}
	public void keyReleased(int k)
	{
		gameStates[currentState].keyReleased(k);
	}
	
}

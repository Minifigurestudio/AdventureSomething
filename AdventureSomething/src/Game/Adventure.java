package Game;
import javax.swing.JFrame;

class Adventure
{
	public static void main(String[] args)
	{
		JFrame window = new JFrame("AdventureSomething");
		window.setContentPane(new GamePanel());
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.pack();
		window.setVisible(true);
	}
}
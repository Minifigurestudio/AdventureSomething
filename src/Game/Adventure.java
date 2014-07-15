package Game;
import javax.swing.JFrame;
import java.awt.*;

class Adventure
{
	public static void main(String[] args)
	{
		JFrame window = new JFrame("AdventureSomething");
		window.setContentPane(new GamePanel());
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		window.setLocation(dim.width/4-window.getSize().width/4, dim.height/4-window.getSize().height/4);
		
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.pack();
		window.setVisible(true);
	}
}
import java.awt.*;
import javax.swing.JFrame;
public class Window {
	
	private GraphicsDevice vc;
	private JFrame window = new JFrame();
	
	public Window()
	{
		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
		vc = env.getDefaultScreenDevice();
		window.setUndecorated(false);
		window.setResizable(false);
		window.pack();
		window.setVisible(true);
		window.setBounds(100, 100, 600, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.PINK);
	}
}

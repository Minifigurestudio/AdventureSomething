import java.awt.*;
import javax.swing.*;
public class Window {
	
	private GraphicsDevice vc;
	private JFrame window = new JFrame();
	
	
	public Window()
	{
		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
		vc = env.getDefaultScreenDevice();
		window.add(new JLabel(new ImageIcon("C:\\Users\\Joshua\\Documents\\GitHub\\AdventureSomething\\Graphics\\Backgrounds\\Castle2.jpg")));
		window.setUndecorated(false);
		window.setResizable(false);
		window.pack();
		window.setVisible(true);
		window.setBounds(100, 100, 800, 604);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.BLUE);
	}
}

import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import java.awt.Panel;
import java.awt.image.BufferedImage;

public class Astar {

	private JFrame frame;
	
	int WX = 100;
	int WY = 100;
	int WW = 600;
	int WH = 600;
	int cols = 20;
	int rows = 20;
	
	BufferedImage Bimage = new BufferedImage(WW, WH, BufferedImage.TYPE_3BYTE_BGR);
	Graphics g = Bimage.getGraphics();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Astar window = new Astar();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Astar() {
		initialize();
		Start();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setBounds(WX, WY, WW, WH+22);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Panel panel = new Panel() {
			public void paint (Graphics g2) {
				
				g2.drawImage(Bimage, 0, 0, null);
			}
		};
		panel.setBounds(0, 0, WW, WH);
		frame.getContentPane().add(panel);
	}
	
	public void Start() {
		point start = new point();
		point goal = new point();
		
		start.x = 0;
		start.y = 0;
		
		goal.x = 20;
		goal.y = 20;
		
		AstarButItsActuallyTheAlgorithm a = new AstarButItsActuallyTheAlgorithm(WW, WH, cols, rows, g, start, goal);
	}
}

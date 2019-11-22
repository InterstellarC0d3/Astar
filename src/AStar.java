import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import java.awt.Panel;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AStar {

	private JFrame frame;
	
	int WW = 1000;
	int WH = 800;
	int WX = 100;
	int WY = 100;
	
	int cols = 25;
	int rows = 20;
	
	int colwidth = WW/cols;
	int rowheight = WH/rows;
	
	point start = new point();
	point goal = new point();
	
	ArrayList<ArrayList> xlist = new ArrayList<>();
	
	ArrayList<point> openlist = new ArrayList<>();
	ArrayList<point> closedlist = new ArrayList<>();
	
	BufferedImage Bimage = new BufferedImage(WW, WH, BufferedImage.TYPE_3BYTE_BGR);
	Graphics g = Bimage.getGraphics();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AStar window = new AStar();
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
	public AStar() {
		initializeGrid();
		initialize();
	}
	
	public void initializeGrid() {
		
		start.x = 5;
		start.y = 4;
		
		goal.x = 11;
		goal.y = 11;
		
		for (int x = 0; x < cols; x++) {
			ArrayList<point> ylist = new ArrayList<>();
			for (int y = 0; y < rows; y++) {
				point point = new point();
				point.number = y*rows + x;
				point.x = x;
				point.y = y;
				point.h = distance(point, goal);
				ylist.add(point);
				
			}
			xlist.add(ylist);
		}
		//(point) xlist.get(x).get(y)
	}
	
	public int distance(point a, point b) {
		int distance = 0;
		int x = a.x;
		int y = a.y;
		while (x != b.x) {
			if (x < b.x) {
				x++;
				distance++;
			} else if (x > b.x) {
				x--;
				distance++;
			}
		}
		
		while (y != b.y) {
			if (y < b.y) {
				y++;
				distance++;
			} else if (y > b.y) {
				y--;
				distance++;
			}
		}
		return distance;
	}
	
	public void grid() {
		for (int x = 0; x < cols; x++) {
			for (int y = 0; y < rows; y++) {
				
				point a = (point) (xlist.get(x).get(y));
				if (a.x == start.x && a.y == start.y) {
					g.setColor(Color.GREEN);
					g.drawRect(x*colwidth+1, y*rowheight+1, colwidth-2, rowheight-2);
				}
				
				if (a.x == goal.x && a.y == goal.y) {
					g.setColor(Color.RED);
					g.drawRect(x*colwidth+1, y*rowheight+1, colwidth-2, rowheight-2);
				}
				if (a.active == false) {
					g.setColor(Color.BLACK);
					g.fillRect(x*colwidth+1, y*rowheight+1, colwidth-2, rowheight-2);
				}
				
				g.setColor(Color.BLACK);
				g.drawRect(x*colwidth, y*rowheight, colwidth, rowheight);
				
				g.drawString(Integer.toString(a.number), x*colwidth, (y+1)*rowheight-10);
				
				g.setColor(Color.ORANGE);
				g.drawString(Integer.toString(a.h), x*colwidth, (y+1)*rowheight-1);
				
				
			}
		}
	}
	
	public void checkNeighbors(point check) {
		
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(WX, WY, WW + 16, WH + 39);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Panel panel = new Panel() {
			public void paint(Graphics g2) {
				g.setColor(Color.GRAY);
				g.fillRect(0, 0, WW, WH);
				
				g.setColor(Color.BLACK);
				grid();
				
				g2.drawImage(Bimage, 0, 0, null);
			}
		};
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		panel.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
			}
			@Override
			public void keyReleased(KeyEvent e) {
			}
		});
		panel.setBounds(0, 0, WW, WH);
		frame.getContentPane().add(panel);
	}
}

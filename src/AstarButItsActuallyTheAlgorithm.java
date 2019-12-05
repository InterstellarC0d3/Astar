import java.awt.Graphics;
import java.util.ArrayList;

public class AstarButItsActuallyTheAlgorithm {
	
	ArrayList<ArrayList<point>> xlist = new ArrayList<>();
	
	ArrayList<point> openlist = new ArrayList<>();
	ArrayList<point> closedlist = new ArrayList<>();
	
	point current = new point();

	public AstarButItsActuallyTheAlgorithm(int WW, int WH, int cols, int rows, Graphics g, point start, point goal) {
		
		initialize(cols, rows, goal);
		current = start;
	}
	
	public void initialize(int cols, int rows, point goal) {
		
		
		
		for (int x = 0; x<cols; x++) {
			ArrayList<point> ylist = new ArrayList<>();
			for (int y=0; y<rows; y++) {
				point a = new point();
				a.x = x;
				a.y = y;
				a.h = distance(a, goal);
				//System.out.println(a.h);
				ylist.add(a);
				
			}
			xlist.add(ylist);
		}
	}
	
	public double distance(point a, point b) {
		
		int x = b.x - a.x;
		int y = b.y - b.y;
		
		double distance = Math.sqrt(x*x + y*y);
		
		return distance;
	}

	public point lowest() {
		
		point lowest = new point();
		lowest.f = Integer.MAX_VALUE;
		for (int i = 0; i < openlist.size(); i++) {
			if (openlist.get(i).f < lowest.f) {
				
			}
		}
		
		return null;
	}
	
	public void step() {
		
	}
}

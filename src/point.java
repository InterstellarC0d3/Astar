import java.util.ArrayList;

public class point {
	
	boolean active = true;
	int number;
	int x;
	int y;
	double f;
	double g;
	double h;
	int cost;
	ArrayList<point> neighbors = new ArrayList<>();
	point parent;
}

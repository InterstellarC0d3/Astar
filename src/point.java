import java.util.ArrayList;

public class point {
	
	boolean active = true;
	int number;
	int x;
	int y;
	int f;
	int g;
	int h;
	int cost;
	ArrayList<point> neighbors = new ArrayList<>();
	point parent;
}

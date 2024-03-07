package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Point extends UnfilledShape {

	private int x;
	private int y;

	public Point() {
		setColor(Color.BLACK);
	}
	
    public Point(int x, int y) {
    	this();
    	this.x = x;
		this.y = y;
	}

	public Point(int x, int y, Color color) {
		super(color);
		this.x = x;
		this.y = y;
	}

	public Point(int x, int y, Color color, boolean selected) {
		this(x, y, color);
		setSelected(selected);
	}

	public double distance(int x2, int y2) {
		double dx = this.x - x2;
		double dy = this.y - y2;
		double d = Math.sqrt(dx * dx + dy * dy);
		return d;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Point) {
			Point pomocna = (Point) obj;
			if (this.x == pomocna.getX() && this.y == pomocna.getY()) {
				return true;}
			else
				return false;
		} else
			return false;
	}

	@Override
	public boolean contains(int x, int y) {
		return this.distance(x, y) <= 2;
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(this.getColor());
		g.drawLine(x - 2, y, x + 2, y);
		g.drawLine(x, y - 2, x, y + 2);
		
		if(isSelected() == true) {
			g.setColor(Color.BLUE);
			g.drawRect(x-2, y-2, 4, 4);
		}
	}

	@Override
	public void moveTo(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public void moveBy(int x, int y) {
		this.x = this.x + x;
		this.y += y;
	}
		

	@Override
	public int compareTo(Object o) {
		
		if(o instanceof Point) {
			return (int)(this.distance(0,0)-((Point)o).distance(0, 0));
		}
		return 0;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getX() {
		return this.x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getY() {
		return this.y;
	}

	public String toString() {
		return "(" + x + "," + y + "), Color: " + getColor().toString();
	}
	
	public Point clone() {
		Point point = new Point(this.getX(), this.getY(), this.getColor());
		return point;
	}
	
	public String toFileFormat() {
		return "point " + getX() + " " + getY() + " " + getColor().getRed() + " " + getColor().getGreen() + " " + getColor().getBlue() + " " + isSelected();
	}
}
package mahir.shapes;

import java.awt.geom.Point2D;

import processing.core.PApplet;

/**
 * This class models a processing Line. It has a variety of methods based on the
 * line.
 * 
 * @author Mahir Bose
 *
 */
public class Line extends Shape {

	private double x2, y2;

	/**
	 * Creates a line between point 1 and point 2
	 * 
	 * @param x  x-coordinate of point 1
	 * @param y  y-coordinate of point 1
	 * @param x2 x-coordinate of point 2
	 * @param y2 y-coordinate of point 2
	 */
	public Line(double x, double y, double x2, double y2) {
		super(x, y);
		this.x2 = x2;
		this.y2 = y2;

	}

	public static Line constructLineWithAngle(double x, double y, double theta, double length) {
		return new Line(x,y,x + Math.cos(theta) * length, y + Math.sin(theta) * length);
	}
	
	
	public double getAngle() {
		return Math.tan(getHeight() / getWidth());
	}

	public double getLength() {
		return Math.sqrt(getWidth() * getWidth() + getHeight() * getHeight());
	}
	
	/**
	 * Sets point 2
	 * 
	 * @param x2 new x-coordinate of point 2
	 * @param y2 new y-coordinate of point 2
	 * @post Changes the original coordinates of the second point
	 */
	public void setPoint2(double x2, double y2) {
		this.x2 = (float) x2;
		this.y2 = (float) y2;
	}

	/**
	 * Gets the width of the imaginary rectangle bounding this line
	 * 
	 * @return width of the imaginary rectangle bounding this line
	 */
	public double getWidth() {

		return (x2 - getX() );
	}

	/**
	 * Gets the height of the imaginary rectangle bounding this line
	 * 
	 * @return height of the imaginary rectangle bounding this line
	 */
	public double getHeight() {

		return (y2 - getY());
	}

	/**
	 * Gets the area of the line
	 * 
	 * @return area of the line
	 */
	public double getArea() {
		return 0;

	}

	/**
	 * Gets the midpoint of the circle
	 * 
	 * @return coordinate at the midpoint of the line
	 */
	public Point2D.Double getCenter() {
		return new Point2D.Double(getX() + getWidth() / 2, getY() + getHeight() / 2);
	}


	/**
	 * Draws an instance of a line
	 * 
	 * @param marker PApplet object used to draw the line shape
	 * @post marker will have all the previously set settings Ex.strokeColor,
	 *       strokeWeight, ect
	 * 
	 */
	public void draw(PApplet marker) {
		super.draw(marker);
		marker.line((float) getX(), (float) getY(), (float) x2, (float) y2);
	}
}

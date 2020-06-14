package mahir.shapes;

import java.awt.Color;
import java.awt.geom.Point2D;

import processing.core.PApplet;

/**
 * This class models a processing Circle. It has a variety of methods based on
 * the Circle.
 * 
 * @author Mahir Bose
 * 
 */
public class Circle extends Shape {
	private double width, height, radius;

	/**
	 * Creates a default circle object with everything set to zero.
	 */
	public Circle() {

		super(0, 0);

		width = 0;
		height = 0;
		radius = 0;

	}

	/**
	 * Creates a Circle based on the following points (x,y + 0.5*height), (x +
	 * width*0.5,y), (x + width,y + height*0.5), and (x + width*0.5,y + height )
	 * 
	 * @param x      x-coordinate at top middle and bottom middle
	 * @param y      y-coordinate at left middle and right middle
	 * @param width  width of rectangle
	 * @param height height of rectangle
	 */
	public Circle(double x, double y, double width, double height) {
		super(x, y);

		this.width = width;
		this.height = height;
		this.radius = width / 2;

	}

	/**
	 * Creates a Circle based on the following points (x,y + 0.5*height), (x +
	 * width*0.5,y), (x + width,y + height*0.5), and (x + width*0.5,y + height )
	 * 
	 * @param x            x-coordinate at top middle and bottom middle
	 * @param y            y-coordinate at left middle and right middle
	 * @param width        width of rectangle
	 * @param height       height of rectangle
	 * @param strokeWeight thickness of the line surrounding the Circle
	 * @param strokeColor  Color of the line surrounding the Circle
	 * @param fillColor    Color inside the Rectangle
	 */
	public Circle(double x, double y, double width, double height, float strokeWeight, Color strokeColor,
			Color fillColor) {
		super(x, y, strokeWeight, strokeColor, fillColor);
		this.width = width;
		this.height = height;
		this.radius = width / 2;

	}
	 
	/** Sets a new width for the circle
	 * 
	 * @param width new width of circle
	 * @post changes the width of the circle
	 */
	public void setWidth(double width) {
		this.width = width;
		this.radius = width / 2;
	}
	
	/** Sets a new height for the circle
	 * 
	 * @param height new height of circle
	 * @post changes the height of the circle
	 */
	public void setHeight(double height) {
		this.height = height;
	}

	/**
	 * Gets the circumference of the circle
	 * 
	 * @return circumference of the circle
	 */
	public double getPerimeter() {
		return 2 * Math.PI * radius;

	}

	/**
	 * Gets the area of the circle
	 * 
	 * @return area of the rectangle
	 */
	public double getArea() {
		return Math.PI * radius * radius;

	}

	/**
	 * Finds whether the given point is in the circle and returns the
	 * conclusion as a boolean
	 * 
	 * @param x x-coordinate desired for test
	 * @param y y-coordinate desired for test
	 * @return a boolean value that returns true only if the desired coordinate is
	 *         in or on the border of the circle
	 */
	public boolean isPointInside(double x, double y) {
		double xCenter = getX() + (0.5 * width);
		double yCenter = getY() + (0.5 * height);
		double xDif = Math.pow(Math.abs(x - xCenter), 2);
		double yDif = Math.pow(Math.abs(y - yCenter), 2);
		double dif = Math.sqrt(xDif + yDif);
		if (dif > radius) {
			return false;
		} else {
			return true;
		}

	}

	/**
	 * Gets the center coordinate of the cirlce
	 * 
	 * @return coordinate at the center of the circle
	 */
	public Point2D.Double getCenter() {
		return new Point2D.Double(getX() + radius, getY() + radius);
	}

	/**
	 * Gets the x value at the middle right of the circle
	 *                     
	 * @return x value at the middle right of the circle
	 */
	public double xValAtRightMiddle() {
		return getX() + width;

	}

	/**
	 * Gets the y value at the middle right of the circle
	 * 
	 * @return y value at the middle right of the circle
	 */
	public double yValAtRightMiddle() {
		return getY() + 0.5 * height;

	}

	/**
	 * Gets the x value at the middle left of the circle
     *
	 * @return x value at the middle left of the circle
	 */
	public double xValAtLeftMiddle() {
		return getX();

	}

	/**
	 * Gets the y value at the middle left of the circle
     *
	 * @return y value at the middle left of the circle
	 */
	public double yValAtLeftmiddle() {
		return getY() + 0.5 * height;
	}

	/**
	 * Gets the width of the Cirlce
	 * 
	 * @return width of the Circle
	 */
	public double getWidth() {

		return width;
	}

	/**
	 * Gets the height of the Circle
	 * 
	 * @return height of the Circle
	 */
	public double getHeight() {

		return height;
	}
	


	/**
	 * Draws an instance of a circle
	 * 
	 * @param marker PApplet object used to draw the circle shape
	 * @post marker will have all the previously set settings Ex.strokeColor,
	 *       strokeWeight, ect
	 */
	public void draw(PApplet marker) {
		super.draw(marker);
		marker.ellipseMode(PApplet.CORNER);
		marker.circle((float) getX(), (float) getY(), (float) width);

	}

}
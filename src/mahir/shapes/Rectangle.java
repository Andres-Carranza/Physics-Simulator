package mahir.shapes;

import java.awt.Color;
import java.awt.geom.Point2D;

import processing.core.PApplet;

/**
 * This class models a processing Rectangle. It has a variety of methods based
 * on the rectangle.
 * 
 * @author Mahir Bose
 *
 */
public class Rectangle extends Shape {
	private double width, height;

	/**
	 * Creates a default Rectangle object with everything set to zero.
	 */
	public Rectangle() {
		super(0, 0);
		width = 0;
		height = 0;

	}

	/**
	 * Creates a rectangle based on the following points (x,y), (x+width,y),
	 * (x,y+height), and (x+width,y+height)
	 * 
	 * @param x      x-coordinate at upper right hand corner of rectangle
	 * @param y      y-coordinate at upper right hand corner of rectangle
	 * @param width  width of rectangle
	 * @param height height of rectangle
	 */
	public Rectangle(double x, double y, double width, double height) {
		super(x, y);
		this.width = width;
		this.height = height;

	}

	/**
	 * Creates a rectangle based on the following points (x,y), (x+width,y),
	 * (x,y+height), and (x+width,y+height)
	 * 
	 * @param x            x-coordinate at upper right hand corner of rectangle
	 * @param y            y-coordinate at upper right hand corner of rectangle
	 * @param width        width of rectangle
	 * @param height       height of rectangle
	 * @param strokeWeight thickness of the line surrounding the Rectangle
	 * @param strokeColor  Color of the line surrounding the Rectangle
	 * @param fillColor    Color inside the Rectangle
	 */
	public Rectangle(double x, double y, double width, double height, float strokeWeight, Color strokeColor,
			Color fillColor) {
		super(x, y, strokeWeight, strokeColor, fillColor);
		this.width = width;
		this.height = height;

	}

	/** Sets a new width for the rectangle
	 * 
	 * @param width new width of rectangle
	 * @post changes width of rectangle
	 */
	public void setWidth(double width) {
		this.width = width;
	}
	
	/** Sets a new height for the rectangle
	 * 
	 * @param height new height of rectangle
	 * @post changes height of rectangle
	 */
	public void setHeight(double height) {
		this.height = height;
	}
	
	/**
	 * Gets the perimeter of the rectangle
	 * 
	 * @return perimeter of rectangle
	 */
	public double getPerimeter() {
		return (2 * width) + (2 * height);

	}

	/**
	 * Gets the area of the rectangle
	 * 
	 * @return area of the rectangle
	 */
	public double getArea() {
		return (width * height);

	}

	/**
	 * Gets the center coordinate of the rectangle
	 * 
	 * @return coordinate at the center of the Rectangle
	 */
	public Point2D.Double getCenter() {
		return new Point2D.Double(getX() + width / 2, getY() + height / 2);
	}

	/**
	 * Finds whether the given point is in the rectangle and returns the
	 * conclusion as a boolean
	 * 
	 * @param x x-coordinate desired for test
	 * @param y y-coordinate desired for test
	 * @return a boolean value that returns true only if the desired coordinate is
	 *         in the rectangle
	 */
	public boolean isPointInside(double x, double y) {
		if ((x > getX()) && (x < (getX() + width)) && (y > getY()) && (y < (getY() + height))) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * Finds a random x-coordinate between x and x + width
	 * 
	 * @pre width > 0
	 * @return x value of a random point in the rectangle
	 * 
	 */
	public double randomXPointInside() {
		return (getX() + (width * Math.random()));

	}

	/**
	 * Finds a random y-coordinate between y and y + height
	 * 
	 * @pre height > 0
	 * @return y value of a random point in the rectangle
	 */
	public double randomYPointInside() {
		return (getY() + (height * Math.random()));
	}

	/**
	 * Finds the width of the Rectangle
	 * 
	 * @return width of the Rectangle
	 */
	public double getWidth() {

		return width;
	}

	/**
	 * Finds the height of the Rectangle
	 * 
	 * @return height of the Rectangle
	 */
	public double getHeight() {

		return height;
	}

	/**
	 * Draws an instance of a rectangle
	 * 
	 * @param marker PApplet object used to draw the rectangle shape
	 * @post marker will have all the previously set settings Ex.strokeColor,
	 *       strokeWeight, ect
	 * 
	 */
	public void draw(PApplet marker) {
		super.draw(marker);
		marker.rectMode(PApplet.CORNER);
		marker.rect((float) getX(), (float) getY(), (float) width, (float) height);

	}

}
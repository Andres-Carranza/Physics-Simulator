package mahir.shapes;

import java.awt.Color;
import java.awt.geom.Point2D;

import processing.core.PApplet;

/**
 * This class models a processing Shape. It acts a superclass for the Rectangle,
 * Circle, and Line class. It has a variety of methods and constructors that
 * apply to all subclasses.
 * 
 * @author Mahir Bose
 *
 */

public abstract class Shape {
	// FIELDS

	private double x, y;

	private Color strokeColor;
	private Color fillColor;

	private float strokeWeight = 1;

	private boolean isFilled;

	// CONSTRUCTOR

	/**
	 * Creates a shape at the location (x,y)
	 * 
	 * @param x x-coordinate at upper right hand corner of shape
	 * @param y y-coordinate at upper right hand corner of shape
	 */
	public Shape(double x, double y) {
		this.x = x;
		this.y = y;
		strokeColor = Color.BLACK;
		isFilled = false;
		fillColor = Color.WHITE;

	}

	/**
	 * Creates a shape at the location (x,y)
	 * 
	 * @param x            x-coordinate at upper right hand corner of shape
	 * @param y            y-coordinate at upper right hand corner of shape
	 * @param width        width of shape
	 * @param height       height of shape
	 * @param strokeWeight thickness of the line surrounding the shape
	 * @param strokeColor  Color of the line surrounding the shape
	 * @param fillColor    Color inside the shape
	 */
	public Shape(double x, double y, float strokeWeight, Color strokeColor, Color fillColor) {
		this.x = x;
		this.y = y;
		isFilled = true;
		this.strokeWeight = strokeWeight;
		this.strokeColor = strokeColor;
		this.fillColor = fillColor;

	}

	// METHODS

	/**
	 * Sets the strokeWeight of the shape
	 * 
	 * @param strokeWeight thickness of the line surrounding the shape
	 */
	public void setStrokeWeight(int strokeWeight) {
		this.strokeWeight = strokeWeight;
	}

	/**
	 * Sets the strokeColor of the shape
	 * 
	 * @param strokeColor Color of the line surrounding the shape
	 */
	public void setStrokeColor(Color strokeColor) {
		this.strokeColor = strokeColor;
	}

	/**
	 * Sets whether the shape will be filled or not
	 * 
	 * @param isFilled boolean value of whether the shape is filled or not
	 */
	public void setFill(boolean isFilled) {
		this.isFilled = isFilled;
	}

	/**
	 * Sets the color the shape is filled with
	 * 
	 * @param fillColor color that the shape is filled in with
	 */
	public void setFillColor(Color fillColor) {

		this.fillColor = fillColor;

	}

	/**
	 * Gets the width of the shape
	 * 
	 * @return width of the shape
	 */
	public abstract double getWidth();

	/**
	 * Gets the height of the shape
	 * 
	 * @return height of the shape
	 */
	public abstract double getHeight();

	/**
	 * Gets the area of the shape
	 * 
	 * @return area of the shape
	 */
	public abstract double getArea();

	/**
	 * Sets the upper right hand coordinate to a new (x,y) coordinate
	 * 
	 * @param x new x-value of upper right coordinate
	 * @param y new y-value of upper right coordinate
	 * @post changes upper right corner to the new (x,y). This consequently moves
	 *       the rest of the shape as well
	 */
	public void setPoint(double x, double y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Gets x coordinate at upper right coordinate
	 * 
	 * @return x-value of upper right coordinate
	 */
	public double getX() {
		return x;
	}

	/**
	 * Gets y-value of upper right coordinate
	 * 
	 * @return y-value of upper right coordinate
	 */
	public double getY() {
		return y;
	}

	// Shape 2D
	/**
	 * Gets the center coordinate of the shape
	 * 
	 * @return coordinate at the center of the shape
	 */
	public abstract Point2D.Double getCenter();

	/**
	 * Moves the shape by the specified x and y value
	 * 
	 * @param x moves the shape in the x-direction by x
	 * @param y moves the shape in the y-direction by y
	 * @post changes all coordinates of the shape by (+x,+y)
	 */
	public void translate(double x, double y) {
		this.x += x;
		this.y += y;
	}

	/**
	 * Draws an instance of a shape
	 *
	 * @param marker PApplet object used to draw the rectangle shape
	 * @post marker will have all the previously set settings Ex.strokeColor,
	 *       strokeWeight, ect
	 * 
	 */
	public void draw(PApplet marker) {

		if (isFilled) {
			marker.fill(fillColor.getRGB());
		} else {
			marker.noFill();
		}
		marker.strokeWeight(strokeWeight);
		marker.stroke(strokeColor.getRGB());
	}

	public void moveTo(double x, double y) {
		this.x = x;
		this.y = y;
	}

}
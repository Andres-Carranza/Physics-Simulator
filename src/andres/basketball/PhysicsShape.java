package andres.basketball;
import andres.toolkit.Point;
import andres.toolkit.ShapesToolkit;
import mahir.shapes.*;
import processing.core.PApplet;
public class PhysicsShape {
	private Shape s;// Rectangle, Cicle, or line
	private Vector v;// m/s
	private Vector a;// m/s^2
	private double m;// kg
	private double ti;
	public static final double g = 9.81;


	public PhysicsShape(Shape shape) {
		this(shape,new Vector(),new Vector(),0);
	}

	public PhysicsShape(Shape shape, Vector v, Vector a, double mass) {
		this.v = v.mult(Main.PPM);
		this.a = a.mult(Main.PPM);
		m = mass;
		s = shape;
		ti = System.currentTimeMillis() / 1000.;

	}

	public void draw(PApplet drawer) {
		s.draw(drawer);
	}

	public void act() {
		double t = System.currentTimeMillis() / 1000. - ti;

		s.translate((v.x * t + .5 * a.x * t * t) ,(v.y * t + .5 * a.y * t * t)  );
		v.x += a.x * t;
		v.y += a.y * t;
		ti = System.currentTimeMillis() / 1000.;

	}

	public void checkCollision(Shape s2) {
		if(ShapesToolkit.checkIntersection(s, s2));
	}

	public Point getCenter() {
		return new Point(s.getCenter().x, s.getCenter().y);
	}

	/*public void actForce(Vector f, double t) {
		System.out.print(v.y + ": ");

		v.x += f.x /m * t;
		v.y += f.y / m * t;
		System.out.println(v.y);
	}*/

	public Shape getShape() {
		return s;
	}

	public double getMass() {
		return m;
	}

	public double getX() {
		return s.getX();
	}

	public double getY() {
		return s.getY();
	}

	public double getWidth() {
		return s.getWidth();
	}

	public double getHeight() {
		return s.getHeight();
	}

	public Vector getVelocity() {
		return v;
	}

	public Vector getAcceleration() {
		return a;
	}

}

package andres.basketball;

import andres.toolkit.Point;
import mahir.shapes.Circle;
import processing.core.PApplet;

public class ShootingArc {
	private Vector v;
	private Point p;

	public ShootingArc(Point p, Vector v) {
		this.v = v;

		this.p = new Point(p.x -5, p.y -5);

	}

	public void draw(PApplet drawer) {
		drawer.mouseDragged();

		double time = .5;

		int numCircles = (int) (v.length() * Main.PPM * time/10);
		

		for(double i =0; i < numCircles; i++) {
			double deltat = i / numCircles * time;
			double deltax = v.x * deltat;
			double deltay = v.y * deltat + .5 * PhysicsShape.g * deltat * deltat;
			
			boolean inBounds = p.y + 10+ deltay * Main.PPM < Main.GROUND.getY();
			inBounds = inBounds && p.y + deltay * Main.PPM > Main.ROOF.getY();
			inBounds = inBounds && p.x + 10+ deltax * Main.PPM < Main.WALLS[1].getX();
			inBounds = inBounds && p.x + deltax * Main.PPM > Main.WALLS[0].getX();
			
			if(inBounds )
				new Circle(p.x + deltax* Main.PPM, p.y + deltay * Main.PPM, 10,10).draw(drawer);

		}


	}

}

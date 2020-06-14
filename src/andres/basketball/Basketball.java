package andres.basketball;

import java.awt.Color;

import mahir.shapes.Shape;
import processing.core.PApplet;

public class Basketball extends PhysicsShape {
	private ShootingArc shootingArc;
	private static final double COEFFICIENT_OF_RESTITUTION = 0.85;
	private static final double FRICTION = 0.99;
	private boolean rolling;

	public Basketball(Shape shape) {
		this(shape, new Vector(0,0), new Vector(0,0),0);
	}

	public Basketball(Shape shape, Vector v, Vector a, double mass) {
		super(shape, v, a, mass);
		shootingArc = null;

		rolling = false;
	}

	public void shoot() {

	}

	public void draw(PApplet drawer) {

		getShape().setFill(true);
		getShape().setFillColor(new Color(229,83,0));

		super.draw(drawer);


		if(shootingArc != null)
			shootingArc.draw(drawer);

	}

	public void act() {
		super.act();

		if(!rolling) {
			bounceOffGround();
		}
		else 
			getVelocity().x *= FRICTION;
		bounceOffRoof();
		bounceOffWalls();

	}

	public void adjustShootingArc(Vector v) {
		shootingArc = new ShootingArc(getCenter(), v);
	}


	public void bounceOffGround() {
		if(getY() + getHeight() > Main.GROUND.getY() ) {
			getVelocity().y *= - COEFFICIENT_OF_RESTITUTION;
			getShape().moveTo(getX(), Main.GROUND.getY() - getHeight());
			if(getVelocity().y > -.6 * Main.PPM) {
				rolling = true;
				getVelocity().y =0;
				getAcceleration().y =0;
			}
		}
	}
	public void bounceOffRoof() {
		if(getY() < Main.ROOF.getY() ) {
			getVelocity().y *= - COEFFICIENT_OF_RESTITUTION;
			getShape().moveTo(getX(), Main.ROOF.getY());
		}

	}
	public void bounceOffWalls() {
		if(getX() < Main.WALLS[0].getX() ) {
			getVelocity().x *= - COEFFICIENT_OF_RESTITUTION;
			getShape().moveTo( Main.WALLS[0].getX(), getY());
		}
		

		if(getX()  + getWidth( )> Main.WALLS[1].getX() ) {
			getVelocity().x *= - COEFFICIENT_OF_RESTITUTION;
			getShape().moveTo( Main.WALLS[1].getX() - getWidth(), getY());
		}

	}
}

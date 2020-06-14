package andres.basketball;

import mahir.shapes.*;
import processing.core.PApplet;

public class Main extends PApplet {

	public static final double PPM =200;
	private Rectangle bounds;
	private Basketball ball;
	//positive is downwards and to the right
	public static final Line GROUND = new Line(50,750,950,750);
	public static final Line ROOF = new Line(50,50,950,50);
	public static final Line WALLS[] = {new Line(50,50,50,750), new Line(950,50,950,750)};

	
	public Main() {
		bounds = new Rectangle(0,0,1000,800);
		ball = new Basketball(new Circle(100 ,750 - 2 * PPM ,.3*PPM,.3*PPM),new Vector(),new Vector(),1);
		
	}

	@Override
	public synchronized void draw(){

		background(255);

		fill(0);
		for(int i = 750; i >= 50; i-=100) {
			new Line(50, i,950,i).draw(this);
			text((750 - i) /PPM + "m",50, i);
		}

		ROOF.draw(this);
		
		WALLS[0].draw(this);
		WALLS[1].draw(this);

		ball.draw(this);

		/*
		 * Acting
		 */

		ball.act();
		ball.checkCollision(bounds);

	}
	public void mousePressed() {
		mouseDragged();
	}

	public void mouseDragged() {
		Vector vi = new Vector(mouseX - ball.getCenter().x, mouseY - ball.getCenter().y).div(PPM/4);

		ball.adjustShootingArc(vi);
	}

	public void mouseReleased() {
		Vector vi = new Vector(mouseX - ball.getCenter().x, mouseY - ball.getCenter().y).div(PPM/4);
		ball = new Basketball(ball.getShape(),vi,new Vector(0, PhysicsShape.g),1);

	}

	public static void main(String[] args) {
		PApplet.main("andres.basketball.Main");
	}

	public void settings(){
		size(1000, 800);
	}

	public void setup(){
	}


}
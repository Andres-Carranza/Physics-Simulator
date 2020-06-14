package andres.toolkit;
import java.util.ArrayList;

import mahir.shapes.*;
public class ShapesToolkit {

	public static boolean checkIntersection(Shape s1, Shape s2) {
		if(s1 instanceof Rectangle) {
			if(s2 instanceof Rectangle)
				return intersects((Rectangle) s1, (Rectangle) s2);
			else if( s2 instanceof Circle)
				return intersects((Rectangle) s1, (Circle) s2);
			else
				return intersects((Rectangle) s1, (Line) s2);
		}
		else if(s1 instanceof Circle){
			if(s2 instanceof Rectangle)
				return intersects((Rectangle) s2, (Circle) s1);
			else if(s2 instanceof Circle)
				return intersects((Circle) s1, (Circle) s2);
			else
				return intersects((Circle) s1, (Line) s2);

		}
		else {
			if(s2 instanceof Rectangle)
				return intersects((Rectangle) s2, (Line) s1);
			else if(s2 instanceof Circle)
				return intersects((Circle) s2, (Line) s1);
			else
				return intersects((Line) s1, (Line) s2);

		}
	}

	public static ArrayList<Line> getBounds(Rectangle r){
		ArrayList<Line> bounds = new ArrayList<Line>();
		Point tl = new Point(r.getX(), r.getY());
		Point tr = new Point(r.getX() + r.getWidth(), r.getY());
		Point bl = new Point(r.getX(), r.getY() + r.getHeight());
		Point br = new Point(r.getX() + r.getWidth(), r.getY() + r.getHeight());

		bounds.add(new Line(tl.x,tl.y,tr.x,tr.y));
		bounds.add(new Line(tr.x,tr.y,br.x,br.y));
		bounds.add(new Line(bl.x,bl.y,br.x,br.y));
		bounds.add(new Line(tl.x,tl.y,bl.x,bl.y));


		return bounds;
	}

	private static boolean intersects(Line l1, Line l2) {

		Point p = getPointOfIntersection(l1, l2);

		return containsPoint(l1,p) && containsPoint(l2, p);
	}



	public static Point getPointOfIntersection(Line l1, Line l2) 
	{ 
		// Line AB represented as a1x + b1y = c1 

		double [] abc1 = getStandardForm(l1);
		double [] abc2 = getStandardForm(l2);
			
		if(abc1[0] == abc2[0])
			return new Point(Double.NaN,Double.NaN);
		else if(abc1[1] == 0) {
			double x = abc1[2];
			double y = abc2[2] - abc2[0] * x;
			return new Point(x,y);
		}
		else if(abc2[1] == 0) {
			double x = abc2[2];
			double y = abc1[2] - abc1[0] * x;
			return new Point(x,y);
		}
			

		double x = (abc1[2] - abc2[2]) / (abc1[0] - abc2[0]);
		double y = abc1[2] - abc1[0] * x;

		return new Point(x,y);


	} 



	private static boolean intersects( Rectangle r, Line l) {
		for(Line bound : getBounds(r))
			if(intersects(l, bound))
				return true;
		return false;

	}

	private static boolean intersects(Circle c1, Circle c2) {
		int x1 = (int) Math.round(c1.getCenter().x);
		int y1 = (int) Math.round(c1.getCenter().y);
		int x2 = (int) Math.round(c2.getCenter().x);
		int y2 = (int) Math.round(c2.getCenter().y);
		int r1 = (int) Math.round(c1.getWidth());
		int r2 = (int) Math.round(c2.getWidth());


		int distSq = (x1 - x2) * (x1 - x2) + 
				(y1 - y2) * (y1 - y2); 
		int radSumSq = (r1 + r2) * (r1 + r2); 

		return distSq >= radSumSq;
	}

	private static boolean intersects(Rectangle r1, Rectangle r2) {
		ArrayList<Line> bounds1 = getBounds(r1);
		ArrayList<Line> bounds2 = getBounds(r2);

		for(Line l1 : bounds1)
			for(Line l2 : bounds2)
				if(intersects(l1,l2))
					return true;

		return false;
	}

	private static boolean intersects(Rectangle rect, Circle cir) {
		for(Line l : getBounds(rect)) {
			double a = getStandardForm(l)[0];
			double b = getStandardForm(l)[1];
			double c = -getStandardForm(l)[2];

			double x = cir.getCenter().x;
			double y = cir.getCenter().y;

			double dist = Math.abs(a * x + b * y + c) /  Math.sqrt(a * a + b * b); 	


			if (dist < Math.abs(cir.getWidth() / 2.))
				return true;
		}

		return false;
	}

	private static boolean intersects(Circle cir, Line l) {

		double a = getStandardForm(l)[0];
		double b = getStandardForm(l)[1];
		double c = -getStandardForm(l)[2];

		double x = cir.getCenter().x;
		double y = cir.getCenter().y;

		double dist = Math.abs(a * x + b * y + c) /  Math.sqrt(a * a + b * b); 	

		if (dist < Math.abs(cir.getWidth() / 2.))
			return true;
		return false;
	}




	/*private static boolean containsPoint(Line l1, Point p) {

		double [] abc = getStandardForm(l1);


		return abc[0] * l1.getX() + abc[1] * l1.getY() - abc[2] <= 0.0000001;

	}*/

	private static boolean containsPoint(Line l1, Point p) {

		Point a = new Point(Math.min(l1.getX(), l1.getX() + l1.getWidth()),Math.min(l1.getY(), l1.getY() + l1.getHeight()));
		Point b = new Point(Math.max(l1.getX(), l1.getX() + l1.getWidth()),Math.max(l1.getY(), l1.getY() + l1.getHeight()));

		return a.x <= p.x && b.x >= p.x && a.y <= p.y && b.y >= p.y; 


	}

	//cant be vertical
	private static double getSlope(Line l) {
		Point p1 = new Point(l.getX(), l.getY());
		Point p2 = new Point(p1.x + l.getWidth(), p1.y + l.getHeight());

		return (p2.y - p1.y) / (p2.x - p1.x);
	}

	public static double[] getStandardForm(Line l) {


		double x1 = l.getX();
		double y1 = l.getY();

		if(l.getWidth() == 0)
			return new double [] {1,0,x1};

		double m = getSlope(l);

		double a = -m;  
		double c =  y1 - m * x1; 


		return new double [] {a,1,c};
	}
}

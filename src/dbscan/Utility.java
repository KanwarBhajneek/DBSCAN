package dbscan;

import java.util.Iterator;
import java.util.Vector;

public class Utility{
	
	public static Vector<Point> VisitList = new Vector<Point>();

	public static double getDistance (Point p, Point q)
	{

		int dx = p.getX()-q.getX();

		int dy = p.getY()-q.getY();

		double distance = Math.sqrt (dx * dx + dy * dy);

		return distance;

	}



/**
neighbourhood points of any point p
**/


	public static Vector<Point> getNeighbours(Point p)
	{
		Vector<Point> neigh =new Vector<Point>();
		Iterator<Point> points = dbscan.pointList.iterator();
		while(points.hasNext()){
				Point q = points.next();
				if(getDistance(p,q)<= dbscan.e){
				neigh.add(q);
				}
		}
		return neigh;
	}

	public static void Visited(Point d){
	VisitList.add(d);
	
	}

	public static boolean isVisited(Point c)
	{
		if (VisitList.contains(c))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public static Vector<Point> Merge(Vector<Point> a,Vector<Point> b)
	{
	
	Iterator<Point> it5 = b.iterator();
	while(it5.hasNext()){
		Point t = it5.next();
		if (!a.contains(t) ){
			a.add(t);
		}
	}
	return a;
	}



//  Returns PointsList to DBscan.java 

	public static Vector<Point> getList() {
	
	Vector<Point> newList =new Vector<Point>();
	newList.clear();
	newList.addAll(Gui.hset);
	return newList;
	}		

	public static Boolean equalPoints(Point m , Point n) {
	if((m.getX()==n.getX())&&(m.getY()==n.getY()))
		return true;
	else
		return false;
	}	

	}








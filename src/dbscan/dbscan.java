package dbscan;


import java.util.*;


public class dbscan
{
		public static int e=Gui.tdistance;
		public static int minpt =Gui.minpoints;
		
		public static Vector<List> resultList = new Vector<List>();
		
		public static Vector<Point> pointList = Utility.getList();
		 	    
	    public static Vector<Point> Neighbours ;
		
		
		

		
		public static Vector<List> applyDbscan()
		{
			resultList.clear();
			pointList.clear();
			Utility.VisitList.clear();
			pointList=Utility.getList();
			
			int index2 =0;
			
						
			while (pointList.size()>index2){
				Point p =pointList.get(index2);
				 if(!Utility.isVisited(p)){
				
					Utility.Visited(p);
					
					Neighbours =Utility.getNeighbours(p);
					
					
					if (Neighbours.size()>=minpt){
						
						
						int ind=0;
						while(Neighbours.size()>ind){
							
							Point r = Neighbours.get(ind);
							if(!Utility.isVisited(r)){
								Utility.Visited(r);
							Vector<Point> Neighbours2 = Utility.getNeighbours(r);
							if (Neighbours2.size() >= minpt){
								Neighbours=Utility.Merge(Neighbours, Neighbours2);
								}
							} ind++;
						}
					
				
				
						System.out.println("N"+Neighbours.size());
				resultList.add(Neighbours);}
				
				
				 }index2++;
			}return resultList;	
		}
		
}
		

			






				
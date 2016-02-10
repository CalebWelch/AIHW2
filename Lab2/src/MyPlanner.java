import java.util.Iterator;
import java.util.PriorityQueue;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.net.URL;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;
public class MyPlanner {
    
   public static MyState ucs(MyState start, MyState goal) throws Exception{ 
	   System.out.println("Begin");
	   PriorityQueue<MyState> frontier = new PriorityQueue<MyState>();
	   TreeSet<MyState> beenthere = new TreeSet<MyState>();
	   beenthere.add(start);
	   frontier.add(start);
	   int count = 0;
	   while(frontier.size() > 0){
		   MyState s = frontier.poll(); 
		   count++;
		   if(frontier.size() == 500){
			   System.out.println("here");
		   }
		   if(count % 5000 < 1000){
			   image.setRGB(s.x, s.y, 0xff00ff00);
		       System.out.println("s.x and s.y are [" + s.x + "] [" + s.y + "]");
		   }
		   if(s.isEqual(goal)){
			   return s;
		   }
		   MyState oldchild =new MyState(0.0,null,0,0);
		   MyState up = new MyState(0.0,s,s.x,s.y+1);
		   MyState down = new MyState(0.0,s,s.x,s.y-1);
		   MyState left = new MyState(0.0,s,s.x-1,s.y);
		   MyState right = new MyState(0.0,s,s.x+1,s.y);
		   Stack<MyState> actions= new Stack<MyState>();
		   actions.add(up);
		   actions.add(down);
		   actions.add(left);
		   actions.add(right);
		   for(MyState a : actions){
	           if((a.x >= 0 && a.x < 500) && (a.y >= 0 && a.y < 500)){
			   MyState child = new MyState(a.x,a.y);
			   double acost;
			   acost = action_cost(a);
				   if(beenthere.contains(child)){
					   oldchild = beenthere.floor(child);
					   System.out.println(s.cost  + " " + acost + " " + oldchild.cost + " ");
					   if(s.cost + acost < oldchild.cost){
						   oldchild.cost = s.cost+acost;
						   oldchild.parent = s;
					   }
				   }
				   else{
					   child.cost=s.cost + acost;
					   child.parent = s;
					   frontier.add(child);
					   beenthere.add(child);
				   }		  
			   }
		   }
		   System.out.println("out of the for loop " + frontier.size());
		   }
		   throw new Exception("There is no path to the goal");
	   }
	
   

   private static double action_cost( MyState s) {
	    
	    Color d = new Color(image.getRGB(s.x,s.y));
		double action_cost = d.getGreen();
		//System.out.println("Action cost is :: " + action_cost + " " + " " + d);
		return action_cost;
   }

   /*private static MyState transition(MyState s, MyState a) {
	   System.out.println("inside transition");			   
	   System.out.println("s coordinates after " + s.x + " " + s.y);

      s.x=a.x;
	  s.y = a.y;
	   System.out.println("s coordinates after " + s.x + " " + s.y);

	return s;
   }*/


   static BufferedImage image = null;
	public static void main(String[] args) throws Exception{
		
		// Load a image from a file
		URL url = MyPlanner.class.getResource("terrain.png");
		image = ImageIO.read(url);

		
		MyState s = new MyState(0.0,null,100,100);
		MyState g = new MyState(0.0,null,400,400);
		MyState fin = ucs(s,g);
		// Write the image to a PNG file
		System.out.println(fin.cost);
		while(fin.parent != null){
	       image.setRGB(fin.x, fin.y, 0xffff0000);
	       fin = fin.parent;
	    }
		System.out.println("writing image");
		ImageIO.write(image, "png", new File("path.png"));
	}

}
	

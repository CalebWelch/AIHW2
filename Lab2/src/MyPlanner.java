import java.util.PriorityQueue;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Set;
public class MyPlanner {
   public MyState ucs(MyState start, MyState goal){
	   PriorityQueue<MyState> frontier = new PriorityQueue();
	   Set<MyState> beenthere = null;
	   start.cost = 0.0;
	   start.parent = null;
	   beenthere.add(start);
	   frontier.add(start);
	   while(frontier.size() > 0){
		   MyState s = frontier.poll();
		   if(s.isEqual(goal)){
			   return s;
		   }
		   MyState up = new MyState(0.0,s,s.x,s.y-1);
		   MyState down = new MyState(0.0,s,s.x,s.y+1);
		   MyState left = new MyState(0.0,s,s.x-1,s.y);
		   MyState right = new MyState(0.0,s,s.x+1,s.y);
		   
	   }
	return goal;
	   
   }
}
   

import java.util.Comparator;
import java.util.TreeSet;
public class MyState implements Comparable<MyState> {
   public double cost;
   MyState parent;
   public int x;
   public int y;

   MyState(double cost, MyState par,int x,int y){
	   this.cost = cost;
	   this.parent = par;
	   this.x = x;
	   this.y = y;
   }
   public MyState(int x, int y){
	   this.x =x;
	   this.y = y;
   }
   public boolean isEqual(MyState goal){
	   if(this.x == goal.x && this.y == goal.y)
		   return true;
	   else
		   return false;
	   
   }
   public void setEqual(MyState s){
	   this.x = s.x;
	   this.y = s.y;
	   this.parent = s.parent;
	   this.cost = s.cost;
   }

	public int compareTo(MyState e) {
		if(this.cost < e.cost)
			return -1;
		if(this.cost > e.cost)
			return 1;
		else return 0;
	}
}  


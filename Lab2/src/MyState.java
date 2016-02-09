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
	   if(this.equals(goal))
		   return true;
	   else
		   return false;
	   
   }
@Override
	public int compareTo(MyState e) {
		if(this.y < e.y) return -1;
		else if(this.y > e.y) return 1;
		else if(this.x < e.x) return -1;
		else if(this.x > e.x) return 1;
		else return 0;
	}
}  
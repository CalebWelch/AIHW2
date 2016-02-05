import java.util.Comparator;
import java.util.TreeSet;
public class MyState {
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
}
class MyNameComp implements Comparator<MyState>{
	public int compare(MyState e1, MyState e2) {
		if(e1.y < e2.y) return -1;
		else if(e1.y > e2.y) return 1;
		else if(e1.x < e2.x) return -1;
		else if(e1.x > e2.x) return 1;
		else return 0;
	}
}  
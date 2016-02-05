import java.util.PriorityQueue;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Set;
public class MyPlanner {
   public MyState ucs(MyState start, MyState goal){
// Load a image from a file
   BufferedImage image = ImageIO.read(new File("terrain.png"));

// Make a new image
   BufferedImage newimage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
	
// Read a pixel
   Color c = new Color(image.getRGB(, y));
   int greenChannel = c.getGreen();

// Set a pixel (0xAARRGGBB)
   image.setRGB(x, y, 0xff00ff00);

// Write the image to a PNG file
   ImageIO.write(image, "png", new File(outputFilePath));


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
		   
	   }
	   
   }
}
   

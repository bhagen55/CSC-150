
/*
 * Blair Hagen
 * Lab 2
 * 4-7-2016
 * 
 * As a student at Union College, I am part of a community that values intellectual effort, curiosity and discovery. I understand that in order to truly claim my educational and academic achievements, I am obligated to act with academic integrity. Therefore, I affirm that I will carry out my academic endeavors with full academic honesty, and I rely on my fellow students to do the same.
 * 
 * Draw and manipulate rectangles and practice using objects and modifying those objects.
 * 
 */

import CSLib.DrawingBox;
import java.awt.Rectangle;
import CSLib.OutputBox;

public class RectangleTester {

	public static void main(String[] args) {
		/*
		 * Experimenting with objects
		 */
		DrawingBox myBoard;
		myBoard = new DrawingBox();
		myBoard.setVisible(true);
		//myBoard.drawRect(320,230,120,180);
		
		// Using a rectangle object now:
		Rectangle myRect;
		myRect = new Rectangle(320, 230, 120, 180);
		myBoard.drawRect(myRect);
		
		// Growing the rectangle object
		myRect.grow(20,20);
		myBoard.drawRect(myRect);
		
		// Translate
		myRect.translate(280, -50);
		myBoard.drawRect(myRect);
		
		// Set location
		myRect.setLocation(75, 250);
		myBoard.drawRect(myRect);
		
		// Set location and set size
		myRect.setLocation(75, 50);
		myRect.setSize(200, 150);
		myBoard.drawRect(myRect);
		
		
		/*
		 * Putting it all together
		 */
		DrawingBox newBoard;
		Rectangle Rect1;
		Rectangle Rect2;
		
		newBoard = new DrawingBox();
		newBoard.setVisible(true);
		
		Rect1 = new Rectangle(50, 180, 120, 180);
		Rect2 = new Rectangle(100, 240, 150, 200);
		
		// Draw both rectangles
		newBoard.drawRect(Rect1);
		newBoard.drawRect(Rect2);
		
		// Determining if they intersect
		
		OutputBox intersectResultBox;
		intersectResultBox = new OutputBox();
		
		if (Rect1.intersects(Rect2) == true)
		{
			intersectResultBox.println("They do intersect");
		}
		else
		{
			intersectResultBox.println("They do not intersect");
		}
		
		// Create a union box
		Rectangle unionRect;
		unionRect = new Rectangle();
		unionRect = Rect2.union(Rect1);
		newBoard.drawRect(unionRect);
		
		// Proving the bounding rectangle
		if (unionRect.contains(Rect1) == true && unionRect.contains(Rect2) == true)
		{
			intersectResultBox.print("The union box contains Rectangle 1 and Rectangle 2");
		}
		else
		{
			intersectResultBox.print("The union box does not contain either Rectangle 1 or Rectangle 2");
		}
		
	}

}

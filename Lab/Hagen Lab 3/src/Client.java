/**
 * Main client class
 * 
 * As a student at Union College, I am part of a community that values intellectual effort, curiosity and discovery. I understand that in order to truly claim my educational and academic achievements, I am obligated to act with academic integrity. Therefore, I affirm that I will carry out my academic endeavors with full academic honesty, and I rely on my fellow students to do the same.
 * 
 * @author Blair Hagen
 * @version 4-14-2016
 */
import CSLib.DrawingBox;
import Second.Block;

public class Client {
	public static void main(String[] args) {
		
		DrawingBox mainDrawBox = new DrawingBox();
		
		Block defBlock = new Block();
		Block cusBlock = new Block(100 ,250);
		defBlock.display(mainDrawBox);
		cusBlock.display(mainDrawBox);
		
		defBlock.setPosition(300, 175);
		defBlock.display(mainDrawBox);
		
		cusBlock.setPosition(200, 400);
		cusBlock.display(mainDrawBox);
		
		defBlock.setPosition(700, 200);
		defBlock.setDimensions(defBlock.getWidth() * 2, defBlock.getHeight(), defBlock.getDepth() * 2);
		defBlock.display(mainDrawBox);
		
		
		DrawingBox secondDrawBox = new DrawingBox();
		Block blockArray[] = new Block[5];
		
		for (int i = 1; i <= blockArray.length; i++)
		{
			blockArray[i - 1] = new Block(100, 100 * i);
			blockArray[i - 1].display(secondDrawBox);
		}
	}
}

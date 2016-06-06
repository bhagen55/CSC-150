package original;
/**
 * Represents three-dimensional blocks
 * 
 * @author Blair Hagen
 * @version 4-14-2016
 *
 */
import CSLib.DrawingBox;


public class Block {
	
	private int width;
	private int height;
	private int depth;
	private int xcoord;
	private int ycoord;
	
	private static int DEFAULT_WIDTH = 50;
	private static int DEFAULT_HEIGHT = 50;
	private static int DEFAULT_DEPTH = 10;
	private static int DEFAULT_XCOORD = 100;
	private static int DEFAULT_YCOORD = 100;
	
	
	/**
	 * Default constructor.
	 * Creates block based on default values.
	 */
	public Block() {
		
		width = DEFAULT_WIDTH;
		height = DEFAULT_HEIGHT;
		depth = DEFAULT_DEPTH;
		xcoord = DEFAULT_XCOORD;
		ycoord = DEFAULT_YCOORD;
		
	}
	
	/**
	 * Creates block at inputted x/y coord with
	 * default size.
	 */
	public Block(int xcoord, int ycoord) {
		
		width = DEFAULT_WIDTH;
		height = DEFAULT_HEIGHT;
		depth = DEFAULT_DEPTH;
		this.xcoord = xcoord;
		this.ycoord = ycoord;
		
	}
	
	/**
	 * Getter for box width
	 * 
	 * @return width
	 * 		The width of the box
	 */
	public int getWidth() {
		return(width);
	}
	
	/**
	 * Getter for box height
	 * 
	 * @return height
	 * 		The height of the box
	 */
	public int getHeight() {
		return(height);
	}
	
	/**
	 * Getter for box depth
	 * 
	 * @return depth
	 * 		The depth of the box
	 */
	public int getDepth() {
		return(depth);
	}
	
	/**
	 * Getter for box x-coord
	 * 
	 * @return xcoord
	 * 		The x-coordinate of the box
	 */
	public int getXCoord() {
		return(xcoord);
	}
	
	/**
	 * Getter for box y-coord
	 * 
	 * @return ycoord
	 * 		The y-coordinate of the box
	 */
	public int getYCoord() {
		return(ycoord);
	}
	
	
	/**
	 * Setter for box coordinates
	 * 
	 * @param xcoord
	 * 		Desired x-coordinate for box
	 * @param ycoord
	 * 		Desired y-coordinate for box
	 */
	public void setPosition(int xcoord, int ycoord) {
		this.xcoord = xcoord;
		this.ycoord = ycoord;
	}
	
	/**
	 * Setter for box dimensions
	 * 
	 * @param width
	 * 		Desired width for box
	 * @param height
	 * 		Desired height for box
	 * @param depth
	 * 		Desired depth for box
	 */
	public void setDimensions(int width, int height, int depth) {
		this.width = width;
		this.height = height;
		this.depth = depth;
	}
	
	
	/**
	 * Displays box in a given drawingbox
	 * 
	 * @param box
	 * 		Drawingbox to draw box in
	 */
	public void display(DrawingBox box) {
		for (int i = 0; i < depth; i++)
		{
			box.drawRect(getXCoord() + i*2, getYCoord() + i*2, getWidth(), getHeight());
		}
			
	}
}

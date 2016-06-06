
/**
 * The BenfordTester class contains methods for counting the number of times
 * the digits 0-9 appear at the beginning of a set of numbers and returning
 * them in different formats.
 * 
 * @author Blair Hagen
 * @version 4-7-2016
 * 
 * As a student at Union College, I am part of a community that values intellectual effort, curiosity and discovery. I understand that in order to truly claim my educational and academic achievements, I am obligated to act with academic integrity. Therefore, I affirm that I will carry out my academic endeavors with full academic honesty, and I rely on my fellow students to do the same.
 * 
 */


public class BenfordTester {

    private static final int MAX_DIGITS = 10;

    /**
     * An array keeping track of how often each digit occurs in the leading
     * position.
     */
    private int[] digits;

    /** The name of the data file that was last processed. **/
    private String filename;

    /**
     * This constructor creates a new BenfordTester object. The array of digits
     * is initialized to 0.
     */
    public BenfordTester() {
        digits = new int[MAX_DIGITS];
        for (int i = 0; i < digits.length; i++) {
            digits[i] = 0;
        }
    }

    

    /**
     * Counts the number of times the number n is the first digit in file
     * filename for all n=1...9.
     * 
     * Using Tokenizer, this method takes the first character in the token 
     * and converts it to a string then it converts that string to an integer.
     * The integer is used to find a position in a 10 slot array and then 
     * increase the contents of the slot by 1.
     * 
     * The global variable 'filename' is also set to the processed file's 
     * name at the end of the process.
     * 
     * @param filename
     *            the name of the data file that is to be processed
     */
    public void processFile(String filename) {
    	Tokenizer token = new Tokenizer(filename);
    	
    	for (int i = 0; i < digits.length; i++) 
    	{
            digits[i] = 0;
    	}
    	
    	String currentTokenStr;
    	boolean isTokenNull = false;
    	
    	while (isTokenNull == false)
    	{
    		currentTokenStr = token.nextToken();
    		
    		if (currentTokenStr == null)
    		{
    			isTokenNull = true;
    		}
    		
    		else
    		{
        		String firstStr = Character.toString(currentTokenStr.charAt(0));
        		int firstInt = Integer.parseInt(firstStr);
        		
        		int arrayVal = digits[firstInt];
        		int newArrayVal = arrayVal + 1;
        		digits[firstInt] = newArrayVal;
    		}
    	}
    	this.filename = filename;
    }

    
    /**
     * This function returns a string specifying the name of the file that was
     * last processed and how often each digit occurred in that file. If no file
     * has been processed, yet, it returns a message that says so.
     * 
     * @return resultStr
     * 			A string representation of the digits array with the filename at the start
     */
    public String toString() 
    {
    	if (filename == null)
    	{
    		return("No data file has been read, yet.");
    	}
    	else
    	{

    		String resultStr = 
        			(
        				filename + ":\n"
        				+ "0: " + digits[0] + "\n"
        				+ "1: " + digits[1] + "\n"
        				+ "2: " + digits[2] + "\n"
        				+ "3: " + digits[3] + "\n"
        				+ "4: " + digits[4] + "\n"
        				+ "5: " + digits[5] + "\n"
        				+ "6: " + digits[6] + "\n"
        				+ "7: " + digits[7] + "\n"
        				+ "8: " + digits[8] + "\n"
        				+ "9: " + digits[9] + "\n"
        			);
        		return(resultStr);
    	}
    }

    
    /**
     * Uses the array 'digits' to print a bar graph using asterisks representing the
     * frequency of the first digits. The parameter 'unitsPerAsterisk' allows you
     * to scale the output of the graph so that large amounts of data are easier
     * to see.
     *
     * @param unitsPerAsterisk
     * 					An integer that changes the scaling of the graph.
     * 					For example, if '2' is passed as the parameter,
     * 					then a graph of 10 asterisks will instead be 5.
     */
    public void graph(int unitsPerAsterisk) {
    	System.out.println("File: " + filename + "\nfrequency of the lead digit \n---------------------------");
    	
    	int arrayPos = 0;
    	
    	for (int value:digits)
    	{
    		double rawUnits = (double)value/(double)unitsPerAsterisk;
    		int actualUnits = (int)Math.round(rawUnits);
    		String asteriskStr = asteriskGenerator(actualUnits);
    		System.out.println(arrayPos + ": " + asteriskStr);
    		arrayPos++;
    	}
    }
    
    
    /**
     * Uses a number of units to build a string with asterisks.
     * Uses StringBuilder class from Java for convenience.
     * 
     * @param units
     * 			Number of desired asterisks in the string
     * @return a string of asterisks
     */
    private String asteriskGenerator(int units){
    	String asteriskStr;
    	StringBuilder strBuild = new StringBuilder();
    	for (int i = 0; i < units; i++)
    	{
    		strBuild.append("*");
    	}
    	asteriskStr = strBuild.toString();		
    	return (asteriskStr);
    }
}

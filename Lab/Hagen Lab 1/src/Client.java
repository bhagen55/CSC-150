// Blair Hagen
// Lab 1

// Honor Code: As a student at Union College, I am part of a community that values intellectual effort, curiosity and discovery. I understand that in order to truly claim my educational and academic achievements, I am obligated to act with academic integrity. Therefore, I affirm that I will carry out my academic endeavors with full academic honesty, and I rely on my fellow students to do the same.

/* Runs each of the methods in the Analyzer class in turn.
 * 
 */
public class Client {

	public static void main(String[] args) {
		Analyzer tester = new Analyzer();
		double min, max;
		double[] buyingData = new double[10];
		for(int i=0; i<buyingData.length; i++) {
			buyingData[i]=((long)(100*(Math.random()*100)))/100.0;
		}
		System.out.println("***PART 1 - numberCruncher");
		tester.numberCruncher();
        System.out.println("\n");
		
		min=9; max=50;  // change these to test
		System.out.println("###PART 2 - purchaseAnalyzer: min=" + min + "    max=" + max);
		tester.purchaseAnalyzer(buyingData, min, max);
        System.out.println("\n");
		
		min=8; max=85;  // change these to test
		System.out.println("^^^PART 3 - inDepthAnalyzer: min=" + min + "    max=" + max);
		tester.inDepthAnalyzer(buyingData, min, max);
		
		tester.printer(buyingData);
	}

}

/**
 * 
 * Main class to run the SolitaireSimulator a set
 * amount of times and return the results in a 
 * readable format.
 * 
 * @author Blair Hagen
 * @version 4-14-2016
 *
 */

public class Client {
	
	public static void main(String args[]) {
		
		int testVal = 1000;
		double percentWon = 0;
		int gamesWon = 0;
		
		SolitaireSimulator simulator = new SolitaireSimulator();
		while (testVal <= 10000)
		{
			for (int i = 1; i < testVal; i++)
			{
				simulator.resetDeck();
				boolean result = simulator.playGame();
				if (result == true)
				{
					gamesWon++;
				}
				
				percentWon = (double)gamesWon/testVal * 100;
			}
			System.out.println(gamesWon + "/" + testVal + " games won = " + Math.round(percentWon * 100.0) / 100.0 + "%");
			testVal += 1000;
		}
	}
}

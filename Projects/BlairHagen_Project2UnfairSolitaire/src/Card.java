/**
 * This is the card class, representing a single playing card.
 * It stores the suit and value.
 * It includes methods to return the values of the card as a string.
 * 
 * @author Blair Hagen
 * @version 4-14-2016
 *
 */
public class Card {
	
	private String cardSuit;
	private int cardValue;
	
	/**
	 * 
	 * Main constructor method for the Card class.
	 * 
	 * @param suit
	 * 		Takes the suit value as a string, accepts spades, hearts, diamonds, or clubs as an input
	 * @param value
	 * 		Takes a card value as an integer. Accepts integers >= 1 and <= 13. 
	 * 		11 stands for Jack, 12 for Queen, and 13 for king.
	 */
	public Card(String suit, int value) {
		
		if (suit.equals("spades") == false && suit.equals("hearts") == false && suit.equals("diamonds") == false && suit.equals("clubs") == false)
		{
			System.out.println("card suit input value not valid");
		}
		if (value < 1 || value > 13) 
		{
			System.out.println("card value input value not valid");
		}
		
		cardSuit = suit;
		cardValue = value;
	}
	
	
	/**
	 * 
	 * This method returns the value of a card as a string of certain format.
	 * The card values are replaced with Jack, Queen, or King if needed.
	 * 
	 * @return cardString
	 * 		String in the format 'card value' of 'card suit'	
	 */
	public String toString()
	{
		String cardString = convValueToRoyal(cardValue) + " of " + cardSuit.toUpperCase();
		return(cardString);
	}
	
	/**
	 * 
	 * Returns card suit
	 * 
	 * @return cardSuit
	 */
	public String cardSuit()
	{
		return(cardSuit);
	}
	
	/**
	 * 
	 * Converts the card value either to a string representation of an integer
	 * or to the royal string represented by the integer.
	 * 
	 * @param value
	 * 		The integer value of the card value
	 * @return
	 * 		A string representation of the card value
	 */
	private String convValueToRoyal(int value)
	{
		String royalValue = null;
		
		if (value > 1 && value <= 10)
		{
			royalValue = Integer.toString(value);
		}
		else
		{
			switch(value){
				case 1:	royalValue = "Ace";
						break;
				case 11: royalValue = "Jack";
						break;
				case 12: royalValue = "Queen";
						break;
				case 13: royalValue = "King";
						break;
				default: royalValue = null;
			}
		}
		
		return royalValue;
	}
}

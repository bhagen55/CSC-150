/**
 * This class stores the cards that a player is currently holding.
 * 
 * @author Blair Hagen
 * @version 4-22-2016
 *
 */
public class Hand {
	
	private String playerName;
	private Card hand[]; 
	
	private static int MAX_CARDS = 52;
	
	private int cardsInHand = 0;

	/**
	 * Main constructor method
	 * 
	 * @param playerName
	 * 		Name of player who holds deck
	 */
	public Hand(String playerName) {
		this.playerName = playerName;
		hand = new Card[MAX_CARDS];
	}
	
	
	
	/**
	 * Adds a card to players hand
	 * @param cardToAdd
	 * 		The card to be added to the hand
	 */
	public void addCard(Card cardToAdd) {
		hand[cardsInHand] = cardToAdd;
		cardsInHand++;
	}
	
	/**
	 * Removes a card from players hand
	 * @param cardToRemove
	 * 		Integer representing the card to remove
	 */
	public void removeCard(int cardIndexToRemove) {
		hand[cardIndexToRemove] = null;
		cardsInHand--;
		
		organizeDeck();
	}
	
	/**
	 * Returns the requested card but does not remove it.
	 * @param cardToSeek
	 * 		Integer representing the card to remove
	 * @return
	 * 		The requested card as a card object
	 */
	public Card seekCard(int cardIndexToSeek) {
		Card returnCard = hand[cardIndexToSeek];
		return(returnCard);
	}
	
	/**
	 * Returns the number of cards in a players hand
	 * @return
	 * 		Integer representing the number of cards in
	 * 		a players hand.
	 */
	public int size() {
		return(cardsInHand);
	}
	
	/**
	 * Returns the hand as a string representation
	 * @return
	 * 		The hand in string form
	 */
	public String toString() {
		StringBuilder strBuild = new StringBuilder();
		
		strBuild.append(playerName + "'s hand:\n\n");
		for (int i = 0; i < cardsInHand; i++)
		{
			strBuild.append(i + ") " + hand[i].toString() + "\n");
		}
		String returnStr = strBuild.toString();
		return(returnStr);
	}
	
	
	private void organizeDeck()
	{
		int index = 0;
		int firstIndex;
		int secondIndex;
		
		while (index != hand.length)
		{
			while (index < hand.length && hand[index] != null)
			{
				index++;
			}
			
			if (index != hand.length)
			{
				firstIndex = index;
				index++;
				
				while (index < hand.length && hand[index] == null)
				{
					index++;
				}
				if (index != hand.length)
				{
					secondIndex = index;
					hand[firstIndex] = hand[secondIndex];
					hand[secondIndex] = null;
				}
			}
		}
	}
	
	public String getOwner()
	{
		return(playerName);
	}
	
}

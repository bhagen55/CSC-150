/**
 * 
 * This class stores a deck of cards.
 * It keeps track of the cards to be dealt.
 * This class includes methods to deal the next card.
 * 
 * @author Blair Hagen
 * @version 4-22-2016
 *
 */
import java.util.Random;

public class Deck {
	
	private int CARDS_IN_DECK = 52;
	private String suits[] = {"spades", "hearts", "diamonds", "clubs"};
	private Card[] cardDeck;
	private int numOfCards;
	
	private int deckIndex = 0;
		
	/**
	 * 
	 * Main constructor method. Fills the array cardDeck with
	 * un-shuffled Card objects.
	 * 
	 */
	public Deck() {
		cardDeck = new Card[CARDS_IN_DECK];
		
		int cardIndex = 1;
		int suitStringIndex = 0;

		for (int i = 0; i < CARDS_IN_DECK; i++)
		{
			cardDeck[i] = new Card(suits[suitStringIndex], cardIndex);
			cardIndex++;
			
			if (cardIndex == 14)
			{
				cardIndex = 1;
				suitStringIndex++;
			}
		}
	}
	
	/**
	 * Constructor method for custom card amounts in deck
	 * @param numOfCards
	 * 		Desired number of cards in deck	
	 */
	public Deck(int numOfCards) {
		this.numOfCards = numOfCards;
		cardDeck = new Card[numOfCards];
		
		int cardIndex = 1;
		int deckIndex = 1;
		int suitStringIndex = 0;
		
		for (int i = 0; i < numOfCards; i++)
		{
			cardDeck[i] = new Card(suits[suitStringIndex], cardIndex);
			cardIndex++;
			
			if (cardIndex == 14)
			{
				cardIndex = 1;
				suitStringIndex++;
				deckIndex++;
			}
			if (deckIndex == 5)
			{
				cardIndex = 1;
				suitStringIndex = 0;
				deckIndex = 1;
			}
			
		}
	}
	/**
	 * 
	 * Returns the current cardDeck array as a string representation
	 * 
	 * @return cardStr
	 * 		A string representation of the cardDeck array
	 */
	public String toString(){
		String cardStr;
		StringBuilder strBuild = new StringBuilder();
		for (Card cardVal:cardDeck)
		{
			strBuild.append(cardVal.toString() + "\n");
		}
		cardStr = strBuild.toString();
		return (cardStr);
	}
	
	/**
	 * 
	 * Returns the next card to be dealt in the cardDeck array.
	 * Uses the instance variable deckIndex to keep track of what
	 * card is next to be dealt.
	 * 
	 * @return returnCard
	 * 		Card object to be dealt
	 */
	public Card deal(){
		Card returnCard;
		if (deckIndex < CARDS_IN_DECK || deckIndex < numOfCards)
		{
			returnCard = cardDeck[deckIndex];
			deckIndex++; 
		}
		else
		{
			returnCard = null;
		}
		return(returnCard);
	}
	
	/**
	 * 
	 * Shuffles the main cardDeck array.
	 * 
	 */
	public void shuffle(){
		Random rand = new Random();
		
		for (int i = 0; i < CARDS_IN_DECK; i++)
		{
			int randomIndex = rand.nextInt(CARDS_IN_DECK - i) + i;
			
			Card sourceCard = cardDeck[i];
			Card targetCard = cardDeck[randomIndex];
			cardDeck[i] = targetCard;
			cardDeck[randomIndex] = sourceCard;
		}
		
	}
	
	/**
	 * 
	 * Resets the deck index
	 * 
	 */
	public void reset()
	{
		deckIndex = 0;
	}
	
	/**
	 * Returns the next card in the deck without removing it.
	 * @return
	 * 		The next card in the deck
	 */
	public Card nextCard()
	{
		return(cardDeck[deckIndex]);
	}
	
	/**
	 * Getter method for index of deck
	 * @return	deckIndex
	 * 		Current index of the deck 
	 *
	 */
	public int getIndex()
	{
		return(deckIndex);
	}
	
	/**
	 * Returns the number of cards left in the deck
	 */
	public int cardsLeft()
	{
		int cardsLeft = CARDS_IN_DECK - deckIndex;
		return(cardsLeft);
	}
}


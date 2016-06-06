/**
 * 
 * Main class to handle simulations of the solitaire game.
 * Stores a deck of cards and an array of face up cards as
 * well as the total number of cards face-up.
 * 
 * @author Blair Hagen
 * @version 4-14-2016
 *
 */
public class SolitaireSimulator {
	
	private Deck mainDeck;
	private Card faceUpCards[];
	private int numFaceUpCards;
	
	private int CARDS_IN_DECK = 52;
	
	
	/**
	 * Main construction method
	 */
	public SolitaireSimulator()
	{
		mainDeck = new Deck();
		faceUpCards = new Card[CARDS_IN_DECK];
		numFaceUpCards = 0;
	}
	
	
	/**
	 * 
	 * Plays the game.
	 * Deals four cards to start.
	 * 
	 * @return isGameWon
	 * 		Whether the game was won or not.
	 */
	public boolean playGame()
	{	
		dealCards(4); // Deal first four cars
		
		boolean isGameWon;
		
		Card nextCard = mainDeck.deal();
		while(nextCard != null) // Main game loop
		{			
			if(numFaceUpCards < 4)
			{
				faceUpCards[numFaceUpCards] = nextCard;
				numFaceUpCards++;
			}
			else if(isFourSuitEqual(faceUpCards[numFaceUpCards-1], faceUpCards[numFaceUpCards-2], faceUpCards[numFaceUpCards-3], faceUpCards[numFaceUpCards-4]))
			{
				removeCards(1, 4); // Remove 4 cards
			}
			else if(isTwoSuitEqual(faceUpCards[numFaceUpCards - 1], faceUpCards[numFaceUpCards - 4]))
			{
				removeCards(2, 3); // Remove inside and outside cards
			}
			else
			{
				faceUpCards[numFaceUpCards] = nextCard;
				numFaceUpCards++;
			}
			nextCard = mainDeck.deal();
		}
		

		if(numFaceUpCards == 0)
		{
			isGameWon = true;
		}
		else
		{
			isGameWon = false;
		}
		
		return(isGameWon);
	}
	
	
	/**
	 * Shuffles the deck, resets the deck index,
	 * resets the face up cards index, and sets number
	 * of face up cards to 0.
	 */
	public void resetDeck()
	{
		mainDeck.shuffle();
		mainDeck.reset();
		numFaceUpCards = 0;
		for (int i = 0; i < faceUpCards.length; i++)
		{
			faceUpCards[i] = null;
		}	
	}
	
	
	/**
	 * 
	 * Moves all of the cards in the face up card array to the beginning and removes
	 * null 'spaces' between cards.
	 * 
	 */
	private void organizeDeck()
	{
		int index = 0;
		int firstIndex;
		int secondIndex;
		
		while (index != CARDS_IN_DECK)
		{
			while (index < CARDS_IN_DECK && faceUpCards[index] != null)
			{
				index++;
			}
			
			if (index != CARDS_IN_DECK)
			{
				firstIndex = index;
				index++;
				
				while (index < CARDS_IN_DECK && faceUpCards[index] == null)
				{
					index++;
				}
				if (index != CARDS_IN_DECK)
				{
					secondIndex = index;
					faceUpCards[firstIndex] = faceUpCards[secondIndex];
					faceUpCards[secondIndex] = null;
				}
			}
		}
	}
	
	
	/**
	 * 
	 * Returns whether the suit of four cards is the same or not
	 * 
	 * @return isSame
	 * 		Represents whether the suit is the same or not.
	 */
	private boolean isFourSuitEqual(Card firstCard, Card secondCard, Card thirdCard, Card fourthCard)
	{
		String firstCardSuit = firstCard.cardSuit();
		String secondCardSuit = secondCard.cardSuit();
		String thirdCardSuit = thirdCard.cardSuit();
		String fourthCardSuit = fourthCard.cardSuit();
		
		boolean isEqual;
		if (firstCardSuit.equals(secondCardSuit) && firstCardSuit.equals(thirdCardSuit) && firstCardSuit.equals(fourthCardSuit))
		{
			isEqual = true;
		}
		else
		{
			isEqual = false;
		}
		
		return(isEqual);
	}
	
	/**
	 * 
	 * Returns whether the suit of two cards is the same or not
	 * 
	 * @return isSame
	 * 		Represents whether the suit is the same or not.
	 * 
	 */
	private boolean isTwoSuitEqual(Card firstCard, Card secondCard)
	{
		String firstCardSuit = firstCard.cardSuit();
		String secondCardSuit = secondCard.cardSuit();
		
		boolean isEqual;
		if (firstCardSuit.equals(secondCardSuit))
		{
			isEqual = true;
		}
		else
		{
			isEqual = false;
		}
		
		return(isEqual);
	}
	
	/**
	 * 
	 * Deals cards based on given integer.
	 * If there is no card to be dealt, returns null.
	 * 
	 * @return isCardNull
	 * 		Whether the next dealt card is null.
	 * @param numOfCards
	 * 		Number of desired cards to be dealt.
	 */
	private boolean dealCards(int numOfCards)
	{
		boolean isCardNull = false;
		Card nextCard;
		for (int i = 0; i < numOfCards; i++)
		{
			nextCard = mainDeck.deal();
			if (nextCard == null)
			{
				isCardNull = true;
			}
			else
			{
				faceUpCards[i] = nextCard;
				numFaceUpCards++;
			}
		}
		
		return(isCardNull);
	}
	
	/**
	 * 
	 * Removes cards based on given integer.
	 * Organizes deck after removal.
	 * 
	 * @param numOfCards
	 * 		Number of desired cards to be removed
	 */
	private void removeCards(int startIndex, int endIndex)
	{
		for (int i = startIndex; i <= endIndex; i++)
		{
			faceUpCards[numFaceUpCards - i] = null;
		}
		
		numFaceUpCards = numFaceUpCards - (endIndex + 1 - startIndex);
		
		organizeDeck();
	}
}

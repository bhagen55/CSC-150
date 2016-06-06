/**
 * Plays the game "Crazy Eights."
 * Asks for number of players and names.
 * Prints instructions on how to play the game
 * Deals 7 cards to each player.
 * Displays the name of the person who's turn it is and their hand.
 * Displays the face up card (crazy eights must have a suit assigned)
 * User can input what card to play, draw a card
 * If user draws a card, add it to their hand.
 * If user played a card and is valid, remove from their hand and add to deck.
 * If player no longer has any cards, announce winner and end game.
 * 
 * @author Blair Hagen
 * @version 4-22-2016
 *
 */
import java.util.Scanner;

public class CrazyEights {
	
	private int numOfPlayers;
	private String playerNames[];
	private int currentPlayer;
	private Hand playerHands[];
	private Deck mainDeck;
	private Card faceUpCard;
	private Card requestedCard;
	private int requestedCardIndex;
	
	public CrazyEights() {
		currentPlayer = 0;
		numOfPlayers = 0;
		mainDeck = new Deck(104);
	}
		
	public void playGame() {
		Scanner scanner = new Scanner(System.in);
		
		// Shuffle the deck
		mainDeck.shuffle();
		
		// Ask for number of players
		String rawInput;
		while (numOfPlayers == 0  || numOfPlayers > 14)
		{
			System.out.print("Enter number of players: ");
			rawInput = scanner.next();
			numOfPlayers = Integer.parseInt(rawInput);
			if (numOfPlayers > 14){
				System.out.println("*****Too many players entered. 14 is the max. Please try again.*****");
			}
		}
		
		// Ask for names of players
		playerNames = new String[numOfPlayers];
		for (int i = 0; i < numOfPlayers; i++)
		{
			System.out.print("Enter name of player " + (i+1) + ": ");
			rawInput = scanner.next();
			playerNames[i] = rawInput;
		}

		// Initialize the player hands
		playerHands = new Hand[numOfPlayers];
		for (int i = 0; i < numOfPlayers; i++)
		{
			playerHands[i] = new Hand(playerNames[i]);
		}
		
		// Deal 7 cards to players decks to start
		for (Hand hand:playerHands)
		{
			System.out.println(hand.getOwner());
			for (int i = 0; i < 7; i++)
			{
				hand.addCard(mainDeck.deal());
			}
		}
		
		// Deal one card for face up card
		faceUpCard = mainDeck.deal();

		
		// Print instructions
		System.out.println("\n\nHow to play Crazy Eights:\n"
				+ "			\n This game is played with two decks of cards."
				+ "			\n Each player is dealt seven cards to start, and one"
				+ "			\n card is placed face up. Each player must play a"
				+ "			\n card that matches either the suit or value of the"
				+ "			\n face up card. If the player has a card with the"
				+ "			\n value of 8, they may choose which suit that card"
				+ "			\n will act as. The game is won if any player gets"
				+ "			\n rid of all of their cards, and the game is tied"
				+ "			\n if there is no more card in the deck.");
		
		// Main game loop
		while (emptyHandOwner() == null && mainDeck.cardsLeft() != 0 && numOfPlayers < 15)
		{	
			System.out.println("\n-------------------------------------");
			System.out.println("It is " + playerNames[currentPlayer] + "'s turn");
			System.out.println(playerHands[currentPlayer].toString());
			
			System.out.println("Face Up Card: " + faceUpCard.toString());
			if (faceUpCard.cardValue() == 8)
			{
				if (faceUpCard.getSecondarySuit() != null)
				{
					System.out.println("(but is acting as " + faceUpCard.getSecondarySuit().toUpperCase() + ")");
				}
			}
			
			System.out.println("Choose a number to play a card, or enter 'd' to draw or 'p' to pass.");
	
			rawInput = scanner.next();
			// Check if user wants to pass
			if (rawInput.equals("p"))
			{
				currentPlayer++;
			}
			// Check if user wants to deal a card
			else if (rawInput.equals("d"))
			{
				Card dealtCard = mainDeck.deal();
				System.out.println("Card added to " + playerNames[currentPlayer] + "'s deck: " + dealtCard.toString());
				playerHands[currentPlayer].addCard(dealtCard);
			}
			// Check that input is within the cards in the users hand
			else if (Integer.parseInt(rawInput) >= 0 && Integer.parseInt(rawInput) <= playerHands[currentPlayer].size() - 1)
			{
				requestedCardIndex = Integer.parseInt(rawInput);
				requestedCard = playerHands[currentPlayer].seekCard(requestedCardIndex);
				
				//Crazy eight suit choosing
				if (requestedCard.cardValue() == 8)
				{
					System.out.println("*****Crazy Eight!*****");
					System.out.println("Choose a suit: \nh) hearts\nd) diamonds\ns) spades\nc) clubs");
					rawInput = scanner.next();
					if (convertRawString(rawInput).equals(faceUpCard.cardSuit()) && rawInput.equals("h") || rawInput.equals("d") || rawInput.equals("s") || rawInput.equals("c"))
					{
						String eightCardSuit = convertRawString(rawInput);
						requestedCard.secondaryCardSuit(eightCardSuit);
						moveCardToFaceUp();
					}
					else
					{
						System.out.println("*****Invalid input, please try again*****");
					}
				}
				// If the card isn't a crazy eight
				else if (requestedCard.cardValue() != 8 || requestedCard.getSecondarySuit() == null)
				{
					int faceUpCardValue;
					String faceUpCardString;
					
					// If the face up card is a crazy eight
					if (faceUpCard.cardValue() == 8 && requestedCard.getSecondarySuit() != null)
					{
						faceUpCardValue = faceUpCard.cardValue();
						faceUpCardString = faceUpCard.getSecondarySuit();
					}
					// If its not a crazy eight
					else
					{
						faceUpCardValue = faceUpCard.cardValue();
						faceUpCardString = faceUpCard.cardSuit();
					}
					
					// Checking if a card works
					if (requestedCard.cardSuit().equals(faceUpCardString) || requestedCard.cardValue() == faceUpCardValue)
					{
						moveCardToFaceUp();
					}
					else
					{
						System.out.println("\n\n*****This card does not work, please try again*****");
					}
				}
			
				// If card matches the crazy eight chosen value
				else if (faceUpCard.cardValue() == 8 && faceUpCard.getSecondarySuit().equals(requestedCard.cardSuit()))
				{
					//System.out.println("Entered crazy eight value choosing");
					moveCardToFaceUp();
				}
				
				// If the card does not match the suit or value of the face up card
				else
				{
					System.out.println("*****This card does not work, please try again*****");
				}
				
			}
			// Catch all for incorrect input
			else
			{
				System.out.println("*****Invalid input, please try again*****");
			}
			
			// Loop back to player one if reached last player
			if (currentPlayer == numOfPlayers) 
			{
				currentPlayer = 0;
			} 
			
			// Catch a winning condition
			String emptyOwner = emptyHandOwner();
			if (emptyHandOwner() != null)
			{
				System.out.println("*****" + emptyOwner + " HAS WON THE GAME! Congratulations!*****");
			}
			// Catch a draw condition
			else if (mainDeck.cardsLeft() == 0 )
			{
				System.out.println("*****THE GAME IS A DRAW*****");
			}
		}
	scanner.close();
	}
	
	
	
	/**
	 * 
	 * Check to see if any hands are empty and returns the name of the empty hand owner
	 * 
	 * @return emptyHand
	 * 		Name of empty hand owner, null if none exist
	 * 
	 */
	private String emptyHandOwner() {
		String winnerName = null;
		for (Hand hand:playerHands)
		{
			if (hand.size() == 0)
			{
				winnerName = hand.getOwner();
			}
		}
		return(winnerName);
	}
	
	/**
	 * 
	 * Convert crazy eight raw input to actual card suit
	 * 
	 * @param rawInput
	 * 		Single string representation of card suit
	 */
	private String convertRawString(String rawInput) {
		String returnString = null;
		if (rawInput.equals("h"))
		{
			returnString = "hearts";
		}
		else if (rawInput.equals("d"))
		{
			returnString = "diamonds";
		}
		else if (rawInput.equals("s"))
		{
			returnString = "spades";
		}
		else if (rawInput.equals("c"))
		{
			returnString = "clubs";
		}
		return(returnString);
	}
	
	/**
	 * 
	 * Removes requested card from players hand and makes it the face up card
	 * ALSO checks if the player has one card left in the deck and PRINTS a 
	 * message if so.
	 *
	 */
	private void moveCardToFaceUp()  {
		playerHands[currentPlayer].removeCard(requestedCardIndex);
		faceUpCard = requestedCard;
	
		if (playerHands[currentPlayer].size() == 1)
		{
			System.out.println("*****" + playerNames[currentPlayer] + " has only one card left!*****");
		}
		currentPlayer++;
	}
}
		
package Week6;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Deck {
	//String name = new
	//public static void main(String[] args) {
	public Deck() {
		// TODO Auto-generated constructor stub		
	
	public Deck(List<Card> card) {
		List<Card> cards = new ArrayList<Card>();
	
		int D=2;
		int H=2;
		int S=2;
		int C=2;
		String topcard = " ";
	
		for(int i=0; i<=51; i++) {	
			if (i<=12) { 
				cards.add(new Card(D,"Diamond"));
				D++;
			}
			else {
				if (i > 12 && i<=25 ) {			
					cards.add(new Card(H, "Hearts"));	
				H++;
				}
			
				else if (i >25 &&  i<= 38) {
					cards.add(new Card(S, "Spades"));
					S++;
						} 
			
					else {
						cards.add(new Card(C, "Clubs"));
						C++;
					}
				}
	
		}
		System.out.println("Deck before shuffle ");
		for (Card b : cards) {
						
			System.out.println(b.value +" "+ b.name);
			}
		
		
		//firstcard(cards);
//		System.out.println("Top card is " + cards.get(0));
//		
		System.out.println("Deck after shuffle ");
		shufflecards(cards);
		
//		for (Card e: cards) {
//		System.out.println("Top card is " + a);
//		}
		
//		for(Card c  : cards) {
//			System.out.println(c.showCard());
//		}
	
	
}		
	
	
	
	}


	private static void shufflecards(List<Card> cards) {
		Collections.shuffle(cards);
		for (Card a : cards) {
		System.out.println(a.value + " "+ a.name);
			
		}	
	}
		
		
	
		
		
					

}
package Week6;

import java.util.ArrayList;
import java.util.List;

public class Player {

		private List<Card> hand = new ArrayList<Card>();
       private int score;
		private String name;


public List<Card> getHand() {
			return hand;
		}


		public void setHand(List<Card> hand) {
			this.hand = hand;
		}


		public int getScore() {
			return score;
		}


		public void setScore(int score) {
			this.score = score;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}
		
		//describe()
		//flip() get TOp one
		//draw() assigns 26 cards to each player
		//incrementScore()
		//score++ 


public Player(String name) {
	this.name = name;
	score = 0;
}
	private static void describe () {
		
		
	}

}



package Week6;

import java.util.List;

public class Card {
	public String name; //{"Spades", "Hearts", "Diamonds", "Clubs"};
    public int value; //{2,3,4,5,6,7,8, 9,10, 11, 12, 13, 14};
   
    public Card(int value, String name) {
    	this.value= value;
    	this.name = name;
    	 	
    }
    
        public  int getValue() {
    	return this.value;
    }
    
    public void setVAlue(int value) {
    	this.value = value;
    }
    public  String getName() {
    	return this.name;
    }
    
    public void setName(String name) {
    	this.name = name;
    }
    
    public String showCard() {
    	return "the card is " + value + " " + name;
    }

}

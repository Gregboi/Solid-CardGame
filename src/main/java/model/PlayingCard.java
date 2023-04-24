package model;

public class PlayingCard {
    Rank rank;
    Suit suit;
    boolean faceUp;

//Constructor
    public PlayingCard (Rank r, Suit s) {
        rank = r;
        suit = s;
        faceUp = false;
    }
    //Getters no setters, because we don't want to change a card after picked
    public Rank getRank(){
        return rank;
    }

    public Suit getSuit(){
        return suit;
    }

    // Create Getters
    // face up attribute tells us direction card is facing
    public boolean isFaceUp(){
        return faceUp;
    }

    // Create Setters
    public boolean flip(){
        faceUp = !faceUp;
        return faceUp;
    }
}

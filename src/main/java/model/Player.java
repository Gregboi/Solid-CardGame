package model;

public class Player {
    String name;
    Hand hand;

    public Player (String name) {
        this.name = name;
        hand = new Hand();
    }
}

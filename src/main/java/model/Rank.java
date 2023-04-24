package model;

public enum Rank {
    //first we need to assign an integers value to each value
    //we want to convert an enumeration to an integer
    TWO (2),
    THREE (3),
    FOUR (4),
    FIVE (5),
    SIX (6),
    SEVEN (7),
    EIGHT (8),
    NINE (9),
    JACK (10),
    QUEEN (11),
    KING (12),
    ACE (13);

    int rank;

    private Rank(int value) {
        rank = value;
    }

    public int value(){
        return rank;
    }
}

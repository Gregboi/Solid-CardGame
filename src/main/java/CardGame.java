import controller.GameController;

import javax.swing.text.View;

public class CardGame{
    public static void main(String[] args) {
        GameController gc = new GameController(new View(), new Deck());
    }
}
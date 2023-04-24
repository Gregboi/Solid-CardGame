package controller;
import model.Player;
import model.PlayingCard;

import java.util.ArrayList;

class View{
    public void something() {}
    public void setController(GameController gc) {}
};

public class GameController {
    enum GameState {
        AddingPlayers,
        CardsDealt,
        WinnerRevealed
    }

    Deck deck;
    ArrayList<Player> players;
    Player winner;
    View view;
    GameState gameState;

    //View method
    public GameController (GameViewable view, Deck deck) {
        this.view = view;
        this.deck = deck;
        players = new ArrayList<Player>();
        gameState = GameState.AddingPlayers;
        view.setController(this);
    }

    public void run() {
        while (true) {
            switch (gameState) {
                case AddingPlayers:
                    view.something();
                    break;
                case CardsDealt:
                    view.something();
                    break;
                case WinnerRevealed:
                    view.something();
                    break;
            }
        }
    }

    public void addPlayer(String playerName){
        if(gameState == GameState.AddingPlayers){
            players.add(new Player (playerName));
            view.showPlayerName(players.size(), playerName);
        }
    }
    public void startGame(){
        if (gameState != GameState.CardsDealt){
            deck.Shuffle();
            int playerIndex = 1;
            for (Player player : players){
                player.addCardToHand(deck.removeTopCard());
                view.something();
            }
            gameState = GameState.CardsDealt;
        }
    }

    public void flipCards(){
        int playerIndex =1;
        for (Player player : players) {
            PlayingCard pc = player.getCard(0);
            pc.flip();
            view.showCardForPlayer(playerIndex++, player.getName(),
                    pc.getRank().toString(), pc.getSuit().toString());
        }

        evaluateWinner();
        displayWinner();
        rebuildDeck();
        gameState = GameState.WinnerRevealed;
    }

    void evaluateWinner(){
        Player bestPlayer = null;
        int bestRank = -1;
        int bestSuit = -1;

        for (Player player : players){
            boolean newBestPlayer = false;

            if (bestPlayer == null) {
                newBestPlayer = true;
            }

            else {
                PlayingCard pc = player.getCard(0);
                int thisRank = pc.getRank().value();
                if (thisRank > bestRank) {
                    if (thisRank > bestRank) {
                        newBestPlayer = true;
                    } else {
                        if (pc.getSuit().value() > bestSuit) {
                            newBestPlayer = true;
                        }
                    }
                }
            }

            if (newBestPlayer) {
                bestPlayer = player;
                PlayingCard pc = player.getCard(0);
                bestRank = pc.getRank().value();
                bestSuit = pc.getSuit().value();
            }
        }
        winner = bestPlayer;
    }

    void displayWinner(){
        view.something();
    }

    void rebuildDeck(){
        for (Player player : players){
            deck.returnCardToDeck(player.removecard());
        }
    }
}

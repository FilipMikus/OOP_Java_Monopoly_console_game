package sk.stuba.fei.uim.oop.monopoly.game.objects;

import sk.stuba.fei.uim.oop.monopoly.game.objects.cards.ChanceCardDeck;
import sk.stuba.fei.uim.oop.monopoly.game.objects.tiles.Tile;
import sk.stuba.fei.uim.oop.monopoly.game.objects.tiles.special.*;

import java.util.ArrayList;

public class Board {
    private final ArrayList<Tile> board;
    private final ChanceCardDeck chanceCardDeck;

    public Board() {
        chanceCardDeck = new ChanceCardDeck();
        board = new ArrayList<>(24);
        board.add(new Start("Start", 0));
        board.add(new Property("Mediterranean avenue", 1, 60));
        board.add(new Property("Baltic avenue", 2, 80));
        board.add(new Chance("Chance 1", 3, chanceCardDeck));
        board.add(new Property("Oriental avenue", 4, 100));
        board.add(new Property("Connecticut avenue", 5, 120));
        board.add(new Police("Police", 6));
        board.add(new Property("St.Charles place", 7, 140));
        board.add(new Property("Virginia avenue", 8, 160));
        board.add(new Chance("Chance 2", 9, chanceCardDeck));
        board.add(new Property("Hennessy avenue", 10, 180));
        board.add(new Property("New York avenue", 11, 200));
        board.add(new IncomeTax("Income tax", 12, 500));
        board.add(new Property("Kentucky avenue", 13, 220));
        board.add(new Property("Illinois avenue", 14, 240));
        board.add(new Chance("Chance 3", 15, chanceCardDeck));
        board.add(new Property("Atlantic avenue", 16, 260));
        board.add(new Property("Marvin gardens", 17, 280));
        board.add(new Jail("Jail", 18));
        board.add(new Property("Pacific avenue", 19, 300));
        board.add(new Property("Pennsylvania avenue", 20, 320));
        board.add(new Chance("Chance 4", 21, chanceCardDeck));
        board.add(new Property("Park place", 22, 350));
        board.add(new Property("Boardwalk", 23, 400));
    }

    public Tile getTile(int indexOfTile) {
        return board.get(indexOfTile);
    }
}

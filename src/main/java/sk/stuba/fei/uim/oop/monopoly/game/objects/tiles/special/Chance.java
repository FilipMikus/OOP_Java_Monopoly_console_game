package sk.stuba.fei.uim.oop.monopoly.game.objects.tiles.special;

import sk.stuba.fei.uim.oop.monopoly.game.objects.cards.Card;
import sk.stuba.fei.uim.oop.monopoly.game.objects.cards.ChanceCardDeck;
import sk.stuba.fei.uim.oop.monopoly.game.objects.tiles.Tile;
import sk.stuba.fei.uim.oop.utility.ConsoleColors;

public class Chance extends Tile {
    private final ChanceCardDeck chanceCardDeck;

    public Chance(String name, int order, ChanceCardDeck chanceCardDeck) {
        super(name, order);
        this.chanceCardDeck = chanceCardDeck;
    }

    public Card getTopCard() {
        return this.chanceCardDeck.getTopCard();
    }

    @Override
    public String toString() {
        return (ConsoleColors.YELLOW + '[' + super.name + ']' + ConsoleColors.RESET);
    }
}

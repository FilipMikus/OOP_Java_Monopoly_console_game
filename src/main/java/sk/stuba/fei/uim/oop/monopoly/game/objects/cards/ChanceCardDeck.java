package sk.stuba.fei.uim.oop.monopoly.game.objects.cards;

import sk.stuba.fei.uim.oop.monopoly.game.objects.cards.specified.*;

import java.util.LinkedList;
import java.util.Queue;

public class ChanceCardDeck {
    private final Queue<Card> deck;

    public ChanceCardDeck() {
        deck = new LinkedList<>();
        deck.add(new BackThreeCard());
        deck.add(new DeathCard());
        deck.add(new GiftCard());
        deck.add(new StartCard());
        deck.add(new TaxCard());
    }

    public Card getTopCard() {
        Card card = deck.remove();
        deck.add(card);
        return card;
    }
}

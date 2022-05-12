package sk.stuba.fei.uim.oop.monopoly.game.objects.cards;

import sk.stuba.fei.uim.oop.monopoly.game.objects.Player;
import sk.stuba.fei.uim.oop.monopoly.game.exceptions.OutGameException;


public abstract class Card {
    protected String name;
    protected String description;

    public Card(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public abstract void makeAction(Player player) throws OutGameException;

    public abstract String cardToString();
}

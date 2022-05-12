package sk.stuba.fei.uim.oop.monopoly.game.objects.tiles.special;

import sk.stuba.fei.uim.oop.monopoly.game.objects.tiles.Tile;
import sk.stuba.fei.uim.oop.utility.ConsoleColors;

public class Jail extends Tile {

    public Jail(String name, int order) {
        super(name, order);
    }

    @Override
    public String toString() {
        return (ConsoleColors.BLUE_BRIGHT + '[' + super.getName() + ']' + ConsoleColors.RESET + "\nYou are only on visit.");
    }
}

package sk.stuba.fei.uim.oop.monopoly.game.objects.tiles.special;

import sk.stuba.fei.uim.oop.monopoly.game.objects.tiles.Tile;
import sk.stuba.fei.uim.oop.utility.ConsoleColors;

public class Start extends Tile {
    public Start(String name, int order) {
        super(name, order);
    }

    @Override
    public String toString() {
        return (ConsoleColors.YELLOW_BRIGHT + '[' + super.name + ']' + ConsoleColors.RESET);
    }
}

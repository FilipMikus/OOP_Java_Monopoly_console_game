package sk.stuba.fei.uim.oop.monopoly.game.objects.tiles.special;

import sk.stuba.fei.uim.oop.monopoly.game.objects.Player;
import sk.stuba.fei.uim.oop.monopoly.game.objects.tiles.Tile;
import sk.stuba.fei.uim.oop.utility.ConsoleColors;
import sk.stuba.fei.uim.oop.monopoly.game.exceptions.InJailException;

public class Police extends Tile {
    public Police(String name, int order) {
        super(name, order);
    }

    public void sendToJail(Player player, Jail jail) throws InJailException {
        player.setRoundsInJail(3);
        player.moveTo(jail.getOrder());
        player.setInJail();
    }

    @Override
    public String toString() {
        return (ConsoleColors.BLUE + '[' + super.name + ']' + ConsoleColors.RESET);
    }
}

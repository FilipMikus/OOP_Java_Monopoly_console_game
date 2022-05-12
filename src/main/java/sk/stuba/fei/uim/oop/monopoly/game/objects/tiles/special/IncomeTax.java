package sk.stuba.fei.uim.oop.monopoly.game.objects.tiles.special;

import sk.stuba.fei.uim.oop.monopoly.game.objects.Player;
import sk.stuba.fei.uim.oop.monopoly.game.objects.tiles.Tile;
import sk.stuba.fei.uim.oop.utility.ConsoleColors;
import sk.stuba.fei.uim.oop.monopoly.game.exceptions.OutGameException;

public class IncomeTax extends Tile {
    private final int taxValue;

    public IncomeTax(String name, int order, int taxValue) {
        super(name, order);
        this.taxValue = taxValue;
    }

    public void payIncomeTaxBy(Player player) throws OutGameException {
        player.reduceMoneyDepositBy(taxValue);
    }

    public int getTaxValue() {
        return taxValue;
    }

    @Override
    public String toString() {
        return (ConsoleColors.RED + '[' + super.name + ']' + ConsoleColors.RESET);
    }
}

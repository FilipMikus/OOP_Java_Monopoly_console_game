package sk.stuba.fei.uim.oop.monopoly.game.objects.tiles.special;

import sk.stuba.fei.uim.oop.monopoly.game.objects.Player;
import sk.stuba.fei.uim.oop.monopoly.game.objects.tiles.Tile;
import sk.stuba.fei.uim.oop.utility.ConsoleColors;
import sk.stuba.fei.uim.oop.monopoly.game.exceptions.OutGameException;

public class Property extends Tile {
    private boolean owned;
    private final int rentValue;
    private Player owner;

    public Property(String name, int order, int rentValue) {
        super(name, order);
        owned = false;
        owner = null;
        this.rentValue = rentValue;
    }

    public void buyBy(Player player) throws OutGameException {
        owned = true;
        owner = player;
        player.reduceMoneyDepositBy(rentValue);
        player.addProperty(this);
    }

    public void payPropertyRentBy(Player player) throws OutGameException {
        if (player.getDepositValue() < rentValue) {
            owner.increaseMoneyDepositBy(player.getDepositValue());
            player.reduceMoneyDepositBy(rentValue);
        }
        owner.increaseMoneyDepositBy(rentValue);
        player.reduceMoneyDepositBy(rentValue);
    }

    public void forFeiture() {
        owned = false;
        owner = null;
    }

    public boolean isOwned() {
        return owned;
    }

    public int getRent() {
        return rentValue;
    }

    public Player getOwner() {
        return owner;
    }

    @Override
    public String toString() {
        return (ConsoleColors.PURPLE + '[' + super.name + '-' + rentValue + "$]" + ConsoleColors.RESET);
    }
}

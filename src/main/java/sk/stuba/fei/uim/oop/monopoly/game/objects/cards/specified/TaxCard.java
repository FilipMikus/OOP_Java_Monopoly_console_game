package sk.stuba.fei.uim.oop.monopoly.game.objects.cards.specified;

import sk.stuba.fei.uim.oop.monopoly.game.objects.Player;
import sk.stuba.fei.uim.oop.monopoly.game.objects.cards.Card;
import sk.stuba.fei.uim.oop.utility.ConsoleColors;
import sk.stuba.fei.uim.oop.monopoly.game.exceptions.OutGameException;

public class TaxCard extends Card {
    private final int taxValue;

    public TaxCard() {
        super("Tax", "Pay the mandatory tax");
        this.taxValue = 200;
    }

    @Override
    public void makeAction(Player player) throws OutGameException {
        player.reduceMoneyDepositBy(taxValue);
    }

    @Override
    public String cardToString() {
        return (ConsoleColors.YELLOW_BACKGROUND + "                              " + ConsoleColors.RESET + "\n" +
                ConsoleColors.YELLOW_BACKGROUND + "   " + ConsoleColors.WHITE_BACKGROUND_BRIGHT + "                        " + ConsoleColors.YELLOW_BACKGROUND + "   " + ConsoleColors.RESET + "\n" +
                ConsoleColors.YELLOW_BACKGROUND + "   " + ConsoleColors.WHITE_BACKGROUND_BRIGHT + ConsoleColors.YELLOW_BOLD + "          TAX           " + ConsoleColors.YELLOW_BACKGROUND + "   " + ConsoleColors.RESET + "\n" +
                ConsoleColors.YELLOW_BACKGROUND + "   " + ConsoleColors.WHITE_BACKGROUND_BRIGHT + "                        " + ConsoleColors.YELLOW_BACKGROUND + "   " + ConsoleColors.RESET + "\n" +
                ConsoleColors.YELLOW_BACKGROUND + "   " + ConsoleColors.WHITE_BACKGROUND_BRIGHT + ConsoleColors.BLACK + " Pay the mandatory tax  " + ConsoleColors.YELLOW_BACKGROUND + "   " + ConsoleColors.RESET + "\n" +
                ConsoleColors.YELLOW_BACKGROUND + "   " + ConsoleColors.WHITE_BACKGROUND_BRIGHT + "                        " + ConsoleColors.YELLOW_BACKGROUND + "   " + ConsoleColors.RESET + "\n" +
                ConsoleColors.YELLOW_BACKGROUND + "                              " + ConsoleColors.RESET);
    }
}

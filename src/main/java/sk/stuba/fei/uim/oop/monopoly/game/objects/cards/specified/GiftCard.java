package sk.stuba.fei.uim.oop.monopoly.game.objects.cards.specified;

import sk.stuba.fei.uim.oop.monopoly.game.objects.Player;
import sk.stuba.fei.uim.oop.monopoly.game.objects.cards.Card;
import sk.stuba.fei.uim.oop.utility.ConsoleColors;

public class GiftCard extends Card {
    private final int giftValue;

    public GiftCard() {
        super("Gift", "You are receiving a gift from the bank");
        giftValue = 200;
    }

    @Override
    public void makeAction(Player player) {
        player.increaseMoneyDepositBy(giftValue);
    }

    @Override
    public String cardToString() {
        return (ConsoleColors.YELLOW_BACKGROUND + "                              " + ConsoleColors.RESET + "\n" +
                ConsoleColors.YELLOW_BACKGROUND + "   " + ConsoleColors.WHITE_BACKGROUND_BRIGHT + "                        " + ConsoleColors.YELLOW_BACKGROUND + "   " + ConsoleColors.RESET + "\n" +
                ConsoleColors.YELLOW_BACKGROUND + "   " + ConsoleColors.WHITE_BACKGROUND_BRIGHT + ConsoleColors.YELLOW_BOLD + "          GIFT          " + ConsoleColors.YELLOW_BACKGROUND + "   " + ConsoleColors.RESET + "\n" +
                ConsoleColors.YELLOW_BACKGROUND + "   " + ConsoleColors.WHITE_BACKGROUND_BRIGHT + "                        " + ConsoleColors.YELLOW_BACKGROUND + "   " + ConsoleColors.RESET + "\n" +
                ConsoleColors.YELLOW_BACKGROUND + "   " + ConsoleColors.WHITE_BACKGROUND_BRIGHT + ConsoleColors.BLACK + "    You are receiving   " + ConsoleColors.YELLOW_BACKGROUND + "   " + ConsoleColors.RESET + "\n" +
                ConsoleColors.YELLOW_BACKGROUND + "   " + ConsoleColors.WHITE_BACKGROUND_BRIGHT + ConsoleColors.BLACK + "  a gift from the bank  " + ConsoleColors.YELLOW_BACKGROUND + "   " + ConsoleColors.RESET + "\n" +
                ConsoleColors.YELLOW_BACKGROUND + "                              " + ConsoleColors.RESET);
    }
}

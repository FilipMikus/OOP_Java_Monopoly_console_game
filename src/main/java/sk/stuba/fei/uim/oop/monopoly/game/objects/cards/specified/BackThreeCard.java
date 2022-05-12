package sk.stuba.fei.uim.oop.monopoly.game.objects.cards.specified;

import sk.stuba.fei.uim.oop.monopoly.game.objects.Player;
import sk.stuba.fei.uim.oop.monopoly.game.objects.cards.Card;
import sk.stuba.fei.uim.oop.utility.ConsoleColors;

public class BackThreeCard extends Card {
    public BackThreeCard() {
        super("Go back", "Go back three spaces");
    }

    @Override
    public void makeAction(Player player) {
        player.moveTo(player.getPosition() - 3);
    }

    @Override
    public String cardToString() {
        return (ConsoleColors.YELLOW_BACKGROUND + "                              " + ConsoleColors.RESET + "\n" +
                ConsoleColors.YELLOW_BACKGROUND + "   " + ConsoleColors.WHITE_BACKGROUND_BRIGHT + "                        " + ConsoleColors.YELLOW_BACKGROUND + "   " + ConsoleColors.RESET + "\n" +
                ConsoleColors.YELLOW_BACKGROUND + "   " + ConsoleColors.WHITE_BACKGROUND_BRIGHT + ConsoleColors.YELLOW_BOLD + "        GO BACK         " + ConsoleColors.YELLOW_BACKGROUND + "   " + ConsoleColors.RESET + "\n" +
                ConsoleColors.YELLOW_BACKGROUND + "   " + ConsoleColors.WHITE_BACKGROUND_BRIGHT + "                        " + ConsoleColors.YELLOW_BACKGROUND + "   " + ConsoleColors.RESET + "\n" +
                ConsoleColors.YELLOW_BACKGROUND + "   " + ConsoleColors.WHITE_BACKGROUND_BRIGHT + ConsoleColors.BLACK + "  Go back three spaces  " + ConsoleColors.YELLOW_BACKGROUND + "   " + ConsoleColors.RESET + "\n" +
                ConsoleColors.YELLOW_BACKGROUND + "   " + ConsoleColors.WHITE_BACKGROUND_BRIGHT + "                        " + ConsoleColors.YELLOW_BACKGROUND + "   " + ConsoleColors.RESET + "\n" +
                ConsoleColors.YELLOW_BACKGROUND + "                              " + ConsoleColors.RESET);
    }
}

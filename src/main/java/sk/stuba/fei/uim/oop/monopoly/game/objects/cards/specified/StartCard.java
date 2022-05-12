package sk.stuba.fei.uim.oop.monopoly.game.objects.cards.specified;

import sk.stuba.fei.uim.oop.monopoly.game.objects.Player;
import sk.stuba.fei.uim.oop.monopoly.game.objects.cards.Card;
import sk.stuba.fei.uim.oop.utility.ConsoleColors;

public class StartCard extends Card {
    public StartCard() {
        super("Start", "Go to start");
    }

    @Override
    public void makeAction(Player player) {
        player.moveTo(0);
    }

    @Override
    public String cardToString() {
        return (ConsoleColors.YELLOW_BACKGROUND + "                              " + ConsoleColors.RESET + "\n" +
                ConsoleColors.YELLOW_BACKGROUND + "   " + ConsoleColors.WHITE_BACKGROUND_BRIGHT + "                        " + ConsoleColors.YELLOW_BACKGROUND + "   " + ConsoleColors.RESET + "\n" +
                ConsoleColors.YELLOW_BACKGROUND + "   " + ConsoleColors.WHITE_BACKGROUND_BRIGHT + ConsoleColors.YELLOW_BOLD + "         START          " + ConsoleColors.YELLOW_BACKGROUND + "   " + ConsoleColors.RESET + "\n" +
                ConsoleColors.YELLOW_BACKGROUND + "   " + ConsoleColors.WHITE_BACKGROUND_BRIGHT + "                        " + ConsoleColors.YELLOW_BACKGROUND + "   " + ConsoleColors.RESET + "\n" +
                ConsoleColors.YELLOW_BACKGROUND + "   " + ConsoleColors.WHITE_BACKGROUND_BRIGHT + ConsoleColors.BLACK + "      Go to start       " + ConsoleColors.YELLOW_BACKGROUND + "   " + ConsoleColors.RESET + "\n" +
                ConsoleColors.YELLOW_BACKGROUND + "   " + ConsoleColors.WHITE_BACKGROUND_BRIGHT + ConsoleColors.BLACK + "   without earn money   " + ConsoleColors.YELLOW_BACKGROUND + "   " + ConsoleColors.RESET + "\n" +
                ConsoleColors.YELLOW_BACKGROUND + "                              " + ConsoleColors.RESET);
    }
}

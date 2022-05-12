package sk.stuba.fei.uim.oop.monopoly.game.objects.cards.specified;

import sk.stuba.fei.uim.oop.monopoly.game.objects.Player;
import sk.stuba.fei.uim.oop.monopoly.game.objects.cards.Card;
import sk.stuba.fei.uim.oop.utility.ConsoleColors;
import sk.stuba.fei.uim.oop.monopoly.game.exceptions.OutGameException;

public class DeathCard extends Card {
    public DeathCard() {
        super("Death", "You're out of the game");
    }

    @Override
    public void makeAction(Player player) throws OutGameException {
        player.setOutGame();
    }

    @Override
    public String cardToString() {
        return (ConsoleColors.YELLOW_BACKGROUND + "                              " + ConsoleColors.RESET + "\n" +
                ConsoleColors.YELLOW_BACKGROUND + "   " + ConsoleColors.WHITE_BACKGROUND_BRIGHT + "                        " + ConsoleColors.YELLOW_BACKGROUND + "   " + ConsoleColors.RESET + "\n" +
                ConsoleColors.YELLOW_BACKGROUND + "   " + ConsoleColors.WHITE_BACKGROUND_BRIGHT + ConsoleColors.YELLOW_BOLD + "         DEATH          " + ConsoleColors.YELLOW_BACKGROUND + "   " + ConsoleColors.RESET + "\n" +
                ConsoleColors.YELLOW_BACKGROUND + "   " + ConsoleColors.WHITE_BACKGROUND_BRIGHT + "                        " + ConsoleColors.YELLOW_BACKGROUND + "   " + ConsoleColors.RESET + "\n" +
                ConsoleColors.YELLOW_BACKGROUND + "   " + ConsoleColors.WHITE_BACKGROUND_BRIGHT + ConsoleColors.BLACK + " You're out of the game " + ConsoleColors.YELLOW_BACKGROUND + "   " + ConsoleColors.RESET + "\n" +
                ConsoleColors.YELLOW_BACKGROUND + "   " + ConsoleColors.WHITE_BACKGROUND_BRIGHT + "                        " + ConsoleColors.YELLOW_BACKGROUND + "   " + ConsoleColors.RESET + "\n" +
                ConsoleColors.YELLOW_BACKGROUND + "                              " + ConsoleColors.RESET);
    }
}

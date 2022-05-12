package sk.stuba.fei.uim.oop.monopoly.game.exceptions;

import sk.stuba.fei.uim.oop.utility.ConsoleColors;

public class WinGameException extends Exception {
    public WinGameException(String winnerName) {
        super(ConsoleColors.GREEN_BOLD_BRIGHT + winnerName + " win the game!" + ConsoleColors.RESET);
    }
}

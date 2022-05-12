package sk.stuba.fei.uim.oop.monopoly.game.exceptions;

import sk.stuba.fei.uim.oop.utility.ConsoleColors;

public class OutGameException extends Exception {
    public OutGameException() {
        super(ConsoleColors.RED_BRIGHT + "YOU LOST!" + ConsoleColors.RESET);
    }
}

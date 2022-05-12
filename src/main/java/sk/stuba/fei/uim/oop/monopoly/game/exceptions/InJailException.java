package sk.stuba.fei.uim.oop.monopoly.game.exceptions;

import sk.stuba.fei.uim.oop.utility.ConsoleColors;

public class InJailException extends Exception {
    public InJailException() {
        super(ConsoleColors.BLUE_BRIGHT + "YOU GO TO JAIL!" + ConsoleColors.RESET);
    }
}

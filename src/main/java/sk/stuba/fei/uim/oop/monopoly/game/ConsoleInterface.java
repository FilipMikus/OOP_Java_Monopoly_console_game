package sk.stuba.fei.uim.oop.monopoly.game;

import sk.stuba.fei.uim.oop.monopoly.game.objects.cards.Card;
import sk.stuba.fei.uim.oop.monopoly.game.objects.Player;
import sk.stuba.fei.uim.oop.monopoly.game.objects.tiles.Tile;
import sk.stuba.fei.uim.oop.monopoly.game.objects.tiles.special.*;
import sk.stuba.fei.uim.oop.utility.ConsoleColors;
import sk.stuba.fei.uim.oop.utility.ModifiedKeyboardInput;

//Class ConsoleInterface with console I/O mechanisms:
public class ConsoleInterface {
    public void printGameHead() {
        System.out.println("\n   " + ConsoleColors.RED_BACKGROUND + "                                                                                         " + ConsoleColors.RESET);
        System.out.println("   " + ConsoleColors.WHITE_BRIGHT + ConsoleColors.RED_BACKGROUND + "   ███    ███    ██████    ███    ██    ██████    ██████     ██████    ██     ██    ██   " + ConsoleColors.RESET);
        System.out.println("   " + ConsoleColors.WHITE_BRIGHT + ConsoleColors.RED_BACKGROUND + "   ████  ████   ██    ██   ████   ██   ██    ██   ██   ██   ██    ██   ██      ██  ██    " + ConsoleColors.RESET);
        System.out.println("   " + ConsoleColors.WHITE_BRIGHT + ConsoleColors.RED_BACKGROUND + "   ██ ████ ██   ██    ██   ██ ██  ██   ██    ██   ██████    ██    ██   ██       ████     " + ConsoleColors.RESET);
        System.out.println("   " + ConsoleColors.WHITE_BRIGHT + ConsoleColors.RED_BACKGROUND + "   ██  ██  ██   ██    ██   ██  ██ ██   ██    ██   ██        ██    ██   ██        ██      " + ConsoleColors.RESET);
        System.out.println("   " + ConsoleColors.WHITE_BRIGHT + ConsoleColors.RED_BACKGROUND + "   ██      ██    ██████    ██   ████    ██████    ██         ██████    ███████   ██      " + ConsoleColors.RESET);
        System.out.println("   " + ConsoleColors.RED_BACKGROUND + "                                                                                         " + ConsoleColors.RESET + "\n");
    }

    public void printPlayerStatus(Player player, Tile currentTile, Tile newTile) {
        System.out.println(ConsoleColors.BLUE + "On turn: " + ConsoleColors.RESET + player.toString());
        System.out.println(ConsoleColors.GREEN + "Number on dice: " + ConsoleColors.RESET + player.getDiceValue());
        System.out.println(ConsoleColors.YELLOW_BRIGHT + "Progress on board: " + ConsoleColors.RESET + '[' + currentTile.getOrder() + ']' + currentTile.getName() + ConsoleColors.YELLOW_BRIGHT + " >> " + ConsoleColors.RESET + '[' + newTile.getOrder() + ']' + newTile.getName());
    }

    public void printTileHead(Tile tile) {
        System.out.println('\n' + tile.toString());
    }

    public void printDivider() {
        System.out.println("-----------------------------------------------------------------------------------------------");
    }

    public void printChanceCard(Card card) {
        System.out.println(card.cardToString());
    }

    public void printExceptionMessage(Exception e) {
        System.out.println(e.getMessage());
        printDivider();
    }

    public boolean requestToBuyProperty() {
        return ModifiedKeyboardInput.readBoolean("Do you want buy this " + ConsoleColors.PURPLE + "property" + ConsoleColors.RESET + " (" + ConsoleColors.GREEN_BRIGHT + "yes" + ConsoleColors.RESET + "/" + ConsoleColors.RED_BRIGHT + "no" + ConsoleColors.RESET + ")");
    }

    public void requestToPayPropertyRent(Tile tile) {
        ModifiedKeyboardInput.readString("You must pay rent " + ((Property) tile).getRent() + "$" + ConsoleColors.PURPLE + " to " + ConsoleColors.RESET + ((Property) tile).getOwner().getName() + " (" + ConsoleColors.WHITE_BRIGHT + "ENTER" + ConsoleColors.RESET + ")");
    }

    public void requestToPayIncomeTax(Tile tile) {
        ModifiedKeyboardInput.readString("You must pay Income tax " + ((IncomeTax) tile).getTaxValue() + "$" + ConsoleColors.RED_BRIGHT + " to " + ConsoleColors.RESET + "Bank (" + ConsoleColors.WHITE_BRIGHT + "ENTER" + ConsoleColors.RESET + ")");
    }

    public void requestToPullChanceCard() {
        ModifiedKeyboardInput.readString("Pull the " + ConsoleColors.YELLOW + "card" + ConsoleColors.RESET + " (" + ConsoleColors.WHITE_BRIGHT + "ENTER" + ConsoleColors.RESET + ")");
    }
}

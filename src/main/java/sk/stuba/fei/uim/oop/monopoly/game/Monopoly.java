package sk.stuba.fei.uim.oop.monopoly.game;

import sk.stuba.fei.uim.oop.monopoly.game.objects.cards.*;
import sk.stuba.fei.uim.oop.monopoly.game.objects.*;
import sk.stuba.fei.uim.oop.monopoly.game.objects.tiles.*;
import sk.stuba.fei.uim.oop.monopoly.game.objects.tiles.special.*;
import sk.stuba.fei.uim.oop.utility.ModifiedKeyboardInput;
import sk.stuba.fei.uim.oop.monopoly.game.exceptions.*;

import java.util.ArrayList;
import java.util.Iterator;

//Class Monopoly with game logic and mechanisms:
public class Monopoly {
    private final ArrayList<Player> players;
    private final Board board;
    private final ConsoleInterface consoleInterface;

    public Monopoly() {
        consoleInterface = new ConsoleInterface();
        board = new Board();
        players = initializePlayers();
        try {
            runGame();
        } catch (WinGameException e) {
            consoleInterface.printExceptionMessage(e);
        }
    }

    private ArrayList<Player> initializePlayers() {
        int numberOfPlayers = ModifiedKeyboardInput.readInt("Enter total number of players (2-8 players)", 2, 8);
        ArrayList<Player> players = new ArrayList<>();
        for (int i = 1; i <= numberOfPlayers; i++) {
            players.add(new Player(ModifiedKeyboardInput.readString("Enter name of player number " + i)));
        }
        consoleInterface.printDivider();
        return players;
    }

    private void runGame() throws WinGameException {
        consoleInterface.printGameHead();
        Iterator<Player> it = players.iterator();
        Player currentPlayer;
        while (it.hasNext()) {
            try {
                currentPlayer = it.next();

                if (currentPlayer.isInJail())
                    currentPlayer.incrementRoundsInJail();
                else
                    turnPlayer(currentPlayer);
            } catch (OutGameException e) {
                consoleInterface.printExceptionMessage(e);
                it.remove();
                if (players.size() == 1)
                    throw new WinGameException(players.get(0).getName());
            } catch (InJailException e) {
                consoleInterface.printExceptionMessage(e);
            }
            if (!it.hasNext())
                it = players.iterator();
        }
    }

    private void turnPlayer(Player player) throws OutGameException, InJailException {
        Tile currentTile = board.getTile(player.getPosition());
        player.rollDiceAndMove();
        Tile newTile = board.getTile(player.getPosition());
        consoleInterface.printPlayerStatus(player, currentTile, newTile);
        makeTileAction(player);
        consoleInterface.printDivider();
    }

    private void makeTileAction(Player playerOnTurn) throws OutGameException, InJailException {
        Tile currentTile = board.getTile(playerOnTurn.getPosition());
        if (currentTile instanceof Start) {
            consoleInterface.printTileHead(currentTile);
        }
        if (currentTile instanceof Property) {
            consoleInterface.printTileHead(currentTile);
            if (!(((Property) currentTile).isOwned()) && (playerOnTurn.getDepositValue() >= ((Property) currentTile).getRent())) {
                if (consoleInterface.requestToBuyProperty())
                    ((Property) currentTile).buyBy(playerOnTurn);
            } else if (((Property) currentTile).isOwned() && ((Property) currentTile).getOwner() != playerOnTurn) {
                consoleInterface.requestToPayPropertyRent(currentTile);
                ((Property) currentTile).payPropertyRentBy(playerOnTurn);
            }
        }
        if (currentTile instanceof Police) {
            consoleInterface.printTileHead(currentTile);
            ((Police) currentTile).sendToJail(playerOnTurn, ((Jail) board.getTile(18)));
        }
        if (currentTile instanceof Jail) {
            consoleInterface.printTileHead(currentTile);
        }
        if (currentTile instanceof IncomeTax) {
            consoleInterface.printTileHead(currentTile);
            consoleInterface.requestToPayIncomeTax(currentTile);
            ((IncomeTax) currentTile).payIncomeTaxBy(playerOnTurn);
        }
        if (currentTile instanceof Chance) {
            consoleInterface.printTileHead(currentTile);
            consoleInterface.requestToPullChanceCard();
            Card tmpCard = ((Chance) currentTile).getTopCard();
            consoleInterface.printChanceCard(tmpCard);
            tmpCard.makeAction(playerOnTurn);
        }
    }
}

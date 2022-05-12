package sk.stuba.fei.uim.oop.monopoly.game.objects;

import sk.stuba.fei.uim.oop.monopoly.game.objects.tiles.special.Property;
import sk.stuba.fei.uim.oop.monopoly.game.exceptions.*;

import java.util.ArrayList;

public class Player {
    private String name;
    private PlayerStatus status;
    private int position;
    private int depositValue;
    private Dice dice;
    private ArrayList<Property> properties;
    private int roundsInJail;

    public Player(String name) {
        this.name = name;
        status = PlayerStatus.IN_GAME;
        position = 0;
        depositValue = 1500;
        dice = new Dice();
        properties = new ArrayList<>();
        roundsInJail = 0;
    }

    public void setInGame() {
        status = PlayerStatus.IN_GAME;
    }

    public void setInJail() throws InJailException {
        status = PlayerStatus.IN_JAIL;
        throw new InJailException();
    }

    public void setOutGame() throws OutGameException {
        status = PlayerStatus.OUT_GAME;
        name = null;
        dice = null;
        properties.forEach(Property::forFeiture);
        properties.clear();
        properties = null;
        throw new OutGameException();
    }

    public void rollDiceAndMove() {
        dice.roll();
        position += dice.getValue();
        if (position > 23) {
            position -= 24;
            increaseMoneyDepositBy(200);
        }
    }

    public void moveTo(int position) {
        this.position = position;
        if (this.position > 23) {
            this.position -= 24;
            increaseMoneyDepositBy(200);
        }
    }

    public void reduceMoneyDepositBy(int amount) throws OutGameException {
        depositValue -= amount;
        if (depositValue <= 0) {
            setOutGame();
        }
    }

    public void increaseMoneyDepositBy(int amount) {
        depositValue += amount;
    }

    public void setRoundsInJail(int roundsInJail) {
        this.roundsInJail = roundsInJail;
    }

    public void incrementRoundsInJail() {
        roundsInJail--;
        if (roundsInJail == 0) {
            setInGame();
        }
    }

    public void addProperty(Property property) {
        properties.add(property);
    }

    public String getName() {
        return name;
    }

    public boolean isInJail() {
        return status == PlayerStatus.IN_JAIL;
    }

    public int getPosition() {
        return position;
    }

    public int getDepositValue() {
        return depositValue;
    }

    public int getDiceValue() {
        return dice.getValue();
    }

    public String toString() {
        StringBuilder output = new StringBuilder('(' + name + ',' + depositValue + "$){");
        for (Property property : properties) {
            output
                    .append(property.toString())
                    .append(',');
        }
        if (output.charAt(output.length() - 1) == '{') {
            output.append('}');
        } else {
            output.setCharAt(output.length() - 1, '}');
        }
        return output.toString();
    }
}

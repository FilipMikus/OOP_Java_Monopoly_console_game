package sk.stuba.fei.uim.oop.monopoly.game.objects;

public class Dice {
    private int value;

    public Dice() {
        roll();
    }

    public void roll() {
        value = (1 + (int) (Math.random() * 6));
    }

    public int getValue() {
        return value;
    }
}

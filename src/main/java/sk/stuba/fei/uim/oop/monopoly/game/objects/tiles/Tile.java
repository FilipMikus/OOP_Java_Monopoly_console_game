package sk.stuba.fei.uim.oop.monopoly.game.objects.tiles;

public abstract class Tile {
    protected String name;
    protected int order;

    public Tile(String name, int order) {
        this.name = name;
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public int getOrder() {
        return order;
    }

    public abstract String toString();
}

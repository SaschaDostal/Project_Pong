package de.hft.ip1.group_3;

public class Player {

    private int id;
    private PlayerBar bar;

    public Player(int id, PlayerBar bar) {
        this.id = id;
        this.bar = bar;
    }

    public PlayerBar getBar() {
        return this.bar;
    }

    public int getId() {
        return this.id;
    }
}

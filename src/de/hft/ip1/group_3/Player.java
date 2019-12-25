package de.hft.ip1.group_3;

public class Player {

    private int id, score;
    private PlayerBar bar;

    public Player(int id, int score, PlayerBar bar) {
        this.id = id;
        this.bar = bar;
        this.score = score;
    }

    public void goal() {
        this.score += 1;
    }

    public PlayerBar getBar() {
        return this.bar;
    }

    public int getId() {
        return this.id;
    }

    public int getScore() {
        return this.score;
    }

}

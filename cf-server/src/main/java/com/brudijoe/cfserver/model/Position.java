package com.brudijoe.cfserver.model;

public class Position {
    private Player player;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public String toString() {
        return "Position{" +
                "player=" + player +
                '}';
    }
}

package com.brudijoe.cfserver.model;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private String id;
    private Player winner;
    private List<Row> rows = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public List<Row> getRows() {
        return rows;
    }

    public void setRows(List<Row> rows) {
        this.rows = rows;
    }
}

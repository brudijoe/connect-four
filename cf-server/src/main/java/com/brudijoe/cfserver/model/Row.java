package com.brudijoe.cfserver.model;

import java.util.ArrayList;
import java.util.List;

public class Row {
    private List<Position> positions = new ArrayList<>();

    public List<Position> getPositions() {
        return positions;
    }

    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }

    @Override
    public String toString() {
        return "Row{" +
                "positions=" + positions +
                '}';
    }

}

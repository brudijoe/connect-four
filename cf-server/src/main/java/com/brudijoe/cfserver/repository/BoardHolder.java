package com.brudijoe.cfserver.repository;

import java.util.HashMap;
import java.util.Map;

import com.brudijoe.cfserver.model.Board;
import org.springframework.stereotype.Repository;

@Repository
public class BoardHolder {

    private final Map<String, Board> boards = new HashMap<>();

    public void addNewBoard(String key, Board value) {
        boards.put(key, value);
    }

    public Board getBoard(String key) {
        return boards.get(key);
    }
}

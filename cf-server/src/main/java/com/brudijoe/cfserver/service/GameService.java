package com.brudijoe.cfserver.service;

import java.util.UUID;

import com.brudijoe.cfserver.model.Board;
import com.brudijoe.cfserver.model.Player;
import com.brudijoe.cfserver.model.Position;
import com.brudijoe.cfserver.model.Row;
import com.brudijoe.cfserver.repository.BoardHolder;
import org.springframework.stereotype.Component;

@Component
public class GameService {

    private final BoardHolder boardHolder;

    public GameService(BoardHolder boardHolder) {
        this.boardHolder = boardHolder;
    }

    public Board createNewGame() {
        Board board = new Board();
        for (int i = 0; i < 7; i++) {
            Row row = new Row();
            for (int j = 0; j < 7; j++) {
                Position position = new Position();
                position.setPlayer(Player.EMPTY);
                row.getPositions().add(position);
            }
            board.getRows().add(row);
            board.setId(UUID.randomUUID().toString());
        }
        boardHolder.addNewBoard(board.getId(), board);
        return board;
    }

    public Board play(String gameID, Player player, int column) {
        Board board = boardHolder.getBoard(gameID);
        // put column in board.
        outerloop:
        for (int rowBoard = 6; rowBoard >= 0; rowBoard--) {
            for (int columnBoard = 0; columnBoard <= 6; columnBoard++) {
                if(board.getRows().get(rowBoard).getPositions().get(column).getPlayer().equals(Player.EMPTY)) {
                    board.getRows().get(rowBoard).getPositions().get(column).setPlayer(player);
                    break outerloop;
                }
            }
        }
        board.setWinner(calculateWinner(board, player));
        return board;
    }

    public Player calculateWinner(Board board, Player player) {
        // HORIZONTAL WIN CONDITION
        int x = 6;
        int y = 6;
        int amount = 4;
        for (int row = x; row >= amount-1; row--) {
            for (int column = 0; column <= y; column++) {
                if (
                        board.getRows().get(row).getPositions().get(column).getPlayer().equals(player) &&
                                board.getRows().get(row - 1).getPositions().get(column).getPlayer().equals(player) &&
                                board.getRows().get(row - 2).getPositions().get(column).getPlayer().equals(player) &&
                                board.getRows().get(row - 3).getPositions().get(column).getPlayer().equals(player)

                ) {
                    return player;
                }
            }
        }
        return null;
    }
}

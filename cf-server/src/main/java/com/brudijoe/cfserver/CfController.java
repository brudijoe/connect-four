package com.brudijoe.cfserver;

import com.brudijoe.cfserver.model.Board;
import com.brudijoe.cfserver.model.Player;
import com.brudijoe.cfserver.service.GameService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController("/connectfour")
@CrossOrigin
public class CfController {

    private final GameService newGameService;

    public CfController(GameService newGameService) {
        this.newGameService = newGameService;
    }

    @GetMapping("/newGame")
    public Board newGame() {
        return newGameService.createNewGame();
    }

    @GetMapping("/play/{gameID}/{player}")
    public Board play(@PathVariable String gameID, @PathVariable Player player, @RequestParam int column) {
        return newGameService.play(gameID, player, column);
    }

}


package homework.controller;

import homework.model.Game;
import homework.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/game")
public class GameController {
    @Autowired
    private GameRepository gameRepository;

    @GetMapping("/games")
    public List<Game> getAllGames() {
        return gameRepository.getAllGames();
    }

    @PostMapping("add-game")
    public ResponseEntity<String> addGame(@RequestBody Game game) {
        gameRepository.addGame(game);
        return ResponseEntity.ok("Game added successfully");
    }


}

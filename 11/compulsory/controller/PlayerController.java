package compulsory.controller;

import compulsory.model.Player;
import compulsory.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/game")
public class PlayerController {
    @Autowired
    private PlayerRepository playerRepository;

    @GetMapping("/players")
    public List<Player> getAllPlayers() {
        return playerRepository.getAllPlayers();
    }
    @PostMapping
    public ResponseEntity<String> addPlayer(@RequestBody Player player) {
        playerRepository.addPlayer(player);
        return ResponseEntity.ok("Player added successfully");
    }
}


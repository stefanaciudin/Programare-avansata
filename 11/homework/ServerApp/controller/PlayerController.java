package homework.controller;

import homework.model.Player;
import homework.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    @PostMapping("add-player")
    public ResponseEntity<String> addPlayer(@RequestBody Player player) {
        playerRepository.addPlayer(player);
        return ResponseEntity.ok("Player added successfully");
    }
    @PutMapping("/update-name/{name}")
    public ResponseEntity<Void> updatePlayerName(@PathVariable String name, @RequestBody Player updatedPlayer) {
        List<Player> players = playerRepository.getAllPlayers();
        boolean playerFound = false;

        for (Player player : players) {
            if (player.getName().equals(name)) {
                player.setName(updatedPlayer.getName());
                playerFound = true;
                break;
            }
        }
        if (playerFound) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{name}")
    public ResponseEntity<Void> deletePlayer(@PathVariable String name) {
        List<Player> players = playerRepository.getAllPlayers();
        Player playerToRemove = null;

        for (Player player : players) {
            if (player.getName().equals(name)) {
                playerToRemove = player;
                break;
            }
        }

        if (playerToRemove != null) {
            players.remove(playerToRemove);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}


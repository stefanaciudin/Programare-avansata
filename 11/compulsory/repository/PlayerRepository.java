package compulsory.repository;

import compulsory.model.Player;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository {
    List<Player> getAllPlayers();

    void addPlayer(Player player);
}

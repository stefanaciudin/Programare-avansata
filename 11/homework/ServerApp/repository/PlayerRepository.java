package homework.repository;

import homework.model.Player;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository {
    List<Player> getAllPlayers();

    void addPlayer(Player player);
}

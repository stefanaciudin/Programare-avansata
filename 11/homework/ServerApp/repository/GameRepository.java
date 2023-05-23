package homework.repository;

import homework.model.Game;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository {

    List<Game> getAllGames();

    void addGame(Game game);

}

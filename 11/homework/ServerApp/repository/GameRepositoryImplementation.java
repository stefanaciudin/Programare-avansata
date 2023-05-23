package homework.repository;

import homework.model.Game;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class GameRepositoryImplementation implements GameRepository{
    private final List<Game> games = new ArrayList<>();

    public List<Game> getAllGames() {
        return games;
    }

    public void addGame(Game game) {
        games.add(game);
    }
}

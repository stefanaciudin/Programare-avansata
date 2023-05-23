package client;

import model.Game;
import model.Player;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
        invokePlayerServices();
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    public static void invokePlayerServices() {
        RestTemplate restTemplate = new RestTemplate();

        // Add a player
        Player player1 = new Player("John Doe");
        Player player2 = new Player("Gigel");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Player> requestEntity1 = new HttpEntity<>(player1, headers);
        HttpEntity<Player> requestEntity2 = new HttpEntity<>(player2, headers);

        restTemplate.exchange("http://localhost:2424/api/game/add-player", HttpMethod.POST, requestEntity1, Void.class);
        restTemplate.exchange("http://localhost:2424/api/game/add-player", HttpMethod.POST, requestEntity2, Void.class);

        // Get all players
        ResponseEntity<Player[]> response = restTemplate.getForEntity("http://localhost:2424/api/game/players", Player[].class);
        Player[] players = response.getBody();
        System.out.println("Before modifications: ");
        for (Player player : players) {
            System.out.println(player.getName());
        }

        // Update player name
        Player updatedPlayer = new Player("John Smith");
        HttpEntity<Player> requestEntity = new HttpEntity<>(updatedPlayer, headers);
        restTemplate.exchange("http://localhost:2424/api/game/update-name/{name}", HttpMethod.PUT, requestEntity, Void.class, "John Doe");
        System.out.println("Updated player name to John Smith");

        // Delete a player
        restTemplate.delete("http://localhost:2424/api/game/delete/{name}", "Gigel");

        // Get all players after modifications
        response = restTemplate.getForEntity("http://localhost:2424/api/game/players", Player[].class);
        players = response.getBody();
        for (Player player : players) {
            System.out.println("After deleting gigel: " + player.getName());
        }

        // Add a game
        Game game1 = new Game("Game1");

        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Game> requestEntity3 = new HttpEntity<>(game1, headers);
        restTemplate.exchange("http://localhost:2424/api/game/add-game", HttpMethod.POST, requestEntity3, Void.class);

        // Get all games
        ResponseEntity<Game[]> response2 = restTemplate.getForEntity("http://localhost:2424/api/game/games", Game[].class);
        Game[] games = response2.getBody();
        System.out.println("Available games: ");
        for (Game game : games) {
            System.out.println(game.getName());
        }

    }
}










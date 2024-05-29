package com.capitales.eval.controller;

import com.capitales.eval.db.Country;
import com.capitales.eval.db.Player;
import com.capitales.eval.service.CountryService;
import com.capitales.eval.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
public class CountryController {

    @Autowired
    CountryService countryService;

    @Autowired
    PlayerService playerService;

    @GetMapping("/games")
    public ResponseEntity<Object> getRandomCountry() {

        Country randomCountry = countryService.getRandomCountry();
        return ResponseHandler.generateCountryResponse(randomCountry);

    }

    @GetMapping("/games/{id_player}")
    public ResponseEntity<Object> getRandomCountryExclude(@PathVariable("id_player") Integer id_player) {

        //Si on précise un id_player, on exclut de la recherche le dernier pays trouvé
        Optional<Player> optional_player = playerService.findById(id_player);

        if (optional_player.isEmpty()) {
            return ResponseEntity.status(404).build();
        }
        Player player = optional_player.get();

        Country randomCountry = countryService.getRandomCountry(player.getLast_country_id());
        return ResponseHandler.generateCountryResponse(randomCountry);

    }

    @PostMapping("/games/{id_country}/{id_player}")
    public ResponseEntity<Object> guessCountry(@PathVariable("id_country") Integer id_country, @PathVariable("id_player") Integer id_player, @RequestBody Country userGuess) {
        Optional<Country> optional_country = countryService.findById(id_country);
        Optional<Player> optional_player = playerService.findById(id_player);

        if (optional_country.isEmpty()) {
            return ResponseEntity.status(404).build();
        }

        if (optional_player.isEmpty()) {
            return ResponseEntity.status(404).build();
        }

        if (userGuess == null || userGuess.getCapital() == null) {
            return ResponseEntity.notFound().build();
        }

        Country countryToGuess = optional_country.get();
        Player player = optional_player.get();

        Map<String, Object> resp = new HashMap<>();
        Integer currentScore = player.getScore();
        if (countryToGuess.getCapital().toLowerCase().equals(userGuess.getCapital().toLowerCase())) {
            resp.put("text", "Bonne réponse !");
            currentScore++;
        } else {
            resp.put("text", "Mauvaise réponse ! La bonne réponse est " + countryToGuess.getCapital());
            currentScore--;
        }
        if (currentScore < 0) { currentScore = 0;}
        player.setScore(currentScore);
        player.setLast_country_id(id_country);
        playerService.update(player);

        resp.put("score", player.getScore());

        return ResponseEntity.ok(resp);
    }

    @PostMapping("/player")
    public ResponseEntity<Player> addPlayer(@RequestBody Player player) {
        System.out.println(player);
        if (player == null) {
            return ResponseEntity.notFound().build();
        }

        playerService.addPlayer(player);
        return ResponseEntity.ok(player);
    }

}

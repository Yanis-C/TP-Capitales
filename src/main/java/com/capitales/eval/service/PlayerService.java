package com.capitales.eval.service;

import com.capitales.eval.db.Country;
import com.capitales.eval.db.CountryRepository;
import com.capitales.eval.db.Player;
import com.capitales.eval.db.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    public void addPlayer(Player player) {
        player.setScore(0);
        playerRepository.save(player);
    }

    public Optional<Player> findById(Integer id) {
        return playerRepository.findById(id);
    }

    public void update (Player player) {
        playerRepository.save(player);
    }

}

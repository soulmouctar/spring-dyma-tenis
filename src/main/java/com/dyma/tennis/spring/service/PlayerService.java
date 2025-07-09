package com.dyma.tennis.spring.service;

import com.dyma.tennis.spring.PlayerList;
import com.dyma.tennis.spring.entity.Player;
import com.dyma.tennis.spring.entity.PlayerToRegister;
import com.dyma.tennis.spring.exceptions.PlayerNotFounfException;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerService {
    public List<Player> getAllPlayers(){
        return PlayerList.ALL.stream()
                .sorted(Comparator.comparing(player -> player.rank().position()))
                .collect(Collectors.toList());
    }

    public Player getPlayerByLastName(String lastName){
        return PlayerList.ALL.stream()
                .filter(player -> player.firstName().equals(lastName))
                .findFirst()
                .orElseThrow(() -> new PlayerNotFounfException(lastName));
    }

    public Player create(PlayerToRegister playerToRegister){
        RankingCalculator rankingCalculator = new RankingCalculator(
                PlayerList.ALL, playerToRegister
        );
        List<Player> players = rankingCalculator.getNewPlayersRanking();
        return players.stream()
                .filter(player -> player.lastName().equals(playerToRegister.lastName()))
                .findFirst().get();
    }
}

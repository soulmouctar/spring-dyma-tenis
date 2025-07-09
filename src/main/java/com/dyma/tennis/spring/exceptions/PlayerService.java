package com.dyma.tennis.spring.exceptions;

import com.dyma.tennis.spring.PlayerList;
import com.dyma.tennis.spring.entity.Player;
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
}

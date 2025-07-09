package com.dyma.tennis.spring.exceptions;

import com.dyma.tennis.spring.PlayerList;
import com.dyma.tennis.spring.entity.Player;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    public List<Player> getAllPlayers(){
        return PlayerList.ALL;
    }
}

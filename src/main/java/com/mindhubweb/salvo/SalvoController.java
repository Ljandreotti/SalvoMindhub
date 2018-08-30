package com.mindhubweb.salvo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class SalvoController {

    @Autowired
    private GameRepository gameRepository;

    @RequestMapping("/games")
//        Solo para la tarea 4
//        public List<Long> getGames(){
//        return gameRepository.findAll().stream().map(Game::getId).collect(Collectors.toList());

//        public List<Map<String, Object>> getGames(){
    public List<Map<String, Object>> getData(){
        return gameRepository.findAll().stream().map(this::makeGameDTO).collect(Collectors.toList());
    }

    private Map<String, Object> makeGameDTO(Game game) {
            Map<String, Object> dto = new LinkedHashMap<>();
            dto.put("id", game.getId());
            dto.put("created", game.getGameDate());
            dto.put("gamePlayers", game.getGamePlayers().stream().map(this::gamePlayersDTO).collect(Collectors.toList()));
            return dto;
    }
    private Map<String, Object> gamePlayersDTO(GamePlayer gamePlayer){
            Map<String, Object> dto = new LinkedHashMap<>();
            dto.put("id", gamePlayer.getId());
            dto.put("player", playersDTO(gamePlayer.getPlayer()));
            return dto;
    }
    private Map<String, Object> playersDTO(Player player){
            Map<String, Object> dto = new LinkedHashMap<>();
            dto.put("id", player.getId());
            dto.put("email", player.getUserName());
            return dto;
    }
}

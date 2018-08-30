package com.mindhubweb.salvo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;


@Entity
public class GamePlayer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDateTime creationDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "player_id")
    private Player player;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "game_id")
    private Game game;

    public GamePlayer() { }
    public GamePlayer(LocalDateTime localDateTime) {this.creationDate = localDateTime;}

    public GamePlayer(Game game, Player player, LocalDateTime localDateTime) {
        this.game = game;
        this.player = player;
        this.creationDate = localDateTime;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getCreationDate() {return creationDate;}
    public void setCreationDate(LocalDateTime creationDate) {this.creationDate = creationDate;}

    @JsonIgnore
    public Player getPlayer() {return player;}
    public void setPlayer(Player player) {this.player = player;}

    @JsonIgnore
    public Game getGame() {return game;}
    public void setGame(Game game) {this.game = game;}

}

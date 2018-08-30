package com.mindhubweb.salvo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import java.time.LocalDateTime;


@SpringBootApplication
public class SalvoApplication {

	public static void main(String[] args) {SpringApplication.run(SalvoApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(PlayerRepository playerRepository,
									  GameRepository gameRepository,
									  GamePlayerRepository gamePlayerRepository) {
		return (args) -> {
			// Players
			Player p1 = new Player("j.bauer@ctu.gov");
			playerRepository.save(p1);
			Player p2 = new Player("c.obrian@ctu.gov");
			playerRepository.save(p2);
			Player p3 = new Player("kim_bauer@gmail.com");
			playerRepository.save(p3);
			Player p4 = new Player("t.almeida@ctu.gov");
			playerRepository.save(p4);

			// Games
			Game g1 = new Game(LocalDateTime.now());
			gameRepository.save(g1);
			Game g2 = new Game(LocalDateTime.from(LocalDateTime.now().plusMinutes(60)));
			gameRepository.save(g2);
			Game g3 = new Game(LocalDateTime.from(LocalDateTime.now().plusMinutes(120)));
			gameRepository.save(g3);
//			Game g4 = new Game(LocalDateTime.from(LocalDateTime.now().plusMinutes(180)));
//			gameRepository.save(g4);

			// Games/-Players
			gamePlayerRepository.save(new GamePlayer(g1, p1, LocalDateTime.now()));
			gamePlayerRepository.save(new GamePlayer(g1, p2, LocalDateTime.now()));
			gamePlayerRepository.save(new GamePlayer(g2, p1, LocalDateTime.now()));
			gamePlayerRepository.save(new GamePlayer(g2, p2, LocalDateTime.now()));
			gamePlayerRepository.save(new GamePlayer(g3, p2, LocalDateTime.now()));
			gamePlayerRepository.save(new GamePlayer(g3, p4, LocalDateTime.now()));
//			gamePlayerRepository.save(new GamePlayer(g4, p4));
//			gamePlayerRepository.save(new GamePlayer(g4, p4));

		};
	}
}

package com.capitales.eval;

import com.capitales.eval.db.Country;
import com.capitales.eval.db.CountryRepository;
import com.capitales.eval.db.Player;
import com.capitales.eval.db.PlayerRepository;
import com.capitales.eval.service.CountryService;
import com.capitales.eval.service.PlayerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

@SpringBootTest
class EvalApplicationTests {

	@Autowired
	CountryRepository countryRepository;

	@Autowired
	CountryService countryService;

	@Autowired
	PlayerRepository playerRepository;

	@Autowired
	PlayerService playerService;

	@Test
	void testRandomCountry() {
		Country country = countryRepository.getRandomCountry();
		System.out.println(country.getCapital());
		System.out.println(country.getName());
		System.out.println(country.getId());
	}

	@Test
	void testCountryById() {
		Optional<Country> optional = countryService.findById(58);
		if (optional.isEmpty()) {
			System.out.println("Country not found");
		} else {
			Country country = optional.get();
			System.out.println(country.getCapital());
			System.out.println(country.getName());
			System.out.println(country.getId());
		}

	}

	@Test
	void testUser() {
		Player pl = new Player("Jean");
		playerService.addPlayer(pl);
	}

}

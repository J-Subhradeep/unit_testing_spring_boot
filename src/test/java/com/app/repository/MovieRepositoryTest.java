package com.app.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.Month;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.app.model.Movie;


@DataJpaTest
class MovieRepositoryTest {

	@Autowired
	private MovieRepository movieRepository;
	
	@Test
	@Disabled
	void save() {
//		arrange
		
		Movie avatarMovie = new Movie();
		avatarMovie.setName("Avatar");
		avatarMovie.setGenera("Action");
		avatarMovie.setReleaseDate(LocalDate.of(2000, Month.APRIL, 22));
		
		
//		act
		
		Movie newMovie = movieRepository.save(avatarMovie);
		
//		assert
		
		assertNotNull(newMovie);
		assertThat(newMovie.getId()).isNotEqualTo(null);
		
	}
	
	
	@Test
	void getMovieById() {
		Movie avatarMovie = new Movie();
		avatarMovie.setName("Avatar");
		avatarMovie.setGenera("Action");
		avatarMovie.setReleaseDate(LocalDate.of(2000, 3, 23));
		movieRepository.save(avatarMovie);
		
		Movie existingMovie = movieRepository.findById(avatarMovie.getId()).get();
		System.out.println(existingMovie);
		assertNotNull(existingMovie);
		assertEquals("Action", existingMovie.getGenera());
		assertThat(avatarMovie.getReleaseDate()).isBefore(LocalDate.of(2000, 3, 24));
	}

}

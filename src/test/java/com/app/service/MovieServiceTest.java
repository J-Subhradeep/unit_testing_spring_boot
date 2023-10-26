package com.app.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.Month;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.app.model.Movie;
import com.app.repository.MovieRepository;

@ExtendWith(MockitoExtension.class)
class MovieServiceTest {

	@InjectMocks
	private MovieService movieService;
	
	@Mock
	private MovieRepository movieRepository;
	
	@Test
	void testSave() {
		Movie avatarMovie = new Movie();
		avatarMovie.setId(1L);
		avatarMovie.setName("Avatar");
		avatarMovie.setGenera("Action");
		avatarMovie.setReleaseDate(LocalDate.of(2000, Month.APRIL, 22));
		
		
		when(movieRepository.save(any(Movie.class))).thenReturn(avatarMovie);
		
		Movie newMovie = movieService.save(avatarMovie);
		assertNotNull(newMovie);
		assertThat(newMovie.getName()).isEqualTo("Avatar");
	}

	@Test
	void testGetAllMovies() {
		fail("Not yet implemented");
	}

	@Test
	void testGetMovieById() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateMovie() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteMovie() {
		fail("Not yet implemented");
	}

	@Test
	void testMovieService() {
		fail("Not yet implemented");
	}

}

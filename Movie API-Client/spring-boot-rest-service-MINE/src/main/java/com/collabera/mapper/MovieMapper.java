package com.collabera.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.collabera.dto.MovieDTO;
import com.collabera.dto.RatingDTO;
import com.collabera.dto.StudioDTO;
import com.collabera.model.Movie;
import com.collabera.model.Studio;

@Component
public class MovieMapper {

	public Movie toEntity(MovieDTO dto) {
		Movie movie = new Movie();
		movie.setName(dto.getName());
		movie.setCategory(dto.getCategory());
		movie.setPrice(dto.getPrice());
		movie.setDescription(dto.getDescription());
		movie.setImage(dto.getImage());
		return movie;
	}

	public MovieDTO toDto(Movie entity) {
		MovieDTO movie = new MovieDTO();
		movie.setMovieId(entity.getId());
		movie.setName(entity.getName());
		movie.setCategory(entity.getCategory());
		movie.setPrice(entity.getPrice());
		movie.setDescription(entity.getDescription());
		Studio studio = entity.getStudio();
		if (studio != null) {
			movie.setStudio(new StudioDTO(studio.getId(), studio.getName(), studio.getCity(), studio.getState()));
		}
		movie.setImage(entity.getImage());
		if (entity.getRatings() != null) {
			List<RatingDTO> ratings = entity.getRatings().stream().map(r -> {
				return new RatingDTO(r.getId(), r.getStars());
			}).collect(Collectors.toList());
			movie.setRatings(ratings);
		}
		return movie;
	}
}


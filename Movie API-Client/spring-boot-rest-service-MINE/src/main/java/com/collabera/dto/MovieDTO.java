package com.collabera.dto;

import java.util.List;

import javax.validation.constraints.NotNull;

public class MovieDTO {
	private Long movieId;

	@NotNull
	private String name;

	private String category;

	private String description;

	@NotNull
	private Double price;

	private StudioDTO studio;

	private String image;

	private List<RatingDTO> ratings;

	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public StudioDTO getStudio() {
		return studio;
	}

	public void setStudio(StudioDTO studio) {
		this.studio = studio;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<RatingDTO> getRatings() {
		return ratings;
	}

	public void setRatings(List<RatingDTO> ratings) {
		this.ratings = ratings;
	}

}
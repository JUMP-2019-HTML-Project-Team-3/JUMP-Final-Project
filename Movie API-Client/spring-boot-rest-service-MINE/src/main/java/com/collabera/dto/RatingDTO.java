package com.collabera.dto;

public class RatingDTO {
	private Integer stars;
	private Integer id;
	
	public RatingDTO(Integer stars, Integer id) {
		super();
		this.stars = stars;
		this.id = id;
	}
	public Integer getStars() {
		return stars;
	}
	public void setStars(Integer stars) {
		this.stars = stars;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
}
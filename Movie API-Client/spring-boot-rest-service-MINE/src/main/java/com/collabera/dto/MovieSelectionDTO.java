package com.collabera.dto;

public class MovieSelectionDTO {
	private Long movieId;
	private String name;
	private Double price;
	private Integer quantity;
	
	public MovieSelectionDTO(Long movieId, String name, Double price, Integer quantity) {
		super();
		this.movieId = movieId;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
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
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}


package com.collabera.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orderline")
public class OrderLine {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@OneToOne
	private Movie movie;
	
	private Integer quantity;

	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public OrderLine(Integer id, Movie movie, Integer quantity, Order order) {
		super();
		this.id = id;
		this.movie = movie;
		this.quantity = quantity;
		this.order = order;
	}

	public OrderLine() {
		super();
	}

	public OrderLine(Movie movie, Integer quantity, Order order) {
		super();
		this.movie = movie;
		this.quantity = quantity;
		this.order = order;
	}

}


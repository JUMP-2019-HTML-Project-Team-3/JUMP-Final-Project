package com.collabera.dto;

import java.util.List;

import com.collabera.dto.CheckoutDTO;
import com.collabera.dto.MovieSelectionDTO;
import com.collabera.dto.OrderConfirmationDTO;

import java.util.List;

	public class OrderDTO {

		private String orderId;
		private String name;
		private String address;
		private CheckoutDTO payment;
		private boolean submitted;
		private boolean shipped;
		private OrderConfirmationDTO confirmation;
		private List<MovieSelectionDTO> movies;

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public List<MovieSelectionDTO> getMovies() {
			return movies;
		}

		public void setMovies(List<MovieSelectionDTO> movies) {
			this.movies = movies;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public CheckoutDTO getPayment() {
			return payment;
		}

		public void setPayment(CheckoutDTO payment) {
			this.payment = payment;
		}

		public String getOrderId() {
			return orderId;
		}

		public void setOrderId(String orderId) {
			this.orderId = orderId;
		}

		public boolean isSubmitted() {
			return submitted;
		}

		public void setSubmitted(boolean submitted) {
			this.submitted = submitted;
		}

		public boolean isShipped() {
			return shipped;
		}

		public void setShipped(boolean shipped) {
			this.shipped = shipped;
		}

		public OrderConfirmationDTO getConfirmation() {
			return confirmation;
		}

		public void setConfirmation(OrderConfirmationDTO confirmation) {
			this.confirmation = confirmation;
		}

		@Override
		public String toString() {
			return "OrderDTO [address=" + address + ", movies=" + movies + ", name=" + name + ", payment=" + payment + "]";
		}

	}

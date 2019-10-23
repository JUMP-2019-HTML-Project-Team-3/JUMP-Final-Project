package com.collabera.dto;

import java.util.Arrays;

import com.collabera.dto.MovieSelectionDTO;

public class CartDTO {
	private MovieSelectionDTO[] selections;
	private int itemCount;
	private double totalPrice;

	public MovieSelectionDTO[] getSelections() {
		return selections;
	}

	public void setSelections(MovieSelectionDTO[] selections) {
		this.selections = selections;
	}

	public int getItemCount() {
		return itemCount;
	}

	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "CartDTO [selections=" + Arrays.toString(selections) + ", itemCount=" + itemCount + ", totalPrice="
				+ totalPrice + "]";
	}

}

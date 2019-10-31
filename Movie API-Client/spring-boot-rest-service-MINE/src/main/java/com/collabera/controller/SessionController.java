package com.collabera.controller;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.collabera.dto.CartDTO;
import com.collabera.dto.CheckoutDTO;
import com.collabera.dto.MovieSelectionDTO;
import com.collabera.dto.OrderConfirmationDTO;
import com.collabera.dto.OrderDTO;
import com.collabera.service.OrderService;

@Controller
@RequestMapping("/api")
public class SessionController {
 
	// in memory store to contain the cart data for a user 
	private Map<String, CartDTO> cartStore = new HashMap<>();
	// in memory store to contain the payment and shipping data for a user
	private Map<String, CheckoutDTO> checkoutStore = new HashMap<>();
 
	@Autowired
	private OrderService orderService;
 
	// method to return the cart content to the UI. Fetch that from the in memory store
@GetMapping("/session/cart")
	public ResponseEntity<CartDTO> getCart(@CookieValue(name = "JSESSIONID", required = false) String cookieValue) {
		CartDTO cartDTO = cartStore.get(cookieValue);
		if (cartDTO == null) {
			cartDTO = new CartDTO();
		}
		cartStore.put(cookieValue, cartDTO);
		return ResponseEntity.status(HttpStatus.OK).body(cartDTO);
	}
 
// method to create a new cart based on selected movies and store it in the cart store map
	@PostMapping("/session/cart")
	public ResponseEntity<MovieSelectionDTO[]> create(@RequestBody @Valid MovieSelectionDTO[] movies,@CookieValue(name = "JSESSIONID", required = false) String cookieValue) throws URISyntaxException {
		CartDTO cartDTO = cartStore.get(cookieValue);
		if (cartDTO == null) {
			cartDTO = new CartDTO();
		}
		cartDTO.setSelections(movies);
		double total = 0.0;
		for (MovieSelectionDTO s : movies) {
			total += s.getQuantity() * s.getPrice();
		}
		cartDTO.setTotalPrice(total);
 
		cartStore.put(cookieValue, cartDTO);
		return ResponseEntity.ok().body(movies);
	}
 
// method to store the checkout details for a user based on session cookie
	@PostMapping("/session/checkout")
	public ResponseEntity<CheckoutDTO> checkout(@CookieValue(name = "JSESSIONID", required = false) String cookieValue, @RequestBody CheckoutDTO checkout) {
		checkoutStore.put(cookieValue, checkout);
		return ResponseEntity.status(HttpStatus.OK).body(checkout);
	}
 
	// method to get the checkout details of a user based on session cookie
	@GetMapping("/session/checkout")
	public ResponseEntity<CheckoutDTO> checkout(
			@CookieValue(name = "JSESSIONID", required = false) String cookieValue) {
		CheckoutDTO checkoutDTO = checkoutStore.get(cookieValue);
		return ResponseEntity.status(HttpStatus.OK).body(checkoutDTO);
	}
 
// method to create order and send out confirmation
	@PostMapping("/orders")
	public ResponseEntity<OrderConfirmationDTO> saveOrder(@CookieValue(name = "JSESSIONID", required = false) String cookieValue, @RequestBody OrderDTO order) {
		CartDTO cartDTO = cartStore.get(cookieValue);
		OrderConfirmationDTO saveOrder = orderService.saveOrder(order, cartDTO);
		cartStore.remove(cookieValue);
		checkoutStore.remove(cookieValue);
		return ResponseEntity.ok().body(saveOrder);
	}
 
	// method to return all the orders
	@GetMapping("/orders")
	public ResponseEntity<List<OrderDTO>> fetchOrders(
			@CookieValue(name = "JSESSIONID", required = false) String cookieValue) {
		List<OrderDTO> orders = orderService.fetchOrders();
		return ResponseEntity.ok().body(orders);
	}
 
// method to ship an order based on order id.
	@PostMapping("/orders/{id}")
	public ResponseEntity<OrderDTO> shipOrders(@CookieValue(name = "JSESSIONID", required = false) String cookieValue, @PathVariable(name = "id") String orderId) {
		OrderDTO order = orderService.shipOrders(orderId);
		return ResponseEntity.ok().body(order);
	}
}


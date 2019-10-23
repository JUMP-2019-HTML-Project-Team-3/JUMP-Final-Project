package com.collabera.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collabera.dto.CartDTO;
import com.collabera.dto.CheckoutDTO;
import com.collabera.dto.MovieSelectionDTO;
import com.collabera.dto.OrderConfirmationDTO;
import com.collabera.dto.OrderDTO;
import com.collabera.model.Movie;
import com.collabera.model.Order;
import com.collabera.model.OrderLine;
import com.collabera.repository.MovieRepository;
import com.collabera.repository.OrderLineRepository;
import com.collabera.repository.OrderRepository;

@Service
public class OrderService {
 

	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private OrderLineRepository orderLineRepository;
	@Autowired
	private MovieRepository movieRepository;

	public List<OrderDTO> fetchOrders() {
		List<Order> findAll = orderRepository.findAll();
		List<OrderDTO> orders = new ArrayList<OrderDTO>();
		for (Order o : findAll) {
			OrderDTO d = mapOrder(o);
			orders.add(d);
		}
		return orders;
	}

	public OrderDTO shipOrders(String orderId) {
		Optional<Order> orderOptional = orderRepository.findById(Integer.valueOf(orderId));
		Order order = null;
		if (orderOptional.isPresent()) {
			order = orderOptional.get();
			order.setShipped(true);
			orderRepository.save(order);
		}
		return mapOrder(order);
	}
	
	public OrderConfirmationDTO saveOrder(OrderDTO order, CartDTO cartDTO) {
		CheckoutDTO payment = order.getPayment();
		List<Movie> allMovies = movieRepository.findAll();
		Map<Long, Movie> moviesMap = allMovies.stream().collect(Collectors.toMap(Movie::getId, m -> m));
		Order entity = new Order();
		entity.setAddress(order.getAddress());
		entity.setAmount(cartDTO.getTotalPrice());
		entity.setAuthCode(UUID.randomUUID().toString());
		entity.setCardExpiry(payment.getCardExpiry());
		entity.setCardNumber(payment.getCardNumber());
		entity.setCardSecurityCode(payment.getCardSecurityCode());
		entity.setCustomerName(order.getName());
		entity.setShipped(false);
		entity.setSubmitted(true);
		System.out.println(entity);
		Order savedOrder = orderRepository.save(entity);
		List<MovieSelectionDTO> movies = order.getMovies();
		Set<OrderLine> orderLines = new HashSet<>();
		for (MovieSelectionDTO m : movies) {
			orderLines.add(new OrderLine(moviesMap.get(m.getMovieId()), m.getQuantity(), savedOrder));
		}

		order.setOrderId("" + System.currentTimeMillis());
		order.setSubmitted(true);
		OrderConfirmationDTO dto = new OrderConfirmationDTO();

		dto.setAuthCode(savedOrder.getAuthCode());
		dto.setOrderId(savedOrder.getId() + "");
		dto.setAmount(savedOrder.getAmount());

		orderLineRepository.saveAll(orderLines);
		return dto;
	}

	private OrderDTO mapOrder(Order o) {
		OrderDTO d = new OrderDTO();
		if (o != null) {
			d.setAddress(o.getAddress());
			d.setName(o.getCustomerName());
			d.setOrderId("" + o.getId());
			d.setShipped(o.isShipped());
			d.setSubmitted(o.isSubmitted());
			Set<OrderLine> orderLines = o.getOrderLines();
			List<MovieSelectionDTO> movies = new ArrayList<>();
			for (OrderLine line : orderLines) {
				Movie movie = line.getMovie();
				movies.add(new MovieSelectionDTO(movie.getId(), movie.getName(), movie.getPrice(), line.getQuantity()));
			}
			d.setMovies(movies);
			d.setConfirmation(new OrderConfirmationDTO("" + o.getId(), o.getAuthCode(), o.getAmount()));
		}
		return d;
	}

}


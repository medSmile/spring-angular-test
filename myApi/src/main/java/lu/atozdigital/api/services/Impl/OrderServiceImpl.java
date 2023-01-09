package lu.atozdigital.api.services.Impl;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import lu.atozdigital.api.entites.OrderEntity;
import lu.atozdigital.api.repositories.OrderRepository;
import lu.atozdigital.api.services.OrderService;
import lu.atozdigital.api.share.Utils;
import lu.atozdigital.api.share.dto.OrderDto;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	Utils util ; 
	
	@Override
	public OrderDto addOrder(OrderDto orderdto) {
		ModelMapper modelMapper = new ModelMapper();
		OrderEntity orderEntity = modelMapper.map(orderdto, OrderEntity.class);
		orderEntity.setReference(util.generateStringId(10));
		orderEntity.setDate(new Date());
		OrderEntity newOrder = orderRepository.save(orderEntity);
		OrderDto orderDto = modelMapper.map(newOrder, OrderDto.class);
		
		return orderDto;
	}

	@Override
	public List<OrderDto> getAll() {
		List<OrderEntity> Orders = (List<OrderEntity>) orderRepository.findAll();
		
		ModelMapper modelMapper = new ModelMapper();
		Type ListType = new TypeToken<List<OrderDto>>(){}.getType();
		List<OrderDto> allOrders = modelMapper.map(Orders, ListType);
		
		return allOrders;
	}

	@Override
	public OrderDto upDateOrder(long id) {
		OrderEntity orderEntity = orderRepository.findById(id).get();
		if(orderEntity == null) throw new  ResponseStatusException(HttpStatus.BAD_REQUEST, "order not found");
		orderEntity.setDate(new Date());
		OrderEntity upDateOrder = orderRepository.save(orderEntity);
		ModelMapper modelMapper = new ModelMapper();
		OrderDto orderDto = modelMapper.map(upDateOrder, OrderDto.class);
		
		return orderDto;
	}

}

package lu.atozdigital.api.services;

import java.util.List;

import lu.atozdigital.api.share.dto.OrderDto;

public interface OrderService {
	
	OrderDto addOrder(OrderDto orderdto);
	
	List<OrderDto> getAll();
	
	OrderDto upDateOrder(long id);

}

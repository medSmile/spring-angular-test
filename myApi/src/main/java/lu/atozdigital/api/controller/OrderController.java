package lu.atozdigital.api.controller;

import java.lang.reflect.Type;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lu.atozdigital.api.request.OrderRequest;
import lu.atozdigital.api.response.OrderResponse;
import lu.atozdigital.api.services.OrderService;
import lu.atozdigital.api.share.dto.OrderDto;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@PostMapping
	public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest orderRequest){
		

		ModelMapper modelMapper = new ModelMapper();
		
		OrderDto orderDto = modelMapper.map(orderRequest, OrderDto.class);
		
		OrderDto newOrder = orderService.addOrder(orderDto);
		
		OrderResponse order = modelMapper.map(newOrder, OrderResponse.class);
		
		return new ResponseEntity<OrderResponse>(order,HttpStatus.OK);
		
	}
	
	@GetMapping
	public ResponseEntity<List<OrderResponse>> getAllOrders(){
		
		List<OrderDto> Orders = orderService.getAll();
		
		ModelMapper modelMapper = new ModelMapper();
		Type ListType = new TypeToken<List<OrderResponse>>(){}.getType();
		List<OrderResponse> allOrders = modelMapper.map(Orders, ListType);
		
		return new ResponseEntity<List<OrderResponse>>(allOrders,HttpStatus.OK);
		
	}
	
	@PutMapping(path="/{id}")
	public ResponseEntity<OrderResponse> EditOrder(@PathVariable long id){
		
		ModelMapper modelMapper = new ModelMapper();
		
		OrderDto newOrder = orderService.upDateOrder(id);
		
		OrderResponse order = modelMapper.map(newOrder, OrderResponse.class);
		
		return new ResponseEntity<OrderResponse>(order,HttpStatus.OK);

		
	}

}

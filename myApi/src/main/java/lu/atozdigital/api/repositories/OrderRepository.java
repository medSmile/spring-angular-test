package lu.atozdigital.api.repositories;

import org.springframework.data.repository.CrudRepository;

import lu.atozdigital.api.entites.OrderEntity;

public interface OrderRepository extends CrudRepository<OrderEntity, Long> {

}

package br.com.artech.dsdeliver.services;

import br.com.artech.dsdeliver.dto.OrderDTO;
import br.com.artech.dsdeliver.entities.Order;
import br.com.artech.dsdeliver.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    OrderRepository repository;

    @Transactional(readOnly = true)
    public List<OrderDTO> findAll(){
        List<Order> orders = repository.findOrdersWithProducts();
        return orders.stream().map(order -> new OrderDTO(order)).collect(Collectors.toList());
    }
}

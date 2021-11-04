package it.corsojava.spring.springdata.controller;

import it.corsojava.spring.springdata.model.Order;
import it.corsojava.spring.springdata.model.User;
import it.corsojava.spring.springdata.repository.OrderRepository;
import it.corsojava.spring.springdata.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    UserRepository userRepository;

    @PostMapping("saveOrder")
    public void saveUser(@RequestBody Order order, @RequestParam String userId){
        User user = userRepository.getById(Long.valueOf(userId));
        order.setUser(user);
        order.setDates();
        orderRepository.save(order);
    }

    @GetMapping("getOrders")
    public List<Order> getOrders(){
        return orderRepository.findAll();
    }

    @DeleteMapping("deleteOrder")
    public void deleteOrder(@RequestParam String orderId){
        orderRepository.delete(orderRepository.getById(Long.valueOf(orderId)));
    }

}

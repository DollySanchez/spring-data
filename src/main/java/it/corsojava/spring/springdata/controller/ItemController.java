package it.corsojava.spring.springdata.controller;

import it.corsojava.spring.springdata.model.Item;
import it.corsojava.spring.springdata.model.Order;
import it.corsojava.spring.springdata.repository.ItemRepository;
import it.corsojava.spring.springdata.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ItemController {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    OrderRepository orderRepository;

    @PostMapping("addItem")
    public void addItem(@RequestParam String orderId, String itemId){
         Order order = orderRepository.getById(Long.valueOf(orderId));
         Item item = itemRepository.getById(Long.valueOf(itemId));
         order.addItem(item);
         orderRepository.save(order);
     }

     @PostMapping("createItem")
    public void createItem(@RequestBody Item item){
         itemRepository.save(item);
     }

     @DeleteMapping("removeItem")
    public void removeItem(@RequestParam String itemId, String orderId){
        Order order = orderRepository.getById(Long.valueOf(orderId));
        order.removeItem(itemRepository.getById(Long.valueOf(itemId)));
        orderRepository.save(order);
     }

}

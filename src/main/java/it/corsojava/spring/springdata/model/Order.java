package it.corsojava.spring.springdata.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;

@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //private Integer code;
    private LocalDateTime orderDate;
    private LocalDateTime shippingDate;

    @ManyToMany (cascade = CascadeType.ALL)
    @JoinTable(
            name="ordini_item" ,
            joinColumns = @JoinColumn(name="order_id"),
            inverseJoinColumns = @JoinColumn(name="item_id"))
    private Set<Item> items ;

    private Float totalPrice=0F;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false, foreignKey = @ForeignKey(name = "fk_user_id"))
    @JsonIgnore
    private User user;

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return orderDate.format(formatter);
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public String getShippingDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return shippingDate.format(formatter);
    }

    public void setShippingDate(LocalDateTime shippingDate) {
        this.shippingDate = shippingDate;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

    public void addItem(Item item){
        this.items.add(item);
        this.totalPrice = totalPrice + item.getPrice();
    }
    public void removeItem(Item item){
        this.items.remove(item);
        this.totalPrice = totalPrice - item.getPrice();
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setDates(){
        this.orderDate=LocalDateTime.now();
        this.shippingDate=LocalDateTime.now().plusDays(3);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderDate=" + orderDate +
                ", shippingDate=" + shippingDate +
                ", items=" + items.size() +
                ", totalPrice=" + totalPrice +
                '}';
    }


}

package it.corsojava.spring.springdata.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //private Integer code;
    private String name;
    private Float price;

    @ManyToMany(mappedBy = "items")
    private Set<Order> orders;


    public Item() {
    }

    public Item(Long id, String name, Float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float prize) {
        this.price = prize;
    }


}

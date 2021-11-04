package it.corsojava.spring.springdata.repository;

import it.corsojava.spring.springdata.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}

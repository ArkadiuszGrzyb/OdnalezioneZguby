package org.example.odnalezionezguby.items;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Long> {

    Item findByName(String name);
    Optional<Item> findById(Long id);
    List<Item> findByNameContainingIgnoreCase(String name);
    Item save(Item item);
    Item deleteItemById(Long id);
}

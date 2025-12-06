package org.example.odnalezionezguby.items;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {

    Item findByName(String name);
    Item save(Item item);
    Item deleteItemById(Long id);
}

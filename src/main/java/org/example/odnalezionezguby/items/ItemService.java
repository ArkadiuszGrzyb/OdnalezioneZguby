package org.example.odnalezionezguby.items;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public Item findItemByName(String name){
        return itemRepository.findByName(name);
    }

    public Optional<Item> findById(Long id) {
        return itemRepository.findById(id);
    }

    public Item saveItem(Item item){
        return itemRepository.save(item);
    }

    public Item updateItem(Item item){
        return itemRepository.save(item);
    }

    public void deleteItemById(Long id){
         itemRepository.deleteItemById(id);
    }

    public List<Item> searchItemsByName(String name){
        return itemRepository.findByNameContainingIgnoreCase(name);
    }

}

package org.example.odnalezionezguby.items;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    public Item findItemByName(String name){
        return itemRepository.findByName(name);
    }

    public Item saveItem(Item item){
        return itemRepository.save(item);
    }

    public Item updateItem(Item item){
        return itemRepository.save(item);
    }

    public Item deleteItemById(Long id){
        return itemRepository.deleteItemById(id);
    }
}

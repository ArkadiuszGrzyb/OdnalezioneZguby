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

}

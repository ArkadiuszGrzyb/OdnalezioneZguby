package org.example.odnalezionezguby.items;

import lombok.RequiredArgsConstructor;
import org.example.odnalezionezguby.xml.XmlGenerator;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Item> searchItemsByName(String name){
        return itemRepository.findByNameContainingIgnoreCase(name);
    }

    public Item generateItemXml(String name){
        //@todo attach xml generator
        return findItemByName(name);
    }

}

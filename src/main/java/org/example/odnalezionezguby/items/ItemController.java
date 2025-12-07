package org.example.odnalezionezguby.items;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin()
@RestController
@RequestMapping("item")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    Logger logger = LoggerFactory.getLogger(ItemController.class);

    @GetMapping()
    public Item findItemByName(@RequestParam String name){
        logger.info("Received request to find item with name: {}", name);
        return itemService.findItemByName(name);
    }

    //@TODO implement pagination
    @GetMapping("/collection")
        public List<Item> searchItemsByName(@RequestParam String name){
        logger.info("Received request to search for items than contains in name: {}", name);
        return itemService.searchItemsByName(name);
    }

    @PostMapping()
    public Item saveItem(@RequestBody Item item){
        logger.info("Received request to save item with request body: {}", item);
        return itemService.saveItem(item);
    }

    @PutMapping()
    public ResponseEntity<?> updateItem(@RequestBody Item item){
        logger.info("Received request to update item with request body: {}", item);

        if (item.getId() == null) {
            return ResponseEntity.badRequest().body("Missing 'id' in request body");
        }
        return ResponseEntity.ok(itemService.updateItem(item));
    }

    @DeleteMapping()
    public Item deleteItem(@RequestParam Long id){
        logger.info("Received request to delete item with id: {}", id);
    return  itemService.deleteItemById(id);
    }
}

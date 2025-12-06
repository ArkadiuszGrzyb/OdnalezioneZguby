package org.example.odnalezionezguby.items;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("items")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping()
    public Item findItemByName(@RequestParam String name){
        return itemService.findItemByName(name);
    }


}

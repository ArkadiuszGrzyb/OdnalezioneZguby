package items;

import org.example.odnalezionezguby.OdnalezioneZgubyApplication;
import org.example.odnalezionezguby.items.Item;
import org.example.odnalezionezguby.items.ItemService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = OdnalezioneZgubyApplication.class)
@Transactional
public class ItemServiceTest {

    @Autowired
    private  ItemService itemService;

    @Test
    void findItemByName_returnsMatchingItem(){
        //given
        Item item = new Item();
        item.setName("Wallet");
        itemService.saveItem(item);

        //when
        Item result = itemService.findItemByName("Wallet");

        //then
        assertEquals("Wallet", result.getName());
    }

    @Test
    void saveItem_returnsSavedItem(){
        //given
        Item item = new Item();
        item.setName("Umbrella");
        item.setItemColor("Black");

        //when
        Item result = itemService.saveItem(item);

        //then
        assertEquals("Umbrella", result.getName());
        assertEquals("Black",result.getItemColor());
    }

    @Test
    void updateItem_returnsUpdatedItem(){
        //given
        Item item = new Item();
        item.setName("Before update");
        itemService.saveItem(item);

        //when
        item.setName("After update");
        Item result = itemService.updateItem(item);

        //then
        assertEquals("After update",result.getName());
    }

    @Test
    void deleteItemById_returnsDeletedItem(){
        //given
        Item item = new Item();
        item.setName("Delete me");
        Item itemToDelete = itemService.saveItem(item);

        //when
        Item result = itemService.deleteItemById(itemToDelete.getId());

        //then
        assertEquals(itemToDelete.getId(), result.getId());
        assertTrue(itemService.findById(itemToDelete.getId()).isEmpty());
    }

    @Test
    void searchItemsByName_returnsItemList(){
        //given
        Item firstItem = new Item();
        firstItem.setName("Bike first");
        itemService.saveItem(firstItem);

        Item secondItem = new Item();
        secondItem.setName("Bike second");
        itemService.saveItem(secondItem);

        //when
        List<Item> result = itemService.searchItemsByName("Bike");

        //then
        assertEquals(2, result.size());
        assertTrue(result.stream().anyMatch(item -> item.getName().equals("Bike first")));
        assertTrue(result.stream().anyMatch(item -> item.getName().equals("Bike second")));
    }

}

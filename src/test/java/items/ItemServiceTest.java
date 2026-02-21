package items;

import org.example.odnalezionezguby.OdnalezioneZgubyApplication;
import org.example.odnalezionezguby.items.Item;
import org.example.odnalezionezguby.items.ItemService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

}

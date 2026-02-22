package org.example.odnalezionezguby.items;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.mockito.Mockito.when;

@WebMvcTest(ItemController.class)
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemService itemService;

    @Test
    void getItemByName_returnsExpectedItem() throws Exception {
        //given
        Item mockItem = new Item();
        mockItem.setName("Wallet");

        //when
        when(itemService.findItemByName("Wallet")).thenReturn(mockItem);

        //then
        mockMvc.perform(get("/item")
                .param("name", "Wallet"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Wallet"));

    }
}

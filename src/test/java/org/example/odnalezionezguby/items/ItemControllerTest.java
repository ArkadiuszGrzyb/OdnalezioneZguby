package org.example.odnalezionezguby.items;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.mockito.Mockito.when;

@WebMvcTest(ItemController.class)
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemService itemService;

    @Autowired
    private ObjectMapper objectMapper;

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

    @Test
    void updateItem_missingId_returnsBadRequest() throws Exception {
        // given
        Item itemWithoutId = new Item();
        itemWithoutId.setName("Item without id");

        //when & then
        mockMvc.perform(put("/item")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(itemWithoutId)))
                .andExpect(status().isBadRequest());
    }


    @Test
    void updateItem_returnsUpdatedItem() throws Exception {
        //given
        Item itemToUpdate = new Item();
        itemToUpdate.setId(1L);
        itemToUpdate.setName("Updated");

        //when
        when(itemService.updateItem(itemToUpdate)).thenReturn(itemToUpdate);

        //then
        mockMvc.perform(put("/item")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(itemToUpdate)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Updated"));
    }
}

package com.example.Book_Store;


import com.example.Book_Store.controller.MyUnit;
import com.example.Book_Store.model.Book;
import com.example.Book_Store.model.Genre;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ControllerTest {
    @Autowired
    private WebApplicationContext webApplicationContext;
    @Autowired
    private MockMvc mockMvc;



    @Test
    public void testIndex() throws Exception {
                           this.mockMvc.perform(get("/"))
                                          .andExpect(status().isOk());
    }


    @Test
    public void doTest() throws Exception {
        mockMvc.perform(get("/books"))
                .andExpect(status().isOk());
    }
    @Test
    public void testConcatenate() {
        MyUnit myUnit = new MyUnit();

        String result = myUnit.concatenate("one", "two");

        assertEquals("onetwo", result);

    }
    @Test
    public void testCreate() throws Exception{
        ObjectMapper mapper = new ObjectMapper();

        Book product = new Book("Morgan","Friemann",new Genre(2));
        mapper.writeValue(new File("person.json"), product);
        String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(product);

        mockMvc.perform(post("/createBooks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(new Gson().toJson(product)))
                .andExpect(status().isOk());




    }

    @Test
    public void testDelete() throws Exception{
        Book product = new Book(27);
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(product);
        mockMvc.perform(delete("/deleteEmpById")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(new Gson().toJson(product)))
                .andExpect(status().isOk());

    }

    @Test
    public void testUpdate() throws Exception{
        Book product = new Book(22,"Morgan","Friemann",new Genre(51,"Yeha"));
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(product);
        mockMvc.perform(put("/updateBooks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(new Gson().toJson(product)))
                .andExpect(status().isOk());

    }

}

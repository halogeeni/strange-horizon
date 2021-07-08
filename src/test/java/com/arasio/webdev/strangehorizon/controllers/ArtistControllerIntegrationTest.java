package com.arasio.webdev.strangehorizon.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.arasio.webdev.strangehorizon.DatabaseIntegrationTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration
@AutoConfigureMockMvc
public class ArtistControllerIntegrationTest extends DatabaseIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetArtists() throws Exception {
        mockMvc.perform(get("/artists"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.length()").value(4))
            .andExpect(jsonPath("$[0].id").value(1))
            .andExpect(jsonPath("$[0].name").value("You Can't Keep Me Down"))
            .andExpect(jsonPath("$[0].description").value("Dark Ojamo Hardcore"))
            .andExpect(jsonPath("$[1].id").value(2))
            .andExpect(jsonPath("$[1].name").value("Vässykät"))
            .andExpect(jsonPath("$[1].description").value("Melodic Punk Rock"))
            .andExpect(jsonPath("$[2].id").value(3))
            .andExpect(jsonPath("$[2].name").value("Vile Fate"))
            .andExpect(jsonPath("$[2].description").value("TKU-LOHJA 4 LIFE!"))
            .andExpect(jsonPath("$[3].id").value(4))
            .andExpect(jsonPath("$[3].name").value("Born To Cry"))
            .andExpect(jsonPath("$[3].description").value("Doom Hardcore"));
    }

    @Test
    public void testGetArtistById() throws Exception {
        mockMvc.perform(get("/artists/1"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(1))
            .andExpect(jsonPath("$.name").value("You Can't Keep Me Down"))
            .andExpect(jsonPath("$.description").value("Dark Ojamo Hardcore"));
    }

    @Test
    public void testGetArtistById_shouldReturn404IfNotFound() throws Exception {
        mockMvc.perform(get("/artists/999")).andExpect(status().is(404));
    }
}

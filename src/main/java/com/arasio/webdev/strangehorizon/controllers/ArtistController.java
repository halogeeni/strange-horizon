package com.arasio.webdev.strangehorizon.controllers;

import com.arasio.webdev.strangehorizon.models.ArtistDTO;
import com.arasio.webdev.strangehorizon.services.ArtistService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/artists")
public class ArtistController {

    @Autowired
    private ArtistService artistService;

    @GetMapping
    public ResponseEntity<List<ArtistDTO>> getArtists() {
        final List<ArtistDTO> artists = artistService.getArtists();
        return new ResponseEntity<List<ArtistDTO>>(artists, HttpStatus.OK);
    }
}

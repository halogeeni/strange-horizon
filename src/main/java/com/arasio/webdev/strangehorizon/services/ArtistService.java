package com.arasio.webdev.strangehorizon.services;

import com.arasio.webdev.strangehorizon.models.ArtistDTO;
import com.arasio.webdev.strangehorizon.repositories.ArtistRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistService {

    @Autowired
    private ArtistRepository artistRepository;

    public List<ArtistDTO> getArtists() {
        return artistRepository.getArtists().stream()
            .map(artistEntity -> new ArtistDTO(artistEntity.getName(), artistEntity.getDescription()))
            .collect(Collectors.toList());
    }
}

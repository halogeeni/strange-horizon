package com.arasio.webdev.strangehorizon.repositories;

import com.arasio.webdev.strangehorizon.models.ArtistEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ArtistRepository extends JpaRepository<ArtistEntity, Integer> {

    @Query(value = "SELECT * FROM artists", nativeQuery = true)
    List<ArtistEntity> getArtists();
}

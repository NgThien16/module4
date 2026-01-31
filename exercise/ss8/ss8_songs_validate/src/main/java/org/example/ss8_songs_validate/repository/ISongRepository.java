package org.example.ss8_songs_validate.repository;

import org.example.ss8_songs_validate.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISongRepository extends JpaRepository<Song,Integer> {
}

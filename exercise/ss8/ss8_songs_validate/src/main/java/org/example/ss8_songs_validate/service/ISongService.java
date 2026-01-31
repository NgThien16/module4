package org.example.ss8_songs_validate.service;

import org.example.ss8_songs_validate.entity.Song;

public interface ISongService {
     void save(Song song);
     boolean update(Song song);
     Song findById(Integer id);
}

package org.example.ss8_songs_validate.service;

import org.example.ss8_songs_validate.entity.Song;
import org.example.ss8_songs_validate.repository.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SongService implements ISongService{
    @Autowired
    private ISongRepository songRepository;
    @Override
    public void save(Song song) {
        songRepository.save(song);
    }

    @Override
    public boolean update(Song song) {
        if(songRepository.findById(song.getId()).isPresent()){
            songRepository.save(song);
        }
        return false;
    }

    @Override
    public Song findById(Integer id) {
        return null;
    }
}

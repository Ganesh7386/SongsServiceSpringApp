package com.example.song;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.*;
import java.util.*;

@RestController
public class SongController {
    public SongService mySongService;

    SongController() {
        this.mySongService = new SongService();
    }

    @GetMapping("/songs")
    public ArrayList<Song> getAllSongsOfPlaylist() {
        return mySongService.getAllSongsOfPlayList();
    }

    @PostMapping("/songs")
    public Song addNewSongToPlaylist(@RequestBody Song song) {
        Song newSong = mySongService.addNewSong(song);
        return newSong;
    }

    @GetMapping("/songs/{songId}")
    public Song getSongBasedOnGivenId(@PathVariable int songId) {
        Song existingSong = mySongService.getSongBasedOnGivenId(songId);
        if (existingSong == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return existingSong;
    }

    @PutMapping("/songs/{songId}")
    public Song modifySongBasedOnGivenId(@PathVariable int songId, @RequestBody Song givenSong) {
        Song modifiedSong = mySongService.modifySongBasedOnGivenId(songId, givenSong);

        if (modifiedSong == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return modifiedSong;

    }

    @DeleteMapping("/songs/{songId}")
    public ResponseEntity<Void> deleteSongBasedOnGivenId(@PathVariable int songId) {
        Boolean isDeleted = mySongService.deleteSongBasedOnGivenId(songId);
        if (isDeleted == false) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.noContent().build();

    }
}
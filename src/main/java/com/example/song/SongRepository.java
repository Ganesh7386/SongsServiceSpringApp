package com.example.song;

import java.util.*;

public interface SongRepository {
    public ArrayList<Song> getAllSongsOfPlayList();

    public Song addNewSong(Song newSong);

    public Song getSongBasedOnGivenId(int songId);

    public Song modifySongBasedOnGivenId(int songId, Song givenSong);

    public Boolean deleteSongBasedOnGivenId(int songId);
}
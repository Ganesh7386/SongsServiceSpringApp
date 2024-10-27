/*

 * You can use the following import statements
  
 * import org.springframework.http.HttpStatus;
 * import org.springframework.web.server.ResponseStatusException;

 */

package com.example.song;

import java.util.*;

// import com.example.song.Song;
// import com.example.song.SongRepository;

// Don't modify the below code
public class SongService implements SongRepository {
    private static HashMap<Integer, Song> playlist = new HashMap<>();

    public SongService() {
        playlist.put(1, new Song(1, "Butta Bomma", "Ramajogayya Sastry", "Armaan Malik", "Thaman S"));
        playlist.put(2, new Song(2, "Kathari Poovazhagi", "Vijay", "Benny Dayal, Swetha Mohan", "A.R. Rahman"));
        playlist.put(3, new Song(3, "Tum Hi Ho", "Mithoon", "Arijit Singh", "Mithoon"));
        playlist.put(4, new Song(4, "Vizhiyil", "Vairamuthu", "Unni Menon", "A.R. Rahman"));
        playlist.put(5, new Song(5, "Nenjame", "Panchu Arunachalam", "S.P.Balasubrahmanyam", "Ilaiyaraaja"));
    }

    // Don't modify the above code
    @Override
    public ArrayList<Song> getAllSongsOfPlayList() {
        Collection<Song> co = playlist.values();
        ArrayList<Song> listOfSongs = new ArrayList<>(co);
        return listOfSongs;
    }

    @Override
    public Song addNewSong(Song song) {
        int newId = playlist.size() + 1;
        String songName = song.getSongName();
        String lyricist = song.getLyricist();
        String singer = song.getSinger();
        String musicDirector = song.getMusicDirector();
        Song newSong = new Song(newId, songName, lyricist, singer, musicDirector);
        playlist.put(newId, newSong);
        return newSong;
    }

    @Override
    public Song getSongBasedOnGivenId(int songId) {
        Song existingSong = playlist.get(songId);
        if (existingSong == null) {
            return null;
        }
        return existingSong;
    }

    @Override
    public Song modifySongBasedOnGivenId(int songId, Song givenSong) {
        Song existingSong = playlist.get(songId);
        if (existingSong == null) {
            return null;
        }
        if (givenSong.getSongName() != null) {
            existingSong.setSongName(givenSong.getSongName());
        }

        if (givenSong.getLyricist() != null) {
            existingSong.setLyricist(givenSong.getLyricist());
        }
        if (givenSong.getSinger() != null) {
            existingSong.setSinger(givenSong.getSinger());
        }

        if (givenSong.getMusicDirector() != null) {
            existingSong.setMusicDirector(givenSong.getMusicDirector());
        }
        playlist.put(songId, existingSong);
        return existingSong;
    }

    @Override
    public Boolean deleteSongBasedOnGivenId(int songId) {
        Song existinSong = playlist.get(songId);
        if (existinSong == null) {
            return false;
        }

        playlist.remove(songId);
        return true;

    }

}
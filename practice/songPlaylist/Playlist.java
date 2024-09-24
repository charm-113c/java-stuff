package songPlaylist;

import java.util.HashSet;

public class Playlist {
    public HashSet<Song> playlist;

    public Playlist(HashSet<Song> playlist) {
        this.playlist = playlist;
    }

    public String toString() {
        String s = "";
        int i = 1;
        for (Song song : playlist) {
            s += "\nSong n°" + i +"\n";
            s += song.toString();
            i++;
        }
        return s;
    }
}

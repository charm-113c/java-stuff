package songPlaylist;

/**
 * Build a class Song whose instances are constructed with a song title 
 * and an author name. 
 * Create a class Playlist which contains a collection of Songs. In a first 
 * implementation, use HashSet to store Songs. Implement `equals` and `hashCode`
 * so as to avoid duplicates. 
 * The class will have a method toString which returns a string representation 
 * of the song. 
 */

public class Song implements Comparable<Song>{
    private String title;
    private String author;

    public Song(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String toString() {
        String s = "Song title: " + this.title;
        String s1 = "\nAuthor: " + this.author;
        return s + s1;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if ((o == null) || (!this.getClass().equals(o.getClass()))) { return false; }
        // downcast o to Song
        Song s = (Song)o;
        return ((this.title == s.getTitle()) && (this.author == s.getAuthor())); 
    }

    @Override
    public int hashCode() {
        final int prime = 7;
        int hash = 31 * prime + title.hashCode();
        hash = hash * prime + author.hashCode();
        return hash;
    }

    @Override
    public int compareTo(Song s) {
        if (s == null) return 1; // >=
        if (this.equals(s)) return 0;
        // compare titles, and if equality compare authors
        return 1;
    }
}

package UserSongs;
import java.util.*;

public class RecentlyPlayedStore {
    private int capacity;
    private Map<String, String> songUserMap;
    private List<String> recentlyPlayed;

    public RecentlyPlayedStore(int capacity) {
        this.capacity = capacity;
        this.songUserMap = new HashMap<>();
        this.recentlyPlayed = new LinkedList<>();
    }

    public void playSong(String song, String user) {
        songUserMap.put(song, user);
        recentlyPlayed.remove(song);
        recentlyPlayed.add(0, song);

        if (recentlyPlayed.size() > capacity) {
            String leastRecentlyPlayed = recentlyPlayed.remove(recentlyPlayed.size() - 1);
            songUserMap.remove(leastRecentlyPlayed);
        }
    }

    public List<String> getRecentlyPlayedSongs(String user) {
        List<String> userSongs = new ArrayList<>();
        for (String song : recentlyPlayed) {
            if (songUserMap.get(song).equals(user)) {
                userSongs.add(song);
            }
        }
        return userSongs;
    }
}
package Testcase_UserSongs;

import static org.testng.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import UserSongs.RecentlyPlayedStore;

import java.util.List;

class RecentlyPlayedStoreTest {

    @org.testng.annotations.Test
   public void testRecentlyPlayedStore() {
    	RecentlyPlayedStore store = new RecentlyPlayedStore(3);

        store.playSong("S1", "User1");
        store.playSong("S2", "User1");
        store.playSong("S3", "User1");

        List<String> user1Songs = store.getRecentlyPlayedSongs("User1");
        assertEquals(List.of("S3", "S2", "S1"), user1Songs);

        store.playSong("S4", "User1");

        user1Songs = store.getRecentlyPlayedSongs("User1");
        assertEquals(List.of("S4", "S3", "S2"), user1Songs);

        List<String> user2Songs = store.getRecentlyPlayedSongs("User2");
        assertEquals(List.of(), user2Songs);
    }
}
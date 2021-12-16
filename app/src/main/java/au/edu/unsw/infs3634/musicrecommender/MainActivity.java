package au.edu.unsw.infs3634.musicrecommender;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SongAdapter songAdapter;
    private List<Song> mySongs;
    private RecyclerView recyclerView;

    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // store and show item rows of songs in a RecyclerView
        mySongs = Song.getSongs();
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        // clicking on one of the songs to go into the song's respective activity
        SongAdapter.ClickListener listener = new SongAdapter.ClickListener() {
            @Override
            public void onSongClick(View view, String songID) {
                Intent intent = new Intent(MainActivity.this, SongActivity.class);
                intent.putExtra("Song ID", songID);
                startActivity(intent);

            }
        };

        songAdapter = new SongAdapter(mySongs, listener);
        recyclerView.setAdapter(songAdapter);

    }

    // method to allow the user to search for keywords in search bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.app_bar_search).getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                songAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                songAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }

    // method to sort items based on many categories
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.sort_reset:
                // reset sort
                songAdapter.sort(0);
                return true;
            case R.id.sort_song_name:
                // sort by song name (A to Z)
                songAdapter.sort(1);
                return true;
            case R.id.sort_song_artist:
                // sort by artist (A to Z)
                songAdapter.sort(2);
                return true;
            case R.id.sort_song_genre:
                // sort by genre (A to Z)
                songAdapter.sort(3);
                return true;
            case R.id.sort_song_rating:
                // sort by rating (Ascending order)
                songAdapter.sort(4);
                return true;
            case R.id.sort_song_name_des:
                // sort by song name (Z to A)
                songAdapter.sort(5);
                return true;
            case R.id.sort_song_artist_des:
                // sort by artist (Z to A)
                songAdapter.sort(6);
                return true;
            case R.id.sort_song_genre_des:
                // sort by genre (Z to A)
                songAdapter.sort(7);
                return true;
            case R.id.sort_song_rating_des:
                // sort by rating (Descending order)
                songAdapter.sort(8);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
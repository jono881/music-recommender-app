package au.edu.unsw.infs3634.musicrecommender;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.ArrayList;

public class SongActivity extends AppCompatActivity {

    private static final String TAG = "SongActivity";

    TextView songLabel;
    TextView artistLabel;
    TextView genreLabel;
    TextView descriptionLabel;
    ImageView image;
    YouTubePlayerView youTubePlayerView;
    RatingBar ratingBar;
    Button lyricsButton;
    Button rateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_song);

        // method to instantiate the back button in the menu
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // method to display all the song's respective info
        showSongDetails();
        // method for video clip to appear
        getVideo();
        // method for lyrics button when it's pressed
        getLyrics();
        // method to change song rating
        changeSongRating();


    }

    // displays video on this activity
    public void getVideo(){
        Intent intent = getIntent();
        String videoLink = intent.getStringExtra("Video");


        youTubePlayerView = findViewById(R.id.video_player);

        // sets the videoID for the youTubePlayerView to play the song's specific video
        getLifecycle().addObserver(youTubePlayerView);
        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(YouTubePlayer youTubePlayer) {
                String videoID = videoLink.replaceAll("https://youtu.be/","");
                youTubePlayer.cueVideo(videoID, 0);
            }
        });
    }

    public void getLyrics(){
        Intent intent = getIntent();
        String lyrics = intent.getStringExtra("Lyrics");

        lyricsButton = findViewById(R.id.lyrics_button);
        lyricsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Code here executes on main thread after user presses button
                Log.d(TAG,  "onCreate: Open song video");
                Uri webpage = Uri.parse(lyrics);
                Intent intent1 = new Intent(Intent.ACTION_VIEW, webpage);
                startActivity(intent1);
            }
        });
    }


    public void showSongDetails(){
        // receives intent containing message from Main Activity
        Intent intent = getIntent();
        String songID = intent.getStringExtra("Song ID");

        // accessing ArrayList of all the songs stored in Song class
        ArrayList<Song> songList = Song.getSongs();

        songLabel = findViewById(R.id.song_name);
        artistLabel = findViewById(R.id.song_artist);
        genreLabel = findViewById(R.id.song_genre);
        descriptionLabel = findViewById(R.id.song_description);
        image = findViewById(R.id.song_image);
        ratingBar = findViewById(R.id.rating_bar);

        // iterate through all the song objects in ArrayList to find a song ID that matches with songID
        for (Song song: songList){
            if(songID.equals(song.getSongID())){

                // set the text for the TextView widgets
                songLabel.setText(song.getSongName());
                artistLabel.setText(song.getArtist());
                genreLabel.setText(song.getGenre());
                descriptionLabel.setText(song.getDescription());
                image.setImageResource(song.getImage());
                ratingBar.setRating((float) song.getRating());

                // set a new message in intent, can be opened by onCreate method
                intent.putExtra("Lyrics", song.getLyricLink());
                intent.putExtra("Video", song.getVideoLink());
            }
        }

    }

    public void changeSongRating(){

        rateButton = findViewById(R.id.rating_button);
        ratingBar = findViewById(R.id.rating_bar);
        rateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // show updated rating through an additional message
                String ratingString = String.valueOf(ratingBar.getRating());
                Toast.makeText(getApplicationContext(), "Rating has been updated to " + ratingString + " stars", Toast.LENGTH_SHORT).show();
            }
        });

        // receives intent containing message from Main Activity
        Intent intent = getIntent();
        String songID = intent.getStringExtra("Song ID");
        Float ratingValue = ratingBar.getRating();


        // accessing ArrayList of all the songs stored in Song class
        ArrayList<Song> songList = Song.getSongs();

        // iterate through all the song objects in ArrayList to find a song ID that matches with songID
        for (Song song: songList){
            if(songID.equals(song.getSongID())){
                song.setRating(ratingValue);
            }
        }

    }

    // method to use back button in the menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:

                Intent intent = new Intent(SongActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
package au.edu.unsw.infs3634.musicrecommender;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.MyViewHolder> implements Filterable{

    private List<Song> mySongs;
    private List<Song> mySongsFiltered;
    private ClickListener listener;

    SongAdapter(List<Song> songs, ClickListener listener){
        this.mySongs = songs;
        this.mySongsFiltered = songs;
        this.listener = listener;
    }


    // used to search for song names, artists and genres
    @Override
    public Filter getFilter(){
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if(charString.isEmpty()){
                    mySongsFiltered = mySongs;
                }
                else{
                    ArrayList<Song> filteredList = new ArrayList<>();
                    for(Song song: mySongs){
                        if(song.getSongName().toLowerCase().contains(charString.toLowerCase())){
                            filteredList.add(song);
                        }
                        else if(song.getArtist().toLowerCase().contains(charString.toLowerCase())){
                            filteredList.add(song);
                        }
                        else if(song.getGenre().toLowerCase().contains(charString.toLowerCase())){
                            filteredList.add(song);
                        }
                    }
                    mySongsFiltered = filteredList;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = mySongsFiltered;
                return filterResults;
            }

            // method to show the filtered results in the RecyclerView
            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                mySongsFiltered = (ArrayList<Song>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    // method to allow the songs in the RecyclerView to be clickable to access their details
    public interface ClickListener{
        void onSongClick(View view, String songID);
    }

    @NonNull
    @Override
    public SongAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.song_row, parent, false);
        return new MyViewHolder(view, listener);
    }

    // method to set key information for each song in RecyclerView such as the song name, artist, genre, rating and album cover
    @Override
    public void onBindViewHolder(@NonNull SongAdapter.MyViewHolder holder, int position) {
        final Song song = mySongsFiltered.get(position);
        holder.title.setText(song.getSongName());
        holder.artist.setText(song.getArtist());
        holder.genre.setText(song.getGenre());
        holder.ratingBar.setRating((float) song.getRating());
        holder.image.setImageResource(song.getImage());
        holder.itemView.setTag(song.getSongID());
    }

    // method to count the number of songs in the mySongsFiltered list
    @Override
    public int getItemCount() {
        return mySongsFiltered.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView title, artist, genre, rating;
        public ImageView image;
        public RatingBar ratingBar;
        private ClickListener listener;

        public MyViewHolder(@NonNull View itemView, ClickListener listener) {
            super(itemView);
            this.listener = listener;
            itemView.setOnClickListener(MyViewHolder.this);

            title = itemView.findViewById(R.id.song_title);
            artist = itemView.findViewById(R.id.artist_label);
            genre = itemView.findViewById(R.id.genre_label);
            image = itemView.findViewById(R.id.songCover);
            ratingBar = itemView.findViewById(R.id.rating_bar_rc);
        }

        @Override
        public void onClick(View view) {
            listener.onSongClick(view, (String) view.getTag());
        }
    }

    // sort method called by the main activity
    public void sort(final int sortMethod){
        if(mySongsFiltered.size() > 0){
            Collections.sort(mySongsFiltered, new Comparator<Song>() {
                @Override
                public int compare(Song s1, Song s2) {
                    // resets the sort to initial view
                    if(sortMethod == 0){
                        return s1.getSongID().compareTo(s2.getSongID());
                    }
                    // sorts the songs by song name in alphabetical order
                    if(sortMethod == 1 | sortMethod == 5){
                        return s1.getSongName().compareTo(s2.getSongName());
                    }
                    // sorts the songs by artist in alphabetical order
                    else if(sortMethod == 2 | sortMethod == 6){
                        return s1.getArtist().compareTo(s2.getArtist());
                    }
                    // sorts the songs by genre in alphabetical order
                    else if(sortMethod == 3 | sortMethod == 7){
                        return s1.getGenre().compareTo(s2.getGenre());
                    }
                    // sorts the songs by rating in ascending order
                    else if(sortMethod == 4 | sortMethod == 8){
                        return Double.compare(s1.getRating(), s2.getRating());
                    }
                    return 0;
                }
            });

            // if statement to reverse the order for each category when the sortMethod value exceeds 4
            if(sortMethod > 4) {
                Collections.reverse(mySongsFiltered);
            }


        }
        notifyDataSetChanged();
    }
}

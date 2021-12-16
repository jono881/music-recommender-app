package au.edu.unsw.infs3634.musicrecommender;

import java.util.ArrayList;

public class Song {

    private String songID;
    private String songName;
    private String artist;
    private double rating;
    private String genre;
    private String description;
    private int image;
    private String lyricLink;
    private String videoLink;

    public Song(String songID, String songName, String artist, double rating, String genre, String description, int image, String lyricLink, String videoLink) {
        this.songID = songID;
        this.songName = songName;
        this.artist = artist;
        this.rating = rating;
        this.genre = genre;
        this.description = description;
        this.image = image;
        this.lyricLink = lyricLink;
        this.videoLink = videoLink;
    }

    public String getSongID() {
        return songID;
    }

    public void setSongID(String songID) {
        this.songID = songID;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getLyricLink() {
        return lyricLink;
    }

    public void setLyricLink(String lyricLink) {
        this.lyricLink = lyricLink;
    }

    public String getVideoLink() {
        return videoLink;
    }

    public void setVideoLink(String videoLink) {
        this.videoLink = videoLink;
    }

    public static ArrayList<Song> getSongs(){

        ArrayList<Song> songs = new ArrayList<>();
        songs.add(new Song("1", "Summertime In Paris", "Jaden", 4.5, "Indie", "Jaden and Willow Smith debut terrible new song “Summertime in Paris” on Ellen", R.drawable.jaden, "https://genius.com/Jaden-summertime-in-paris-lyrics", "https://youtu.be/8rL4jorQlXw"));
        songs.add(new Song("2", "BAE BAE", "BIGBANG", 3, "K-Pop", "BAE BAE is a song recorded by South Korean boy band Big Bang. It was released as a digital single on May 1, 2015 through YG Entertainment, serving as one of the eight lead singles from the band's third Korean-language studio album Made (2016).", R.drawable.bigbang, "https://genius.com/Bigbang-bae-bae-lyrics", "https://youtu.be/YBp-0d74q20"));
        songs.add(new Song("3", "Love Me Harder", "Ariana Grande", 1.5, "Pop", "Love Me Harder is a song by American singer Ariana Grande and Canadian singer The Weeknd from Grande's second studio album, My Everything (2014).", R.drawable.ariana, "https://genius.com/Ariana-grande-and-the-weeknd-love-me-harder-lyrics", "https://youtu.be/szGomck3sZI"));
        songs.add(new Song("4", "Friday", "Riton", 2.5, "EDM", "Friday, also known as Friday (Dopamine Re-Edit), is a song recorded by English DJ and producer Riton and Scottish house music project Nightcrawlers featuring internet personalities Mufasa & Hypeman with uncredited vocals by Samantha Harper.", R.drawable.friday, "https://genius.com/Riton-and-nightcrawlers-friday-dopamine-re-edit-lyrics", "https://youtu.be/U6n2NcJ7rLc"));
        songs.add(new Song("5", "Only Girl (In The World)", "Rihanna", 4, "Pop", "Only Girl (In the World) is a song by Barbadian singer Rihanna from her fifth album, Loud (2010). The album's lead single, it was released on September 10, 2010.", R.drawable.rihanna, "https://genius.com/Rihanna-only-girl-in-the-world-lyrics", "https://youtu.be/pa14VNsdSYM"));
        songs.add(new Song("6", "Swimming Pools (Drank)", "Kendrick Lamar", 5, "Rap", "Swimming Pools (Drank) is a song by American rapper Kendrick Lamar. It was released on July 31, 2012 as the lead single (second overall) from his major-label debut studio album Good Kid, M.A.A.D City (2012), by Top Dawg, Aftermath and Interscope. ", R.drawable.kendrick, "https://genius.com/Kendrick-lamar-swimming-pools-drank-lyrics", "https://youtu.be/U96f24ueBAo"));
        songs.add(new Song("7", "No Other Name", "Hillsong Worship", 3.5, "Christian", "No Other Name is the 23rd worship album by Hillsong released on 27 June 2014 in Australia and New Zealand and released on 1 July 2014 worldwide", R.drawable.hillsong, "https://genius.com/Hillsong-worship-no-other-name-live-lyrics", "https://youtu.be/Wku9OphQ7JE"));
        songs.add(new Song("8", "The Avengers", "Alan Silvestri", 0.5, "Soundtrack", "The Avengers (Original Motion Picture Soundtrack) is the film score for the Marvel Studios film The Avengers by Alan Silvestri. It was released by Hollywood Records on May 1, 2012.", R.drawable.avengers, "https://genius.com/Hillsong-worship-no-other-name-live-lyrics", "https://youtu.be/QtxeJ703w18"));
        songs.add(new Song("9", "Save Your Tears", "The Weeknd", 1.5, "Disco", "Save Your Tears is a song by Canadian singer the Weeknd from his fourth studio album, After Hours (2020).", R.drawable.weeknd, "https://genius.com/The-weeknd-save-your-tears-lyrics", "https://youtu.be/XXYlFuWEuKI"));
        songs.add(new Song("10", "Writer In The Dark", "Lorde", 2, "Pop", "Writer in the Dark is a song recorded by New Zealand singer-songwriter Lorde for her second album Melodrama (2017). She co-wrote and co-produced the track with Jack Antonoff. ", R.drawable.lorde, "https://genius.com/Lorde-writer-in-the-dark-lyrics", "https://youtu.be/H1Wevfw_Nxk"));
        songs.add(new Song("11", "Back to You", "WILD", 3.5, "Indie", "Back to You is a song by an indie band called WILD", R.drawable.wild, "https://genius.com/Wild-back-to-you-lyrics", "https://youtu.be/MTmzClD7rXc"));
        songs.add(new Song("12", "Windflower", "MAMAMOO", 5,"K-Pop", "Wind Flower is about regretting a breakup and missing a former lover, but also slowly getting better and moving on.", R.drawable.mamamoo, "https://genius.com/Genius-english-translations-mamamoo-wind-flower-english-translation-lyrics", "https://youtu.be/uOZ2r_UAfdc"));
        songs.add(new Song("13", "Prey", "The Neighbourhood", 1, "Rock", "Prey is the second song by American alternative band The Neighbourhood from their second studio album, Wiped Out!. ", R.drawable.prey, "https://genius.com/The-neighbourhood-prey-lyrics", "https://youtu.be/2IE3T9mcqyM"));
        songs.add(new Song("14", "Leave the Door Open", "Bruno Mars", 4.5, "Pop", "Leave the Door Open is the debut single by the American super-duo Silk Sonic, consisting of Bruno Mars and Anderson .Paak.", R.drawable.bruno, "https://genius.com/Silk-sonic-leave-the-door-open-lyrics", "https://youtu.be/adLGHcj_fmA"));
        songs.add(new Song("15", "Rocketeer", "Far East Movement", 3, "EDM", "Rocketeer is a song by American hip hop and electronic music group Far East Movement from their third studio album, Free Wired (2010).", R.drawable.rocketeer, "https://genius.com/Far-east-movement-rocketeer-lyrics", "https://youtu.be/KGSd68hM_qQ"));
        return songs;
    }

}

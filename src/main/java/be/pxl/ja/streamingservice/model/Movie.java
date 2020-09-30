package be.pxl.ja.streamingservice.model;

import java.time.LocalDate;

public class Movie extends Content implements Playable {
    private String director;
    private LocalDate releaseDate;
    private int duration;
    private Genre genre;
    public static final int LONG_PLAYING_TIME = 2*60+15;

    public Movie(String title, Rating maturityRating){
        super(title, maturityRating);
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public void Play() {
        System.out.println("Playing " + this);
    }

    @Override
    public void Pause(){
        System.out.println("Pausing " + this);
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public boolean isLongPlayingTime(){
        return duration >= LONG_PLAYING_TIME;
    }

    public String getPlayingTime(){

        if(duration == 0){
            return "?";
        } else if(duration < 60){
            return String.format("%d min", duration);
        } else if(duration % 60 == 0){
            return String.format("%d u", duration / 60);
        } else {
            return String.format("%d u %d min", duration / 60, duration % 60);
        }
    }
}

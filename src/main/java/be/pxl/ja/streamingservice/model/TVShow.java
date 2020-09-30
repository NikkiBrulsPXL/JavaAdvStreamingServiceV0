package be.pxl.ja.streamingservice.model;

public class TVShow extends Chapter1.Ex1.Content {

    private int numberOfSeasons;

    public TVShow(String title, Chapter1.Ex1.Rating maturityRating, int numberOfSeasons){
        super(title, maturityRating);
        this.numberOfSeasons = numberOfSeasons;
    }

    public int getNumberOfSeasons(){
        return numberOfSeasons;
    }
}

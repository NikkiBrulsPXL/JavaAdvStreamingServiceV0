package be.pxl.ja.streamingservice.model;

public abstract class Content {

    private String title;
    private Rating maturityRating;
    private String imageUrl;

    public Content(String title, Rating maturityRating){
        this.title = title;
        this.maturityRating = maturityRating;
    }

    public Rating getMaturityRating(){
        return this.maturityRating;
    }

    public String getTitle(){
        return this.title;
    }

    public String getImageUrl(){
        return this.imageUrl;
    }

    public void setImageUrl(String imageUrl){
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString(){
        return "ok";
    }
}

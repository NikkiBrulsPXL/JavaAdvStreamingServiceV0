package be.pxl.ja.streamingservice.model;

public class Documentary extends Movie {

    private String topic;

    public Documentary(String docTitle, Rating maturityRating){
        super(docTitle, maturityRating);
        setGenre(Genre.DOCUMENTARY);
    }

    public String getTopic(){
        return topic;
    }

    public void setTopic(String topic){
        this.topic = topic;
    }

    @Override
    public void Play(){
        System.out.println("Playing topic: " + getTopic());
    }

    @Override
    public void Pause(){
        System.out.println("Pausing topic: " + getTopic());
    }
}

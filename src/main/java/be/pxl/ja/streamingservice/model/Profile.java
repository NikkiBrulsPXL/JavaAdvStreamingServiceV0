package be.pxl.ja.streamingservice.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Profile{

    private String name;
    private LocalDate dateOfBirth;

    public Profile(String name, LocalDate dateOfBirth){
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public Profile(String name){
        this(name, null);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getAge(){
        if(dateOfBirth == null){
            return -1;
        }
        return (int) ChronoUnit.YEARS.between(dateOfBirth, LocalDate.now());
    }

    public boolean allowedToWatch(Content content){
        int minimumAge = content.getMaturityRating().getMinimumAge();
        return getAge() >= minimumAge;
    }
}

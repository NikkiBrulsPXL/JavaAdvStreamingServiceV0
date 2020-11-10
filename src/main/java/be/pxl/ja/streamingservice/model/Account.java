package be.pxl.ja.streamingservice.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Account{
    private String email;
    private String password;
    private PaymentInfo paymentInfo;
    private StreamingPlan streamingPlan;
    private List<Profile> profiles;

    public Account(String email, String password){
        this.email = email;
        this.password = password;
        profiles = new ArrayList<>();
        addProfile(new Profile("profile1"));

    }

    public void setStreamingPlan(StreamingPlan streamingPlan) {
        this.streamingPlan = streamingPlan;
    }

    public void addProfile(Profile profile){
        profiles.add(profile);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;

    }

    public boolean verifyPassword(String password){
        return this.password.equals(password);
    }

    public void setPaymentInfo(PaymentInfo paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    public Profile getFirstProfile() {
        return profiles.get(0);
    }
}

package be.pxl.ja.streamingservice.util;

import be.pxl.ja.streamingservice.model.Profile;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProfileGetAgeTest {
    private static final LocalDate DATE1 = LocalDate.of(1999,1,11);
    private static final LocalDate DATE2 = LocalDate.of(1984,10,13);
    private static final LocalDate DATE3 = LocalDate.of(2012,10,1);
    private Profile profile = new Profile("test");

    @Test
    public void shouldReturnCorrectAgeForPastBirthdayThisYear(){

        profile.setDateOfBirth(DATE1);

        assertEquals(ChronoUnit.YEARS.between(DATE1,LocalDate.now()), profile.getAge());
    }

    @Test
    public void shouldReturnCorrectAgeForNotPastBirthdayThisYear(){

        profile.setDateOfBirth(DATE2);

        assertEquals(ChronoUnit.YEARS.between(DATE2, LocalDate.now()), profile.getAge());
    }

    @Test
    public void shouldReturnCorrectAgeForBirthdayToday(){

        profile.setDateOfBirth(DATE3);

        assertEquals(ChronoUnit.YEARS.between(DATE3, LocalDate.now()), profile.getAge());
    }

    @Test
    public void shouldReturnMinusOneWhenDateOfBirthIsNotSet(){

        assertEquals(-1, profile.getAge());
    }
}

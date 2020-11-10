package be.pxl.ja.streamingservice.util;

import be.pxl.ja.streamingservice.model.Movie;
import be.pxl.ja.streamingservice.model.Profile;
import be.pxl.ja.streamingservice.model.Rating;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class ProfileIsAllowedToWatchTest {

    private static final Movie MOVIE_LITTLE_KIDS= new Movie("Little Kids", Rating.LITTLE_KIDS);
    private static final Movie MOVIE_OLDER_KIDS = new Movie("Older Kids", Rating.OLDER_KIDS);
    private static final Movie MOVIE_TEENS = new Movie("Teens", Rating.TEENS);
    private static final Movie MOVIE_MATURE = new Movie("Mature", Rating.MATURE);
    private Profile profile;

    @BeforeEach
    public void init(){
        profile = new Profile("test");
    }

    @Test
    public void shouldReturnFalseForAllContentWhenAgeIsNotSet(){

        assertFalse(profile.allowedToWatch(MOVIE_LITTLE_KIDS));
        assertFalse(profile.allowedToWatch(MOVIE_OLDER_KIDS));
        assertFalse(profile.allowedToWatch(MOVIE_TEENS));
        assertFalse(profile.allowedToWatch(MOVIE_MATURE));
    }

    @Test
    public void shouldReturnTrueForRatingLittleKidsOnlyForZeroYearsOld(){
        profile.setDateOfBirth(LocalDate.now());

        assertTrue(profile.allowedToWatch(MOVIE_LITTLE_KIDS));
        assertFalse(profile.allowedToWatch(MOVIE_OLDER_KIDS));
        assertFalse(profile.allowedToWatch(MOVIE_TEENS));
        assertFalse(profile.allowedToWatch(MOVIE_MATURE));
    }

    @Test
    public void shouldReturnTrueForRatingLittleKidsOnlyForSixYearsOld(){
        profile.setDateOfBirth(LocalDate.now().minusYears(6));

        assertTrue(profile.allowedToWatch(MOVIE_LITTLE_KIDS));
        assertFalse(profile.allowedToWatch(MOVIE_OLDER_KIDS));
        assertFalse(profile.allowedToWatch(MOVIE_TEENS));
        assertFalse(profile.allowedToWatch(MOVIE_MATURE));
    }

    @Test
    public void shouldReturnTrueForRatingLittleKidsOnlyForSixYearsAnd364DaysOld(){
        profile.setDateOfBirth(LocalDate.now().minusYears(Rating.OLDER_KIDS.getMinimumAge()).plusDays(1));

        assertTrue(profile.allowedToWatch(MOVIE_LITTLE_KIDS));
        assertFalse(profile.allowedToWatch(MOVIE_OLDER_KIDS));
        assertFalse(profile.allowedToWatch(MOVIE_TEENS));
        assertFalse(profile.allowedToWatch(MOVIE_MATURE));
    }

    @Test
    public void shouldReturnTrueForRatingLittleKidsAndOlderKidsForSevenYearsOld(){
        profile.setDateOfBirth(LocalDate.now().minusYears(Rating.OLDER_KIDS.getMinimumAge()));

        assertTrue(profile.allowedToWatch(MOVIE_LITTLE_KIDS));
        assertTrue(profile.allowedToWatch(MOVIE_OLDER_KIDS));
        assertFalse(profile.allowedToWatch(MOVIE_TEENS));
        assertFalse(profile.allowedToWatch(MOVIE_MATURE));
    }

    @Test
    public void shouldReturnTrueForRatingLittleKidsAndOlderKidsForTenYearsOld(){
        profile.setDateOfBirth(LocalDate.now().minusYears(10));

        assertTrue(profile.allowedToWatch(MOVIE_LITTLE_KIDS));
        assertTrue(profile.allowedToWatch(MOVIE_OLDER_KIDS));
        assertFalse(profile.allowedToWatch(MOVIE_TEENS));
        assertFalse(profile.allowedToWatch(MOVIE_MATURE));
    }

    @Test
    public void shouldReturnTrueForRatingLittleKidsAndOlderKidsForTwelveYearsOldMinusOneDay(){
        profile.setDateOfBirth(LocalDate.now().minusYears(Rating.TEENS.getMinimumAge()).plusDays(1));

        assertTrue(profile.allowedToWatch(MOVIE_LITTLE_KIDS));
        assertTrue(profile.allowedToWatch(MOVIE_OLDER_KIDS));
        assertFalse(profile.allowedToWatch(MOVIE_TEENS));
        assertFalse(profile.allowedToWatch(MOVIE_MATURE));
    }

    @Test
    public void shouldReturnFalseForRatingMatureOnlyForTwelveYearsOld(){
        profile.setDateOfBirth(LocalDate.now().minusYears(Rating.TEENS.getMinimumAge()));

        assertTrue(profile.allowedToWatch(MOVIE_LITTLE_KIDS));
        assertTrue(profile.allowedToWatch(MOVIE_OLDER_KIDS));
        assertTrue(profile.allowedToWatch(MOVIE_TEENS));
        assertFalse(profile.allowedToWatch(MOVIE_MATURE));
    }

    @Test
    public void shouldReturnFalseForRatingMatureOnlyForFifteenYearsOld(){
        profile.setDateOfBirth(LocalDate.now().minusYears(15));

        assertTrue(profile.allowedToWatch(MOVIE_LITTLE_KIDS));
        assertTrue(profile.allowedToWatch(MOVIE_OLDER_KIDS));
        assertTrue(profile.allowedToWatch(MOVIE_TEENS));
        assertFalse(profile.allowedToWatch(MOVIE_MATURE));
    }

    @Test
    public void shouldReturnFalseForRatingMatureOnlyForSixteenYearsOldMinusOneDay(){
        profile.setDateOfBirth(LocalDate.now().minusYears(Rating.MATURE.getMinimumAge()).plusDays(1));

        assertTrue(profile.allowedToWatch(MOVIE_LITTLE_KIDS));
        assertTrue(profile.allowedToWatch(MOVIE_OLDER_KIDS));
        assertTrue(profile.allowedToWatch(MOVIE_TEENS));
        assertFalse(profile.allowedToWatch(MOVIE_MATURE));
    }

    @Test
    public void shouldReturnTrueForAllContentForSixteenYearsOld(){
        profile.setDateOfBirth(LocalDate.now().minusYears(16));

        assertTrue(profile.allowedToWatch(MOVIE_LITTLE_KIDS));
        assertTrue(profile.allowedToWatch(MOVIE_OLDER_KIDS));
        assertTrue(profile.allowedToWatch(MOVIE_TEENS));
        assertTrue(profile.allowedToWatch(MOVIE_MATURE));
    }

    @Test
    public void shouldReturnTrueForAllContentForOlderThanSixteen(){
        profile.setDateOfBirth(LocalDate.now().minusYears(36));

        assertTrue(profile.allowedToWatch(MOVIE_LITTLE_KIDS));
        assertTrue(profile.allowedToWatch(MOVIE_OLDER_KIDS));
        assertTrue(profile.allowedToWatch(MOVIE_TEENS));
        assertTrue(profile.allowedToWatch(MOVIE_MATURE));
    }
}

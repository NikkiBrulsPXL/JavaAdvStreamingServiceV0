package be.pxl.ja.streamingservice.util;

import be.pxl.ja.streamingservice.model.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class AccountConstructorTest {
    private Account account;

    @BeforeEach
    public void init(){
        account = new Account("email", "password");
    }

    @Test
    public void returnFirstProfileShouldReturnProfileWithNameprofile1(){
        String name = account.getFirstProfile().getName();

        assertEquals("profile1", name);
    }

    @Test
    public void returnFirstProfileShouldReturnProfileWithNoDateOfBirth(){
        assertNull(account.getFirstProfile().getDateOfBirth());
    }
}

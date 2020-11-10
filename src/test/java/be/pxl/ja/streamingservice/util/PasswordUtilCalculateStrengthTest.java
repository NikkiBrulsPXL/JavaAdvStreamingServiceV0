package be.pxl.ja.streamingservice.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PasswordUtilCalculateStrengthTest {

    private static final String PASSWORD1 = "hello"; //score 0
    private static final String PASSWORD2 = "helloo"; //score 3
    private static final String PASSWORD3 = "HELLOO"; //score 3
    private static final String PASSWORD4 = "123456"; //score 3
    private static final String PASSWORD5 = "~$*^!@#"; //score 3
    private static final String PASSWORD6 = "HellOO"; //score 5
    private static final String PASSWORD7 = "hello1"; //score 5
    private static final String PASSWORD8 = "hello~"; //score 5
    private static final String PASSWORD9 = "HELLO1"; //score 5
    private static final String PASSWORD10 = "HELLO!!"; //score 5
    private static final String PASSWORD11 = "123456!*"; //score 5
    private static final String PASSWORD12 = "Hello0"; //score 7
    private static final String PASSWORD13 = "Hello!!"; //score 7
    private static final String PASSWORD14 = "HELL0!!"; //score 7
    private static final String PASSWORD15 = "Hell0!!"; //score 9
    private static final String PASSWORD16 = "longerthantendigits"; //score 4
    private static final String PASSWORD17 = "LONGERTHANTENDIGITS"; //score 4
    private static final String PASSWORD18 = "123456789101112"; //score 4
    private static final String PASSWORD19 = "~*$@#%^$*@#!!"; //score 4
    private static final String PASSWORD20 = "LongerThanTenDigits"; //score 6
    private static final String PASSWORD21 = "l0ng3rthant3nd1g1ts"; //score 6
    private static final String PASSWORD22 = "l*ngerth@ntend!g!t$"; //score 6
    private static final String PASSWORD23 = "L0NG3RTHANT3ND1G1TS"; //score 6
    private static final String PASSWORD24 = "L*NGERTH@NTEND!G!T$"; //score 6
    private static final String PASSWORD25 = "1234567890$*%@#^"; //score 6
    private static final String PASSWORD26 = "L0ng3rThanT3nD1g1ts"; //score 8
    private static final String PASSWORD27 = "L*ngerTh@nTenD!g!t$"; //score 8
    private static final String PASSWORD28 = "L*ng3rTh@nT3nD!g!t$"; //score 10

    @Test
    public void shouldReturnZeroForPassword1() {
        assertEquals(0, PasswordUtil.calculateStrength(PASSWORD1));
    }

    @Test
    public void shouldReturnThreeForPassword2() {
        assertEquals(3, PasswordUtil.calculateStrength(PASSWORD2));
    }

    @Test
    public void shouldReturnThreeForPassword3(){
        assertEquals(3,PasswordUtil.calculateStrength(PASSWORD3));
    }

    @Test
    public void shouldReturnThreeForPassword4(){
        assertEquals(3,PasswordUtil.calculateStrength(PASSWORD4));
    }

    @Test
    public void shouldReturnThreeForPassword5(){
        assertEquals(3,PasswordUtil.calculateStrength(PASSWORD5));
    }

    @Test
    public void shouldReturnFiveForPassword6(){
        assertEquals(5,PasswordUtil.calculateStrength(PASSWORD6));
    }

    @Test
    public void shouldReturnFiveForPassword7(){
        assertEquals(5,PasswordUtil.calculateStrength(PASSWORD7));
    }

    @Test
    public void shouldReturnFiveForPassword8(){
        assertEquals(5,PasswordUtil.calculateStrength(PASSWORD8));
    }

    @Test
    public void shouldReturnFiveForPassword9(){
        assertEquals(5,PasswordUtil.calculateStrength(PASSWORD9));
    }

    @Test
    public void shouldReturnFiveForPassword10(){
        assertEquals(5,PasswordUtil.calculateStrength(PASSWORD10));
    }

    @Test
    public void shouldReturnFiveForPassword11(){
        assertEquals(5,PasswordUtil.calculateStrength(PASSWORD11));
    }

    @Test
    public void shouldReturnSevenForPassword12(){
        assertEquals(7,PasswordUtil.calculateStrength(PASSWORD12));
    }

    @Test
    public void shouldReturnSevenForPassword13(){
        assertEquals(7,PasswordUtil.calculateStrength(PASSWORD13));
    }

    @Test
    public void shouldReturnSevenForPassword14(){
        assertEquals(7,PasswordUtil.calculateStrength(PASSWORD14));
    }

    @Test
    public void shouldReturnNineForPassword15(){
        assertEquals(9,PasswordUtil.calculateStrength(PASSWORD15));
    }

    @Test
    public void shouldReturnFourForPassword16(){
        assertEquals(4,PasswordUtil.calculateStrength(PASSWORD16));
    }

    @Test
    public void shouldReturnFourForPassword17(){
        assertEquals(4,PasswordUtil.calculateStrength(PASSWORD17));
    }

    @Test
    public void shouldReturnFourForPassword18(){
        assertEquals(4,PasswordUtil.calculateStrength(PASSWORD18));
    }

    @Test
    public void shouldReturnFourForPassword19(){
        assertEquals(4,PasswordUtil.calculateStrength(PASSWORD19));
    }

    @Test
    public void shouldReturnSixForPassword20(){
        assertEquals(6,PasswordUtil.calculateStrength(PASSWORD20));
    }

    @Test
    public void shouldReturnSixForPassword21(){
        assertEquals(6,PasswordUtil.calculateStrength(PASSWORD21));
    }

    @Test
    public void shouldReturnSixForPassword22(){
        assertEquals(6,PasswordUtil.calculateStrength(PASSWORD22));
    }

    @Test
    public void shouldReturnSixForPassword23(){
        assertEquals(6,PasswordUtil.calculateStrength(PASSWORD23));
    }

    @Test
    public void shouldReturnSixForPassword24(){
        assertEquals(6,PasswordUtil.calculateStrength(PASSWORD24));
    }

    @Test
    public void shouldReturnSixForPassword25(){
        assertEquals(6,PasswordUtil.calculateStrength(PASSWORD25));
    }

    @Test
    public void shouldReturnEightForPassword26(){
        assertEquals(8,PasswordUtil.calculateStrength(PASSWORD26));
    }

    @Test
    public void shouldReturnEightForPassword27(){
        assertEquals(8,PasswordUtil.calculateStrength(PASSWORD27));
    }

    @Test
    public void shouldReturnTenForPassword28(){
        assertEquals(10,PasswordUtil.calculateStrength(PASSWORD28));
    }
}
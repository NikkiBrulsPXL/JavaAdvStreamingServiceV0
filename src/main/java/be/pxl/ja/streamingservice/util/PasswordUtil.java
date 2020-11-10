package be.pxl.ja.streamingservice.util;

public class PasswordUtil {

	private static final String SPECIAL_CHARACTERS = "~!@#$%^&*()_-";

	public static int calculateStrength(String password) {
		int score = 0;
		int passwordLength = password.length();

		if(passwordLength < 6){
			return score;
		}
		if(passwordLength < 11){
			score = 1;
		} else {
			score = 2;
		}
		if(password.matches(".*\\d+.*")){
			score += 2;
		}
		if(password.matches(".*[a-z]+.*")){
			score += 2;
		}
		if(password.matches(".*[A-Z]+.*")){
			score += 2;
		}
		if(password.matches(".*[~!@#$%^&*()_-]+.*")){
			score += 2;
		}
		return score;
	}
}

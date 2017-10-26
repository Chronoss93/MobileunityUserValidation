package codingchallange.service;

/**
 * Created by Igor on 09.10.2017.
 */
public class ValidationService {


    public Notification validateUsername(String username) {
        Notification notification = new Notification();

        validateLength(notification, username);
        validateUpperCaseExist(notification, username);
        validateContainsDigit(notification, username);
        validateHasSpecialSymbols(notification, username);
        validateNoSpaces(notification, username);

        return notification;
    }

    private void validateHasSpecialSymbols(Notification notification, String username) {
        if (!username.matches(".*[@#_].*")) {
            notification.addError("Username should contain at least one special symbol e.g. @ or # or _");
        }
    }

    private void validateNoSpaces(Notification notification, String username) {
        if (username.contains(" ")){
            notification.addError("Username should not contain spaces");
        }
    }

    private void validateContainsDigit(Notification notification, String username) {
        if (!username.matches(".*[0-9].*")) {
            notification.addError("Username should contain at least one digit");
        }
    }

    private void validateUpperCaseExist(Notification notification, String username) {
        if(!username.matches(".*[A-Z].*"))
            notification.addError("Username should contain at least one upper-case letter A-Z");
    }

    private void validateLength(Notification notification, String username) {
        if (username.length() < 4 || username.length() > 32) {
            notification.addError("Invalid length=" + username.length()
                    + "\nUsername should contain from 4 to 32 symbols.");
        }
    }
}

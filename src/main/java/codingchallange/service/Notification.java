package codingchallange.service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Igor on 09.10.2017.
 */
public class Notification {

    private List<String> errors = new ArrayList<>();

    public void addError(String error) {
        errors.add(error);
    }

    public boolean hasErrors() {
        return !errors.isEmpty();
    }

    public List<String> getErrors() {
        return errors;
    }
}
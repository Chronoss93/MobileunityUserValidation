package codingchallange.service;

import codingchallange.exception.UsernameProcessingException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * Created by Igor on 09.10.2017.
 */
public class UsernameService {

    private NotificationService notificationService;

    public UsernameService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void processFile(File file) throws UsernameProcessingException {
        try {
            Files.lines(file.toPath())
                    .forEach(notificationService::sendNotification);
        } catch (IOException e) {
            throw new UsernameProcessingException("Cannot load File=[" + file + "]", e);
        }
    }

}

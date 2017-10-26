package codingchallange;

import codingchallange.exception.UsernameProcessingException;
import codingchallange.service.NotificationService;
import codingchallange.service.PrintService;
import codingchallange.service.UsernameService;
import codingchallange.service.ValidationService;

import java.io.File;
import java.io.IOException;

/**
 * Created by Igor on 09.10.2017.
 */
public class App {

    public static void main(String[] args) throws IOException, UsernameProcessingException {

        UsernameService usernameService = getUsernameService();
        usernameService.processFile(new File(args[0]));
    }

    private static UsernameService getUsernameService() {
        PrintService printService = new PrintService();
        ValidationService validationService= new ValidationService();
        NotificationService notificationService = new NotificationService(validationService, printService);
        return new UsernameService(notificationService);
    }

}

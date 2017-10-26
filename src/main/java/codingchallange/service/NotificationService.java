package codingchallange.service;

/**
 * Created by Igor on 09.10.2017.
 */
public class NotificationService {

    private static final String FAIL = "FAIL";
    private static final String PASS = "PASS";

    private ValidationService validationService;
    private PrintService printService;

    public NotificationService(ValidationService validationService, PrintService printService) {
        this.validationService = validationService;
        this.printService = printService;
    }

    public void sendNotification(String username) {
        Notification notification = validationService.validateUsername(username);
        if (notification.hasErrors()) {
            printService.print(FAIL);
        } else {
            printService.print(PASS);
        }
    }
}

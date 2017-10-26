package codingchallange.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Igor on 09.10.2017.
 */

@RunWith(MockitoJUnitRunner.class)
public class NotificationServiceTest {

    @Mock
    private PrintService printService;
    @Mock
    private ValidationService validationService = new ValidationService();
    @InjectMocks
    private NotificationService notificationService = new NotificationService(validationService, printService);

    @Test
    public void shouldSentPassNotificationWhenValidationIsSuccessful() throws Exception {
        String goodUsername = "goodUsername";
        Notification emptyNotification = new Notification();
        when(validationService.validateUsername(eq(goodUsername))).thenReturn(emptyNotification);

        notificationService.sendNotification(goodUsername);

        verify(printService).print(eq("PASS"));
    }
    @Test
    public void shouldSentFailNotificationWhenValidationIsSuccessful() throws Exception {
        String badUsername = "badUsername";
        Notification notification = new Notification();
        notification.addError("no numbers in username");
        when(validationService.validateUsername(eq(badUsername))).thenReturn(notification);

        notificationService.sendNotification(badUsername);

        verify(printService).print(eq("FAIL"));
    }

}
package codingchallange.service;

import codingchallange.exception.UsernameProcessingException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.File;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

/**
 * Created by Igor on 09.10.2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class UsernameServiceTest {

    @Mock
    private NotificationService notificationService;
    @InjectMocks
    private UsernameService usernameService = new UsernameService(notificationService);

    @Test
    public void shouldCallNotificationServiceFourTime() throws UsernameProcessingException {
        File goodUsers = new File(this.getClass().getResource("/users.txt").getFile());

        usernameService.processFile(goodUsers);

        verify(notificationService, times(4)).sendNotification(anyString());
    }

    @Test
    public void shouldDoNothingIfFileIsEmpty() throws UsernameProcessingException {
        File goodUsers = new File(this.getClass().getResource("/empty_file.txt").getFile());

        usernameService.processFile(goodUsers);

        verify(notificationService, times(0)).sendNotification(anyString());
    }

    @Test(expected = UsernameProcessingException.class)
    public void shouldThrowExceptionForWrongFile() throws UsernameProcessingException {
        File goodUsers = new File("wrong path");

        usernameService.processFile(goodUsers);
    }
}
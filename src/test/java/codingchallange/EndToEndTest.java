package codingchallange;

import codingchallange.exception.UsernameProcessingException;
import codingchallange.service.NotificationService;
import codingchallange.service.PrintService;
import codingchallange.service.UsernameService;
import codingchallange.service.ValidationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.File;
import java.io.IOException;

import static org.mockito.Matchers.eq;
import static org.mockito.internal.verification.VerificationModeFactory.times;

/**
 * Created by Igor on 09.10.2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class EndToEndTest {

    @Spy
    private PrintService printService;
    @Spy
    private ValidationService validationService = new ValidationService();
    @InjectMocks
    private NotificationService notificationService = new NotificationService(validationService, printService);
    private UsernameService usernameService = new UsernameService(notificationService);

    @Test
    public void shouldProcessFile() throws IOException, UsernameProcessingException {
        File goodUsers = new File(this.getClass().getResource("/users.txt").getFile());

        usernameService.processFile(goodUsers);

        Mockito.verify(printService, times(2)).print(eq("PASS"));
        Mockito.verify(printService, times(2)).print(eq("FAIL"));
    }

}

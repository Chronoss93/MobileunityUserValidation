package codingchallange.service;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Igor on 09.10.2017.
 */
public class ValidationServiceTest {

    private ValidationService validationService = new ValidationService();

    @Test
    public void shouldNotNotifyAnyErrors() {
        String correctUsername = "Am@Z1ng4";

        Notification note = validationService.validateUsername(correctUsername);

        assertEquals(0, note.getErrors().size());
    }

    @Test
    public void shouldNotifyWhenLessThenFourSymbols() throws Exception {

        Notification note = validationService.validateUsername("A0#");

        assertEquals(1, note.getErrors().size());
        assertEquals("Invalid length=3\nUsername should contain from 4 to 32 symbols.", note.getErrors().get(0));
    }

    @Test
    public void shouldNotifyWhenMoreThen32Symbols() {
        String usernameWith33Symbols = "AAAAAA2222233333444445555566666###";

        Notification note = validationService.validateUsername(usernameWith33Symbols);

        assertEquals(1, note.getErrors().size());
        assertEquals("Invalid length=34\nUsername should contain from 4 to 32 symbols.", note.getErrors().get(0));
    }

    @Test
    public void shouldNotifyWhenNoDigits() {
        Notification note = validationService.validateUsername("Am@Zzng");

        assertEquals(1, note.getErrors().size());
        assertEquals("Username should contain at least one digit", note.getErrors().get(0));
    }

    @Test
    public void shouldNotifyWhenNoUpperCaseLetters() {
        Notification note = validationService.validateUsername("am@z1ng4");

        assertEquals(1, note.getErrors().size());
        assertEquals("Username should contain at least one upper-case letter A-Z", note.getErrors().get(0));
    }

    @Test
    public void shouldNotifyWhenNoSpecialSymbol() {
        Notification note = validationService.validateUsername("Amz1ng4");

        assertEquals(1, note.getErrors().size());
        assertEquals("Username should contain at least one special symbol e.g. @ or # or _", note.getErrors().get(0));
    }

    @Test
    public void shouldNotifyWhenContainSpace() {
        Notification note = validationService.validateUsername("Am@z1n g4");

        assertEquals(1, note.getErrors().size());
        assertEquals("Username should not contain spaces", note.getErrors().get(0));
    }
}
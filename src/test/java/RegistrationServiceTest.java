import org.junit.Test;
import ru.itis.dto.UserRegistration;
import ru.itis.services.RegistrationService;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class RegistrationServiceTest {

    @Test
    public void registerTest(){
        RegistrationService registrationService = mock(RegistrationService.class);
        UserRegistration userRegistration = mock(UserRegistration.class);
        registrationService.register(userRegistration);
        verify(registrationService).register(userRegistration);
    }
}

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.security.core.Authentication;
import ru.itis.models.User;
import ru.itis.services.AuthenticationService;

import static org.mockito.Mockito.*;

public class AuthenticationServiceTest {

    private AuthenticationService authenticationService;

    @Before
    public void initAuthService(){
        authenticationService = mock(AuthenticationService.class);
    }

    @Test
    public void getUserByAuthenticationTest(){
        Authentication authMock = mock(Authentication.class);
        authenticationService.getUserByAuthentication(authMock);
        verify(authenticationService, atLeastOnce()).getUserByAuthentication(authMock);
    }

    @Test
    public void getUserByIdTest(){
        User userMock = mock(User.class);
        when(authenticationService.getUserById(anyLong())).thenReturn(userMock);
        Assert.assertEquals(userMock, authenticationService.getUserById(anyLong()));
    }
}

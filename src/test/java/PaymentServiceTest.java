import org.junit.Before;
import org.junit.Test;
import ru.itis.dto.PaymentDto;
import ru.itis.models.User;
import ru.itis.services.PaymentService;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class PaymentServiceTest {

    private PaymentService paymentService;

    @Before
    public void init(){
        paymentService = mock(PaymentService.class);
    }

    @Test
    public void addTest(){
        PaymentDto dtoMock = mock(PaymentDto.class);
        User user = mock(User.class);
        paymentService.add(dtoMock, user);
        verify(paymentService).add(dtoMock, user);
    }
}

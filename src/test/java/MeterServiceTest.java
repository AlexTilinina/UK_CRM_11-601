import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.itis.dto.MeterDto;
import ru.itis.models.User;
import ru.itis.services.MeterService;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MeterServiceTest {

    private MeterService meterService;
    private List mockList;

    @Before
    public void init(){
        meterService = mock(MeterService.class);
        mockList = mock(List.class);
    }

    @Test
    public void getAllMetersTest(){
        when(meterService.getAllMeters()).thenReturn(mockList);
        Assert.assertEquals(mockList, meterService.getAllMeters());
    }

    @Test
    public void getAllMetersUserTest(){
        User user = mock(User.class);
        when(meterService.getAllMeters(user)).thenReturn(mockList);
        Assert.assertEquals(mockList, meterService.getAllMeters(user));
    }

    @Test
    public void addTest() {
        User user = mock(User.class);
        MeterDto meterDto = mock(MeterDto.class);
        meterService.add(meterDto, user);
        verify(meterService).add(meterDto, user);
    }
}

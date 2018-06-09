import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.itis.services.PositionService;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PositionServiceTest {

    private PositionService positionService;

    @Before
    public void init(){
        positionService = mock(PositionService.class);
    }

    @Test
    public void getAllPositionsTest(){
        List mockList = mock(List.class);
        when(positionService.getAllPositions()).thenReturn(mockList);
        Assert.assertEquals(mockList, positionService.getAllPositions());
    }

    @Test
    public void addTest(){
        positionService.add("Name");
        verify(positionService).add("Name");
    }
}

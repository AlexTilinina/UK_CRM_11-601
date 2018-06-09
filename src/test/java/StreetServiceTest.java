import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.itis.dto.StreetDto;
import ru.itis.services.StreetService;

import java.util.List;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class StreetServiceTest {

    private StreetService streetService;
    private List list;

    @Before
    public void init(){
        streetService = mock(StreetService.class);
        list = mock(List.class);
    }

    @Test
    public void getAllStreetsTest(){
        when(streetService.getAllStreets()).thenReturn(list);
        Assert.assertEquals(list, streetService.getAllStreets());
    }

    @Test
    public void getAllStreetsByCityTest(){
        when(streetService.getAllStreetsByCity(0L)).thenReturn(list);
        Assert.assertEquals(list, streetService.getAllStreetsByCity(anyLong()));
    }

    @Test
    public void addTest(){
        StreetDto dto = mock(StreetDto.class);
        streetService.add(dto);
        verify(streetService).add(dto);
    }
}

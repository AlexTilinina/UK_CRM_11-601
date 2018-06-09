import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.itis.services.CityService;

import java.util.List;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CityServiceTest {

    private CityService cityService;

    @Before
    public void init(){
        cityService = mock(CityService.class);
    }

    @Test
    public void getAllCitiesTest(){
        List mockList = mock(List.class);
        when(cityService.getAllCities()).thenReturn(mockList);
        Assert.assertEquals(mockList, cityService.getAllCities());
    }

    @Test
    public void addTest(){
        cityService.add("Mock");
        verify(cityService).add("Mock");
    }
}

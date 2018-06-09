import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.itis.services.PropertyTypeService;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PropertyTypeServiceTest {

    private PropertyTypeService propertyTypeService;

    @Before
    public void init(){
        propertyTypeService = mock(PropertyTypeService.class);
    }

    @Test
    public void getAllPropertyTypesTest(){
        List mockList = mock(List.class);
        when(propertyTypeService.getAllPropertyTypes()).thenReturn(mockList);
        Assert.assertEquals(mockList, propertyTypeService.getAllPropertyTypes());
    }

    @Test
    public void addTest(){
        propertyTypeService.add("Name");
        verify(propertyTypeService).add("Name");
    }
}

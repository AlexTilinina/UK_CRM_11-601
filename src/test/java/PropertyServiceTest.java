import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.itis.dto.PropertyDto;
import ru.itis.models.Property;
import ru.itis.models.User;
import ru.itis.services.PropertyService;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PropertyServiceTest {

    private PropertyService propertyService;

    @Before
    public void init(){
        propertyService = mock(PropertyService.class);
    }

    @Test
    public void addPropertyTest(){
        PropertyDto dtoMock = mock(PropertyDto.class);
        User user = mock(User.class);
        propertyService.addProperty(dtoMock, user);
        verify(propertyService).addProperty(dtoMock, user);
    }

    @Test
    public void getPropertyByIdTest(){
        Property mock = mock(Property.class);
        when(propertyService.getPropertyById(anyLong())).thenReturn(mock);
        Assert.assertEquals(mock, propertyService.getPropertyById(anyLong()));
    }

    @Test
    public void editTest(){
        PropertyDto dtoMock = mock(PropertyDto.class);
        propertyService.edit(dtoMock, 0L);
        verify(propertyService).edit(eq(dtoMock), anyLong());
    }

    @Test
    public void deleteTest(){
        propertyService.delete(0L);
        verify(propertyService).delete(anyLong());
    }
}

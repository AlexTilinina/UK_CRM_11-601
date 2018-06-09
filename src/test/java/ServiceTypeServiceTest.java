import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.itis.models.ServiceType;
import ru.itis.services.ServiceTypeService;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ServiceTypeServiceTest {

    private ServiceTypeService serviceTypeService;

    @Before
    public void init(){
        serviceTypeService = mock(ServiceTypeService.class);
    }

    @Test
    public void getAllServicesTest(){
        List mockList = mock(List.class);
        when(serviceTypeService.getAllServices()).thenReturn(mockList);
        Assert.assertEquals(mockList, serviceTypeService.getAllServices());
    }

    @Test
    public void addTest(){
        serviceTypeService.add("Service");
        verify(serviceTypeService).add("Service");
    }

    @Test
    public void getServiceTest(){
        ServiceType mock = mock(ServiceType.class);
        when(serviceTypeService.getService("service")).thenReturn(mock);
        Assert.assertEquals(mock, serviceTypeService.getService("service"));
    }
}

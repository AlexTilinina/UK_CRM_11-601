import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.itis.dto.ClaimDto;
import ru.itis.models.Employee;
import ru.itis.models.PropertyOwner;
import ru.itis.services.ClaimsService;

import java.util.List;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

public class ClaimsServiceTest {

    private ClaimsService claimsService;
    private List mockList;

    @Before
    public void init(){
        claimsService = mock(ClaimsService.class);
        mockList = mock(List.class);
    }

    @Test
    public void getAllClaimsByOwnerTest() {
        PropertyOwner propertyOwnerMock = mock(PropertyOwner.class);
        when(claimsService.getAllClaimsByOwner(propertyOwnerMock)).thenReturn(mockList);
        Assert.assertEquals(mockList, claimsService.getAllClaimsByOwner(propertyOwnerMock));
    }

    @Test
    public void getAllClaimsTest(){
        when(claimsService.getAllClaims()).thenReturn(mockList);
        Assert.assertEquals(mockList, claimsService.getAllClaims());
    }

    @Test
    public void addTest() {
        ClaimDto dtoMock = mock(ClaimDto.class);
        PropertyOwner propertyOwnerMock = mock(PropertyOwner.class);
        claimsService.add(dtoMock, propertyOwnerMock);
        verify(claimsService).add(dtoMock, propertyOwnerMock);
    }

    @Test
    public void getAllByFilterWithOwnerTest(){
        PropertyOwner propertyOwnerMock = mock(PropertyOwner.class);
        String filter = "filter";
        when(claimsService.getAllByFilter(filter, propertyOwnerMock)).thenReturn(mockList);
        Assert.assertEquals(mockList, claimsService.getAllByFilter(filter, propertyOwnerMock));
    }

    @Test
    public void getAllByFilterTest(){
        String filter = "filter";
        when(claimsService.getAllByFilter(filter)).thenReturn(mockList);
        Assert.assertEquals(mockList, claimsService.getAllByFilter(filter));
    }

    @Test
    public void addAnswerTest(){
        Employee empMock = mock(Employee.class);
        claimsService.addAnswer(0L, "answer", empMock);
        verify(claimsService).addAnswer(anyLong(), eq("answer"), eq(empMock));
    }

    @Test
    public void setStateTest(){
        claimsService.setState(0L, "answer");
        verify(claimsService).setState(anyLong(), eq("answer"));
    }
}

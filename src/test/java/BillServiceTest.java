import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.itis.models.User;
import ru.itis.services.BillService;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BillServiceTest {

    private BillService billService;
    private List mockList;

    @Before
    public void initBillService(){
        billService = mock(BillService.class);
        mockList = mock(List.class);
    }

    @Test
    public void getAllBillsTest(){
        when(billService.getAllBills()).thenReturn(mockList);
        Assert.assertEquals(mockList, billService.getAllBills());
    }

    @Test
    public void getAllBillsUserTest(){
        User user = mock(User.class);
        when(billService.getAllBills(user)).thenReturn(mockList);
        Assert.assertEquals(mockList, billService.getAllBills(user));
    }
}

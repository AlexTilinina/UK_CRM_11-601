import org.junit.Before;
import org.junit.Test;
import ru.itis.dto.EditProfileDto;
import ru.itis.dto.EmployeeRegistration;
import ru.itis.services.EmployeeService;

import static org.mockito.Mockito.*;

public class EmployeeServiceTest {

    private EmployeeService employeeService;

    @Before
    public void init(){
        employeeService = mock(EmployeeService.class);
    }

    @Test
    public void registerTest(){
        EmployeeRegistration empRegMock = mock(EmployeeRegistration.class);
        employeeService.register(empRegMock);
        verify(employeeService).register(empRegMock);
    }

    @Test
    public void editTest(){
        EditProfileDto editProfileDtoMock = mock(EditProfileDto.class);
        employeeService.edit(editProfileDtoMock, 0L);
        verify(employeeService).edit(eq(editProfileDtoMock), anyLong());
    }
}

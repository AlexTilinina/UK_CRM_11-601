import org.junit.Before;
import org.junit.Test;
import ru.itis.dto.EditProfileDto;
import ru.itis.services.AdminService;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class AdminServiceTest {

    private AdminService adminService;

    @Before
    public void initAdminService(){
        adminService = mock(AdminService.class);
    }

    @Test
    public void editTest() {
        EditProfileDto editProfileDtoMock = mock(EditProfileDto.class);
        adminService.edit(editProfileDtoMock, eq(anyLong()));
        verify(adminService).edit(editProfileDtoMock, eq(anyLong()));
    }
}
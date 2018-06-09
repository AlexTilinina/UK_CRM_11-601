import org.junit.Test;
import ru.itis.dto.EditProfileDto;
import ru.itis.services.OwnerService;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class OwnerServiceTest {

    @Test
    public void editTest(){
        OwnerService ownerService = mock(OwnerService.class);
        EditProfileDto dtoMock = mock(EditProfileDto.class);
        ownerService.edit(dtoMock, 0L);
        verify(ownerService).edit(eq(dtoMock), anyLong());
    }
}

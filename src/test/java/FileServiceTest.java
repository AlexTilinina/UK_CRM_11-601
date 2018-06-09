import org.junit.Before;
import org.junit.Test;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.services.FileService;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class FileServiceTest {

    private FileService fileService;

    @Before
    public void init(){
        fileService = mock(FileService.class);
    }

    @Test
    public void uploadTest(){
        MultipartFile fileMock = mock(MultipartFile.class);
        fileService.upload(fileMock);
        verify(fileService).upload(fileMock);
    }
}

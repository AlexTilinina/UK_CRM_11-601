import org.junit.Before;
import org.junit.Test;
import org.springframework.data.domain.Pageable;
import ru.itis.dto.NewsDto;
import ru.itis.services.NewsService;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class NewsServiceTest {

    private NewsService newsService;

    @Before
    public void init(){
        newsService = mock(NewsService.class);
    }

    @Test
    public void getNewsTest(){
        Pageable pageable = mock(Pageable.class);
        newsService.getNews(pageable);
        verify(newsService).getNews(pageable);
    }

    @Test
    public void getFullNewsTest(){
        newsService.getFullNews(anyLong());
        verify(newsService).getFullNews(anyLong());
    }

    @Test
    public void editTest(){
        NewsDto dtoMock = mock(NewsDto.class);
        newsService.edit(dtoMock, 0L);
        verify(newsService).edit(eq(dtoMock), anyLong());
    }

    @Test
    public void deleteTest(){
        newsService.delete(anyLong());
        verify(newsService).delete(anyLong());
    }

    @Test
    public void addTest(){
        NewsDto dtoMock = mock(NewsDto.class);
        newsService.add(dtoMock);
        verify(newsService).add(dtoMock);
    }
}

package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.itis.dto.NewsDto;
import ru.itis.models.News;
import ru.itis.repositories.NewsRepository;

import java.util.Date;

@Service
public class NewsService {

    @Autowired
    private NewsRepository newsRepository;

    public Page<News> getNews(Pageable pageable) {
        return newsRepository.findAllByOrderByDateDesc(pageable);
    }

    public News getFullNews(Long id) {
        return newsRepository.findById(id);
    }

    public void edit(NewsDto newsDto, Long id) {
        News news = newsRepository.findById(id);
        if (newsDto.getTitle() != "") {
            news.setTitle(newsDto.getTitle());
        }
        if (newsDto.getDescription() != "") {
            news.setDescription(newsDto.getDescription());
        }
        newsRepository.save(news);
    }

    public void delete(Long id) {
        newsRepository.delete(id);
    }

    public void add(NewsDto newsDto) {
        News news = News.builder()
                .title(newsDto.getTitle())
                .description(newsDto.getDescription())
                .date(new Date())
                .build();
        newsRepository.save(news);
    }
}

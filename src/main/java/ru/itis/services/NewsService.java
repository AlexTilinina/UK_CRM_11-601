package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.itis.models.News;
import ru.itis.repositories.NewsRepository;

@Service
public class NewsService {

    @Autowired
    private NewsRepository newsRepository;

    public Page<News> getNews(Pageable pageable) {
        return newsRepository.findAllByOrderByDateDesc(pageable);
    }
}

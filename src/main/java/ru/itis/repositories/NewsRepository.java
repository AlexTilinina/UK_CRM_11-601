package ru.itis.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import ru.itis.models.News;

public interface NewsRepository extends PagingAndSortingRepository<News, Long> {

    Page<News> findAllByOrderByDateDesc(Pageable pageable);

    News findById(Long id);
}

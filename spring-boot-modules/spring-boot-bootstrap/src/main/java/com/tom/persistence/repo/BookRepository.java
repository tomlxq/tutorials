package com.tom.persistence.repo;

import com.tom.persistence.model.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/4/25
 */
public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findByTitle(String title);
}
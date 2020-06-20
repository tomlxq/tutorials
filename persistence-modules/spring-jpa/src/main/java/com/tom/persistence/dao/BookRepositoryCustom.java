package com.tom.persistence.dao;

import com.tom.persistence.model.Book;

import java.util.List;

public interface BookRepositoryCustom {

    List<Book> findBooksByAuthorNameAndTitle(String authorName, String title);

}

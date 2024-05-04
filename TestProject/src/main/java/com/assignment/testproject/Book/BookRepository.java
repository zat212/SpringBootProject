package com.assignment.testproject.Book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Integer>
{

    public Long countById(Integer id);
    List<Book> findBookByBookTitle(String bookTitle);
    List<Book> findBookByAuthorName(String authorName);

    List<Book> findBookByBookStatus(String bookStatus);

}

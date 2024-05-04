package com.assignment.testproject.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepo;

    public List<Book> ListAll(){
        return (List<Book>) bookRepo.findAll();
    }

    public void save(Book book){
        bookRepo.save(book);
    }

    public Book get(Integer id) throws BookNotFoundException {
        Optional<Book> result=bookRepo.findById(id);
        if(result.isPresent()){
            return result.get();
        }
        throw  new BookNotFoundException("Could not find any Book.");
    }

    public void delete(Integer id) throws BookNotFoundException {
        Long count = bookRepo.countById(id);
        if(count==null || count==0){
            throw new BookNotFoundException("Could not find any users with ID " +id);
        }
        bookRepo.deleteById(id);
    }

    public List<Book> findByBookTitle(String bookTitle){
        return  (List<Book>) bookRepo.findBookByBookTitle(bookTitle);
    }
    public List<Book> findAuthorName(String authorName){
        return (List<Book>) bookRepo.findBookByAuthorName(authorName);
    }
    public List<Book> findByBookStatus(String bookStatus){
        return (List<Book>) bookRepo.findBookByBookStatus(bookStatus);
    }
}

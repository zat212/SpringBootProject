package com.assignment.testproject;

import com.assignment.testproject.Book.Book;
import com.assignment.testproject.Book.BookRepository;
//import com.assignment.testproject.user.User;
//import com.assignment.testproject.user.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {
//    @Autowired
//    private UserRepository repo;

    @Autowired
    private BookRepository bookrepo;

//    @Test
//    public void testAddNew(){
//        User user = new User();
//        user.setEmail("zay@gmail.com");
//        user.setPassword("1234567890");
//        user.setFirstName("zay");
//        user.setLastName("Htoo");
//
//       User saveUser =  repo.save(user);
//
//       Assertions.assertThat(saveUser).isNotNull();
//       Assertions.assertThat(saveUser.getId()).isGreaterThan(0);
//    }
//
//    @Test
//    public void testListAll(){
//        Iterable<User> users=repo.findAll();
//        Assertions.assertThat(users).hasSizeGreaterThan(0);
//
//        for(User user:users){
//            System.out.println(user);
//        }
//    }
//
//    @Test
//    public void testUpdate(){
//        Integer userId = 1;
//        Optional<User> optionalUser = repo.findById(userId);
//        User user = optionalUser.get();
//        user.setPassword("1234567890");
//        repo.save(user);
//        User updatedUser = repo.findById(userId).get();
//        Assertions.assertThat(updatedUser.getPassword()).isEqualTo("1234567890");
//
//    }
//
//    @Test
//    public void testGet(){
//        Integer userId = 2;
//        Optional<User> optionalUser = repo.findById(userId);
//        Assertions.assertThat(optionalUser).isPresent();
//        System.out.println(optionalUser.get());
//    }
//
//    @Test
//    public void testDelete(){
//        Integer userId = 2;
//        repo.deleteById(userId);
//
//        Optional<User> optionalUser = repo.findById(userId);
//        Assertions.assertThat(optionalUser).isNotPresent();
//    }

    @Test
    public void testBookListAll(){
        Iterable<Book> books=bookrepo.findAll();
        Assertions.assertThat(books).hasSizeGreaterThan(0);

        for(Book book:books){
            System.out.println(book);
        }
    }

    @Test
    public void testAddBook(){
        Book book = new Book();
//        book.setId(1);
        book.setISBN("232");
        book.setAuthorName("HEHEHEHE");
        book.setBookLocation("s-3");
        book.setBookStatus("lone");
        book.setBookTitle("Hehehe");

        Book saveBook =  bookrepo.save(book);

        Assertions.assertThat(saveBook).isNotNull();
        Assertions.assertThat(saveBook.getId()).isGreaterThan(0);
    }

    @Test
    public void testListBookTitle(){
        String bookTitle ="The Silmarillion";
        Iterable<Book> bookOut = bookrepo.findBookByBookTitle(bookTitle);
        System.out.println(bookOut.toString());

    }

    @Test
    public void testListAuthorName(){
        String authorName = "Maurice Sendak";
        Iterable<Book> bookOut= bookrepo.findBookByAuthorName(authorName);
        System.out.println(bookOut.toString());
    }

    @Test
    public void testListBookStatus(){
        String bookStatus = "Available";
        Iterable<Book> bookOut = bookrepo.findBookByBookStatus(bookStatus);
        System.out.println(bookOut.toString());
    }
}

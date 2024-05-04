package com.assignment.testproject.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService service;

//    @GetMapping("/adminIndex")
//    public String showBookList(Model model){
//        List<Book> listBook= service.ListAll();
//        model.addAttribute("ListBooks",listBook);
//        return "adminIndex";
//    }

    @GetMapping("/adminIndex")
    public String showBookList(Model model,
                               @RequestParam(name = "searchType",required = false) String searchType,
                               @RequestParam(name = "keyword",required = false) String keyword){
        List<Book> listBooks;
        if(searchType != null && keyword!=null){
            switch (searchType){
                case "bookTitle":
                    listBooks = service.findByBookTitle(keyword);
                    break;
                case "authorName":
                    listBooks = service.findAuthorName(keyword);
                    break;
                case "bookStatus":
                    listBooks = service.findByBookStatus(keyword);
                    break;
                default:
                    listBooks = service.ListAll();
                    break;
            }
        }
        else {
            listBooks =service.ListAll();
        }
        model.addAttribute("ListBooks",listBooks);
        return "adminIndex";
    }

    @GetMapping("/adminIndex/new")
    public String showForm(Model model){
        model.addAttribute("book",new Book());
        model.addAttribute("pageTitle","Add new Book");
        return "AddNewBooks";
    }

    @PostMapping("/book/save")
    public String saveBook(Book book){
        service.save(book);
        return "redirect:/adminIndex";
    }
    @GetMapping("/book/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        try {
            Book book = service.get(id);
            model.addAttribute("book", book);
            return "ChangeBook";
        } catch (BookNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/adminIndex";
        }
    }

    @GetMapping("/book/delete/{id}")
    public String deleteBook(@PathVariable("id") Integer id, Model model,RedirectAttributes ra) {
        try {
            service.delete(id);
        } catch (BookNotFoundException e) {
            ra.addFlashAttribute("message",e.getMessage());
        }
        return "redirect:/adminIndex";

    }

}

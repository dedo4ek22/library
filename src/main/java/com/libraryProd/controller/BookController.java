package com.libraryProd.controller;

import com.libraryProd.dao.BookDAO;
import com.libraryProd.dao.PeopleDAO;
import com.libraryProd.model.Book;
import com.libraryProd.model.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/library/book")
public class BookController {
    @Autowired
    private BookDAO bookDAO;

    @GetMapping()
    private String showAllBooks(Model model){
        model.addAttribute("books", bookDAO.getAllBook());
        return "bookViews/showAllBooksView";
    }
    @GetMapping("/addingForm")
    private String addingFormBook(Model model) {
        model.addAttribute("book", new Book());
        return "bookViews/addingForm";
    }
    @PostMapping("/save")
    private String saveBook(@ModelAttribute("book")Book book){
        bookDAO.addBook(book);
        return "redirect:/library/book";
    }
    @GetMapping("/{id}")
    private String showBook(@PathVariable int id, Model model){
        model.addAttribute("book", bookDAO.getBook(id));
        return "bookViews/bookScreen";
    }
    @GetMapping("/{id}/edit")
    private String editBookForm(@PathVariable int id, Model model){
        model.addAttribute("book", bookDAO.getBook(id));
        return "bookViews/editBook";
    }
    @PatchMapping("/{id}")
    private String editBook(@PathVariable int id, @ModelAttribute("book") Book book){
        bookDAO.editBook(book, id);
        return "redirect:/library/book";
    }
    @DeleteMapping("/{id}")
    private String deleteBook(@PathVariable int id){
        bookDAO.deleteBook(id);
        return "redirect:/library/book";
    }

}

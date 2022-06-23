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
@RequestMapping("/library/people")
public class PeopleController {
    @Autowired
    private PeopleDAO peopleDAO;
    @Autowired
    private BookDAO bookDAO;

    @GetMapping()
    private String showAllPeople(Model model){
        model.addAttribute("peoples", peopleDAO.getAllPeople());
        return "peopleViews/showAllPeopleView";
    }
    @GetMapping("/addingForm")
    private String addingFormPeople(Model model) {
        model.addAttribute("people", new People());
        return "peopleViews/addingForm";
    }
    @PostMapping("/save")
    private String savePeople(@ModelAttribute("people")People people){
        peopleDAO.addPeople(people);
        return "redirect:/library/people";
    }
    @GetMapping("/{id}")
    private String showPeople(@PathVariable int id, Model model,@ModelAttribute("book")Book book ){
        model.addAttribute("people", peopleDAO.getPeople(id));
        model.addAttribute("books", bookDAO.getAllBook());
        return "peopleViews/peopleScreen";
    }
    @GetMapping("/{id}/edit")
    private String editPeopleForm(@PathVariable int id, Model model){
        model.addAttribute("people", peopleDAO.getPeople(id));
        return "peopleViews/editPeople";
    }
    @PatchMapping("/{id}")
    private String editPeople(@PathVariable int id, @ModelAttribute("people") People people){
        peopleDAO.editPeople(people,id);
        return "redirect:/library/people";
    }
    @DeleteMapping("/{id}")
    private String deletePeople(@PathVariable int id){
        peopleDAO.deletePeople(id);
        return "redirect:/library/people";
    }
    @PatchMapping("/{book_id}/setBook")
    private String addBookToPeople(@PathVariable int book_id
            , @ModelAttribute("book") Book book){
        peopleDAO.addBookToPeople(book_id, book);
        return "redirect:/library/people";
    }
    @DeleteMapping("/{book_id}/setBook")
    private String deleteBookFromPeople(@ModelAttribute("book") Book book){
        peopleDAO.deleteBookFromPeople(book.getId());
        return "redirect:/library/people";
    }

}

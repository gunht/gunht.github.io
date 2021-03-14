package com.example.spring_02.controller;

import com.example.spring_02.model.Book;
import com.example.spring_02.request.DeleteRequest;
import com.example.spring_02.request.SearchRequest;
import com.example.spring_02.respository.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/library")
public class BookController {
    @Autowired
    private BookDao bookDao;

    @GetMapping
    public String listAll(Model model) {
        model.addAttribute("books", bookDao.getAll());
        return "library";
    }

    @GetMapping(value = "/{id}")
    public String getByID(@PathVariable("id") int id, Model model) {
        Optional<Book> book = bookDao.get(id);
        if (book.isPresent()) {
            model.addAttribute("book", book.get());
        }
        return "book";
    }

    @GetMapping(value = "/add")
    public String add(Model model) {
        model.addAttribute("book", new Book());
        return "add";
    }

    @PostMapping(value = "/save")
    public String save(Book book, BindingResult result, RedirectAttributes redirect) {
        if (result.hasErrors()) {
            return "add";
        }
        if (book.getId() > 0) {
            bookDao.update(book);
        } else {
            bookDao.add(book);
        }
        return "redirect:/library";
    }

    @GetMapping(value = "/edit/{id}")
    public String editById(@PathVariable("id") int id, Model model) {
        Optional<Book> book = bookDao.get(id);
        if (book.isPresent()) {
            model.addAttribute("book", book.get());
        }
        return "add";
    }

    @PostMapping(value = "/delete")
    public String deleteById(@ModelAttribute DeleteRequest deleteRequest, BindingResult result) {
        if (!result.hasErrors()) {
            bookDao.deleteByID(deleteRequest.getId());
        }
        return "redirect:/library";
    }

    @GetMapping(value = "/search")
    public String searchForm(Model model) {
        model.addAttribute("searchRequest", new SearchRequest());
        return "search";
    }

    @PostMapping(value = "/search")
    public String searchByKeywork(@ModelAttribute SearchRequest searchRequest, BindingResult result, Model model) {
        if (!result.hasFieldErrors()) {
            model.addAttribute("books", bookDao.searchByKeywork(searchRequest.getKeywork()));
        }
        return "library";
    }
}

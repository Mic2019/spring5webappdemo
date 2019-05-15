package guru.springframework.spring5webapp.controller;

import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.util.Mappings;
import guru.springframework.spring5webapp.util.ViewNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {

    private BookRepository bookRepository;

    @Autowired
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping(Mappings.BOOKS)
    public String getBooks(Model model){
        model.addAttribute("books", bookRepository.findAll());
        return ViewNames.BOOK_LIST;
    }
}

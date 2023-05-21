package com.metropolitan.it355dz08.controller;

import com.metropolitan.it355dz08.entity.Author;
import com.metropolitan.it355dz08.entity.Book;
import com.metropolitan.it355dz08.entity.CustOrder;
import com.metropolitan.it355dz08.entity.Publisher;
import com.metropolitan.it355dz08.repository.AuthorRepository;
import com.metropolitan.it355dz08.repository.BookRepository;
import com.metropolitan.it355dz08.repository.CustOrderRepository;
import com.metropolitan.it355dz08.repository.PublisherRepository;
import com.metropolitan.it355dz08.service.AuthorService;
import com.metropolitan.it355dz08.service.BookService;
import com.metropolitan.it355dz08.service.CustOrderService;
import com.metropolitan.it355dz08.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class MainController {

    private final AuthorService authorService;
    private final BookService bookService;
    private final PublisherService publisherService;
    private final CustOrderService custOrderService;

    @GetMapping
    public String welcome() {
        return "redirect:/login";
    }

    @RequestMapping(value="/logout", method= RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/";
    }

//    @GetMapping("/book")
//    public String getBooks() {
//
//        Optional<Book> book = bookService.findByTitle("After the Funeral");
//
//        if (book.isPresent()){
//            System.out.println(book.get());
//        }
//        System.out.println("--------------------------------------------------------");
//
//        for (Book b : bookService.findByNumPagesBetween(50, 100)) {
//            System.out.println(b);
//        }
//
//        System.out.println("--------------------------------------------------------");
//        for (Book b : bookService.findByLanguageIdAndNumPagesBetween(1,50, 100)) {
//            System.out.println(b);
//        }
//
//        return "index";
//    }
//
//    @GetMapping("/author")
//    public String getAuthors() {
//        Optional<Author> author = authorService.findByAuthorName("A.J. Jacobs");
//
//        if (author.isPresent()){
//            System.out.println(author.get());
//        }
//
//        System.out.println("--------------------------------------------------------");
//
//        for (Author aut : authorService.findByAuthorNameContainingIgnoreCase("ill")) {
//            System.out.println(aut);
//        }
//
//        System.out.println("--------------------------------------------------------");
//
//        System.out.println("Number of authors whose name end with Armstrong is: " + authorService.countByAuthorNameEndingWith("Armstrong"));
//
//        return "index";
//    }
//
//    @GetMapping("/publisher")
//    public String getPublishers() {
//        for (Publisher pub : publisherService.findByPublisherNameContainingIgnoreCase("bra")) {
//            System.out.println(pub);
//        }
//
//        System.out.println("--------------------------------------------------------");
//
//        for (Publisher pub : publisherService.findByPublisherNameStartingWith("A")) {
//            System.out.println(pub);
//        }
//
//        return "index";
//    }
//
//    @GetMapping("/cust_order")
//    public String getCustOrders() throws ParseException {
//        Date myDate1 = new SimpleDateFormat("yyyy-MM-dd").parse("2021-04-11");
//        Date myDate2 = new SimpleDateFormat("yyyy-MM-dd").parse("2022-05-11");
//        for (CustOrder co : custOrderService.findByOrderDateBetween(myDate1.toInstant(), myDate2.toInstant())) {
//            System.out.println(co);
//        }
//
//        System.out.println("--------------------------------------------------------");
//
//        for (CustOrder co : custOrderService.findByCustomerEmailContainingIgnoreCase("adam")) {
//            System.out.println(co);
//        }
//
//        return "index";
//    }


}

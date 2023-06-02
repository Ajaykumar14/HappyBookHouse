package com.project.happyBookHouse.controller;

import com.project.happyBookHouse.dto.BookDetails;
import com.project.happyBookHouse.service.BookDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class BooksController {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    BookDetailsService bookDetailsService;

    @PostMapping(value = "addBook")
    public String addBook(@RequestBody List<BookDetails> bookDetailsList) {
        String result = null;
        if (CollectionUtils.isEmpty(bookDetailsList)) {
            return "Input List is empty";
        }else {
            result = bookDetailsService.addBook(bookDetailsList);
        }
        return result;
    }

    @PutMapping(value = "updateQuantity/{isbn}/{quantity}")
    public String updateBook(@PathVariable String isbn, @PathVariable String quantity) {
        String result = null;
        if (StringUtils.isEmpty(isbn) || StringUtils.isEmpty(quantity)) {
            result = "isbn or Quantity is empty or null";
        }
        result = bookDetailsService.updateBook(isbn,quantity);
        return result;
    }

    @DeleteMapping(value = "deleteBook/{isbn}")
    public String deleteBook(@PathVariable String isbn) {
        String result = null;
        if(StringUtils.isNotBlank(isbn)) {
            result = bookDetailsService.deleteBook(isbn);
        }
        return result;
    }

    @GetMapping(value = "bookNotInSale")
    public String getBookNotInSale() {
        String result = null;
        bookDetailsService.getBookNotInSale();
        return result;
    }

    @GetMapping(value = "booksByCategory")
    public Map<String ,List<BookDetails>> getBooksByCategory() {
        Map<String ,List<BookDetails>> booksByCategoryMap = bookDetailsService.getBooksByCategory();
        return booksByCategoryMap;
    }

    @GetMapping(value = "minimumSoldOutBook")
    public String getMinimumSoldOutBook() {
        bookDetailsService.getMinimumSoldOutBook();
        return "minimum";
    }

    @GetMapping(value = "bookWithMinimumStock")
    public String getBookWithMinimumStock() {
        bookDetailsService.getBookWithMinimumStock();
        return "minimumStock";
    }

    @GetMapping(value = "getAllBook")
    public List<BookDetails> getAllBook() {
        LOGGER.info("getAllBook Details");
        List<BookDetails> bookDetailsList = bookDetailsService.getAllBook();
        return bookDetailsList;
    }


}

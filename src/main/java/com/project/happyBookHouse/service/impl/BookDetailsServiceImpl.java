package com.project.happyBookHouse.service.impl;

import com.project.happyBookHouse.dto.BookDetails;
import com.project.happyBookHouse.repository.BookDetailsRepo;
import com.project.happyBookHouse.service.BookDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BookDetailsServiceImpl implements BookDetailsService {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    BookDetailsRepo bookDetailsRepo;

    public String addBook(List<BookDetails> bookDetailsList) {
        StringBuilder buffer = new StringBuilder();
        try {
            for (BookDetails bookDetails : bookDetailsList) {
                String isbn = bookDetails.getIsbn();
                BookDetails bookDetailsIsbn = bookDetailsRepo.findByIsbn(isbn);
                if (bookDetailsIsbn == null) {
                    bookDetailsRepo.save(bookDetails);
                    buffer.append(isbn + " is added successfully\n");
                } else {
                    buffer.append(isbn + "isbn is already exists in Database\n");
                }
            }
        } catch (Exception e) {
            LOGGER.error("Exception occurred in Add Book method", e);
        }
        return buffer.toString();
    }

    public String updateBook(String isbn, String quantity) {
        BookDetails bookDetailsIsbn = null;
        try {
            bookDetailsIsbn = bookDetailsRepo.findByIsbn(isbn);
            if (bookDetailsIsbn == null) {
                return "Update Failed..Isbn is not exists in DataBase,Please try with correct isbn";
            } else {
                bookDetailsIsbn.setQuantity(quantity);
                bookDetailsRepo.save(bookDetailsIsbn);
            }
        } catch (Exception e) {
            LOGGER.error("Exception occurred in updateQuantity method  ", e);
        }
        return bookDetailsIsbn.getIsbn() + " is updated with " + quantity;
    }

    public String deleteBook(String isbn) {
        try {
            BookDetails bookDetailsIsbn = bookDetailsRepo.findByIsbn(isbn);
            if (bookDetailsIsbn == null) {
                return "Delete Failed..Isbn is not exists in DataBase,Please try with correct isbn";
            } else {
                bookDetailsRepo.deleteById(isbn);
            }
        } catch (Exception e) {
            LOGGER.error("Exception occurred during delete book ", e);
        }
        return "Record Deleted ! " + isbn;
    }

    public String getBookNotInSale() {
        return null;
    }

    public Map<String ,List<BookDetails>> getBooksByCategory() {
        Map<String ,List<BookDetails>> bookDetails = null;

        return bookDetails;
    }

    public String getMinimumSoldOutBook() {
        return null;
    }

    public String getBookWithMinimumStock() {
        return null;
    }

    @Override
    public List<BookDetails> getAllBook() {
        List<BookDetails> bookDetailsList = null;
        bookDetailsList = bookDetailsRepo.findAll();
        return bookDetailsList;
    }
}

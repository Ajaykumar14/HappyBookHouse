package com.project.happyBookHouse.service;

import com.project.happyBookHouse.dto.BookDetails;

import java.util.List;
import java.util.Map;

public interface BookDetailsService {

    String addBook(List<BookDetails> bookDetailsList);

    String updateBook(String isbn, String quantity);

    String deleteBook(String isbn);

    String getBookNotInSale();

    Map<String ,List<BookDetails>> getBooksByCategory();

    String getMinimumSoldOutBook();

    String getBookWithMinimumStock();

    List<BookDetails> getAllBook();
}

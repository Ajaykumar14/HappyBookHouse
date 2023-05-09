package com.project.happyBookHouse.repository;

import com.project.happyBookHouse.dto.BookDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookDetailsRepo extends JpaRepository<BookDetails, String> {

    BookDetails findByIsbn(String isbn);

    List<BookDetails> findAllByCategory(String category);

}

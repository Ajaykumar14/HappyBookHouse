package com.project.happyBookHouse.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "BOOK_DETAILS")
public class BookDetails {
    @Id
    @Column(name = "isbn", nullable = false)
    private String isbn;
    @Column(name = "bookname")
    private String bookname;
    @Column(name = "category")
    private String category;
    @Column(name = "quantity")
    private String quantity;
    @Column(name = "price")
    private String price;

}

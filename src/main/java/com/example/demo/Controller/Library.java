package com.example.demo.Controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Setter
@Getter
@Table(name="libraryapi")
public class Library {
    @Column(name="book_name")
    private String book_name;
    @Id
    @Column(name="id")
    private String id;
    @Column(name="ISBN")
    private String isbn;
    @Column(name="aisle")
    private int aisle;
    @Column(name="author")
    private String author;
}

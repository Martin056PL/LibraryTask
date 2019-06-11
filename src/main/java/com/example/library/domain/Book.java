package com.example.library.domain;

import org.hibernate.annotations.Generated;
import org.springframework.stereotype.Controller;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "book")
public class Book implements BookInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String title;
    @Column
    private List<String> authors;
    @Column
    private String ISBN;
    @Column
    private String publishingHouse;
    @Column
    private String placeOfDeploy;
    @Column
    private BigDecimal price;


    public Book() {
        //constructor for JPA
    }

    public Book(String title, List<String> authors, String ISBN, String publishingHouse, String placeOfDeploy, BigDecimal price) {
        this.title = title;
        this.authors = authors;
        this.ISBN = ISBN;
        this.publishingHouse = publishingHouse;
        this.placeOfDeploy = placeOfDeploy;
        this.price = price;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public List<String> getAuthors() {
        return authors;
    }

    @Override
    public String getISBN() {
        return ISBN;
    }

    @Override
    public String getPublishingHouse() {
        return publishingHouse;
    }

    @Override
    public String getPlaceOfDeploy() {
        return placeOfDeploy;
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", authors=" + authors +
                ", ISBN='" + ISBN + '\'' +
                ", publishingHouse='" + publishingHouse + '\'' +
                ", placeOfDeploy='" + placeOfDeploy + '\'' +
                ", price=" + price +
                '}';
    }

    private static class BookBuilder {

        private String title;
        private List<String> authors;
        private String ISBN;
        private String publishingHouse;
        private String placeOfDeploy;
        private BigDecimal price;


        public BookBuilder setTitle(String title) {
            this.title = title;
            return this;
        }

        public BookBuilder setAuthors(List<String> authors) {
            this.authors = authors;
            return this;
        }

        public BookBuilder setISBN(String ISBN) {
            this.ISBN = ISBN;
            return this;
        }

        public BookBuilder setPublishingHouse(String publishingHouse) {
            this.publishingHouse = publishingHouse;
            return this;
        }

        public BookBuilder setPlaceOfDeploy(String placeOfDeploy) {
            this.placeOfDeploy = placeOfDeploy;
            return this;
        }

        public BookBuilder setPrice(BigDecimal price) {
            this.price = price;
            return this;
        }

        public Book build() {

            boolean isNull = title == null || authors == null || ISBN == null || publishingHouse == null || placeOfDeploy == null || price == null;

            if (isNull) {
                throw new RuntimeException("Some fields are null!");
            } else {
                return new Book(title, authors, ISBN, publishingHouse, placeOfDeploy, price);
            }
        }
    }
}

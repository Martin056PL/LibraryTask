package com.example.library.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class Book implements Serializable, BookInterface {

    private static final long serialVersionUID = -8819227175701208566L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long bookId;

    @Column
    private String title;

    @ElementCollection
    @CollectionTable(name = "book_authors", joinColumns = @JoinColumn(name = "bookId"))
    @Column(name = "author")
    private List<String> authors;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "publishing_house")
    private String publishingHouse;

    @Column(name = "place_of_deploy")
    private String placeOfDeploy;

    @Column
    private BigDecimal price;


    public Book() {
        //constructor for JPA
    }

    private Book(String title, List<String> authors, String isbn, String publishingHouse, String placeOfDeploy, BigDecimal price) {
        this.title = title;
        this.authors = authors;
        this.isbn = isbn;
        this.publishingHouse = publishingHouse;
        this.placeOfDeploy = placeOfDeploy;
        this.price = price;
    }

    public Long getBookId() {
        return bookId;
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
    public String getIsbn() {
        return isbn;
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
                ", isbn='" + isbn + '\'' +
                ", publishingHouse='" + publishingHouse + '\'' +
                ", placeOfDeploy='" + placeOfDeploy + '\'' +
                ", price=" + price +
                '}';
    }

    public static class BookBuilder {

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

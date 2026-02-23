package OOP.BooksManagement;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Objects;


public class Book {
    private int id;
    private  String name;
    private Author[] authors;
    private Publisher publisher;
    private int publishingYear;
    private int amountOfPages;
    private BigDecimal price;
    private CoverType coverType;

    public Book(int id, String name, Author[] authors, Publisher publisher, int publishingYear, int amountOfPages, BigDecimal price, CoverType coverType) {
        this.id = id;
        this.name = name;
        this.authors = authors;
        this.publisher = publisher;
        this.publishingYear = publishingYear;
        this.amountOfPages = amountOfPages;
        this.price = price;
        this.coverType = coverType;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Author[] getAuthors() {
        return authors;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public int getPublishingYear() {
        return publishingYear;
    }

    public int getAmountOfPages() {
        return amountOfPages;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public CoverType getCoverType() {
        return coverType;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id && publishingYear == book.publishingYear && amountOfPages == book.amountOfPages && Objects.equals(name, book.name) && Objects.deepEquals(authors, book.authors) && Objects.equals(publisher, book.publisher) && Objects.equals(price, book.price) && coverType == book.coverType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, Arrays.hashCode(authors), publisher, publishingYear, amountOfPages, price, coverType);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", authors=" + Arrays.toString(authors) +
                ", publisher=" + publisher +
                ", publishingYear=" + publishingYear +
                ", amountOfPages=" + amountOfPages +
                ", price=" + price +
                ", coverType=" + coverType +
                '}';
    }
    public boolean hasAuthor(Author authorCriteria) {
        for (Author author : authors) {
            if (author.equals(authorCriteria)) {
                return true;
            }
        }
        return false;
    }

}

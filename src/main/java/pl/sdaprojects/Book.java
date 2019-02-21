package pl.sdaprojects;

import java.math.BigDecimal;

public class Book implements Comparable<Book> {
    private String title;
    private BigDecimal price;
    private Boolean inStock;

    public Book(String title, BigDecimal price, boolean inStock) {
        this.title = title;
        this.price = price;
        this.inStock = inStock;
    }


    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", price=" + price +
                ", inStock=" + inStock +
                '}' + "\n";
    }

    @Override
    public int compareTo(Book book) {
        int titleCompare = title.compareTo(book.title);

        if(titleCompare == 0){
            return book.inStock.compareTo(inStock);
        }

        return titleCompare;
    }
}
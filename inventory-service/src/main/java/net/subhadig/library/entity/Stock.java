package net.subhadig.library.entity;

import io.micronaut.core.annotation.Creator;
import io.micronaut.core.annotation.Introspected;
import org.bson.codecs.pojo.annotations.BsonCreator;

import javax.validation.constraints.NotNull;

@Introspected
public class Stock {

    @NotNull
    private Book book;

    @NotNull
    private Integer count;

    @Creator
    @BsonCreator
    public Stock(@NotNull Book book, @NotNull Integer count) {
        this.book = book;
        this.count = count;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}

package net.subhadig.library.entity;

import io.micronaut.core.annotation.Creator;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.core.annotation.Nullable;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonIgnore;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Introspected
public class Book {

    @BsonId
    @BsonProperty("_id")
    private ObjectId id;

    @NotNull
    @NotBlank
    @BsonProperty("name")
    private String name;

    @NotNull
    @BsonProperty("author")
    private String author;

    @Nullable
    @BsonProperty("version")
    private String version;

    @NotNull
    @BsonProperty("publisher")
    private String publisher;

    @Creator
    @BsonCreator
    public Book(@BsonProperty("_id") ObjectId id,
                @NotNull @NotBlank @BsonProperty("name") String name,
                @NotNull @BsonProperty("author") String author,
                @Nullable @BsonProperty("version") String version,
                @NotNull @BsonProperty("publisher") String publisher) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.version = version;
        this.publisher = publisher;
    }

    @BsonIgnore
    public String getIdString() {
        return id.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Nullable
    public String getVersion() {
        return version;
    }

    public void setVersion(@Nullable String version) {
        this.version = version;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}

package net.subhadig.library.repository;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.InsertOneResult;
import jakarta.inject.Singleton;
import net.subhadig.library.MongoDbConfiguration;
import net.subhadig.library.entity.Book;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class MongoDbBookRepository implements BookRepository {

    private final MongoDbConfiguration mongoDbConfiguration;

    private final MongoClient mongoClient;

    public MongoDbBookRepository(MongoDbConfiguration mongoDbConfiguration, MongoClient mongoClient) {
        this.mongoDbConfiguration = mongoDbConfiguration;
        this.mongoClient = mongoClient;
    }

    @Override
    public @NotNull List<Book> list() {
        return getCollection().find().into(new ArrayList<>());
    }

    @Override
    public void save(@NotNull @Valid Book book) {
        InsertOneResult result = getCollection().insertOne(book);
        System.out.println("Insert Id: " + result.getInsertedId());
    }

    private MongoCollection<Book> getCollection() {
        return mongoClient.getDatabase(mongoDbConfiguration.getName())
                .getCollection(mongoDbConfiguration.getCollection(), Book.class);
    }
}

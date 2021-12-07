package net.subhadig.library;

import io.micronaut.context.annotation.ConfigurationProperties;
import io.micronaut.core.naming.Named;

import javax.validation.constraints.NotNull;

@ConfigurationProperties("db")
public interface MongoDbConfiguration extends Named {

    @NotNull
    String getCollection();
}

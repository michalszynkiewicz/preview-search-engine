package com.example.search.engine;


import io.smallrye.reactive.messaging.annotations.Emitter;
import io.smallrye.reactive.messaging.annotations.Stream;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static java.util.Arrays.asList;

@Path("/search")
public class SearchEndpoint {

    @Inject
    PageStorage pageStorage;

    @Stream("search-terms")
    @Inject
    Emitter<String> searchTermsEmitter;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Collection<String> search(@QueryParam("query") String query, @QueryParam("userId") String userId) {

        searchTermsEmitter.send(String.format("%s|%s", query, userId));

        Set<String> keywords = new HashSet<>(asList(query.split("[^\\w]+")));
        return pageStorage.search(keywords);
    }

}
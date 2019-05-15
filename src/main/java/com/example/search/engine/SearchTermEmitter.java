package com.example.search.engine;

import io.smallrye.reactive.messaging.annotations.Emitter;
import io.smallrye.reactive.messaging.annotations.Stream;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 * mstodo: Header
 *
 * @author Michal Szynkiewicz, michal.l.szynkiewicz@gmail.com
 * <br>
 * Date: 15/05/2019
 */
@ApplicationScoped
public class SearchTermEmitter {

    @Stream("search-terms")
    @Inject
    Emitter<String> searchTermsEmitter;

    public void emit(String term, String userId) {
        searchTermsEmitter.send(String.format("%s|%s", term, userId));
    }
}

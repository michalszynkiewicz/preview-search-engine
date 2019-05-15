package com.example.search.engine;

import javax.annotation.Priority;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;

/**
 * mstodo: Header
 *
 * @author Michal Szynkiewicz, michal.l.szynkiewicz@gmail.com
 * <br>
 * Date: 15/05/2019
 */
@ApplicationScoped
@Alternative
@Priority(1)
public class SearchTermEmitterMock extends SearchTermEmitter {
    @Override
    public void emit(String term, String userId) {
        System.out.println(String.format("would emit: %s for user %s", term, userId));
    }
}

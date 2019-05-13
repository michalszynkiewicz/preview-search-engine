package com.example.search.engine;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Michal Szynkiewicz, michal.l.szynkiewicz@gmail.com
 * <br>
 * Date: 13/05/2019
 */
@ApplicationScoped
public class PageStorage {

    private static final Logger log = LoggerFactory.getLogger(PageStorage.class);

    public Collection<String> search(Set<String> keywords) {
        log.info("searching for keywords: {}", keywords);

        PanacheQuery<PageKeyword> results = PageKeyword.find("keyword in ?1", keywords);

        return results.stream()
                .collect(Collectors.groupingBy(pk -> pk.page))
                .entrySet().stream()
                .sorted(Comparator.comparingInt(entry -> entry.getValue().size()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

}

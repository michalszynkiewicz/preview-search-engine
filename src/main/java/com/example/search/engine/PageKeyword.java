package com.example.search.engine;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;

/**
 * @author Michal Szynkiewicz, michal.l.szynkiewicz@gmail.com
 * <br>
 * Date: 13/05/2019
 */
@Entity
public class PageKeyword extends PanacheEntity {
    String page;

    String keyword;
}

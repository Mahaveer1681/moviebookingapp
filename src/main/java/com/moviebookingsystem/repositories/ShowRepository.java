package com.moviebookingsystem.repositories;

import com.moviebookingsystem.dto.FilterSearchCriteria;
import com.moviebookingsystem.models.Movie;
import com.moviebookingsystem.models.Show;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ShowRepository {

    @Autowired
    private EntityManager entityManager;

    public List<Show> getAllShows(FilterSearchCriteria searchCriteria) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<Show> query = cb.createQuery(Show.class);
        Root<Show> showRoot = query.from(Show.class);

        List<Predicate> predicates = new ArrayList<>();
        if (searchCriteria.getLanguage() != null) {
            Join<Show, Movie> joinShowMovie = showRoot.join("movie", JoinType.INNER);
            predicates.add(cb.equal(joinShowMovie.get("language"), searchCriteria.getLanguage()));
        }
        if (searchCriteria.getShowTime() != null) {
            predicates.add(cb.greaterThanOrEqualTo(showRoot.get("showTime"), searchCriteria.getShowTime()));
        }

        query.select(showRoot).where(cb.and(predicates.toArray(new Predicate[0])));

        return entityManager.createQuery(query).getResultList();
    }
}

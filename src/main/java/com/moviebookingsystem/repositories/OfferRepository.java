package com.moviebookingsystem.repositories;

import com.moviebookingsystem.models.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfferRepository extends JpaRepository<Offer,Long> {

  public List<Offer> findAllByShowShowId(Long showId);


}

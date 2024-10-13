package com.moviebookingsystem.repositories;

import com.moviebookingsystem.models.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {


@Query("From seats s where s.screen.screenId=:screenId and s.seatNumber in :seatNumbers")
    List<Seat> findAllByScreenIdAndSeatNumberIn(@Param("screenId") Long screenId, @Param("seatNumbers") Iterable<String> seatNumbers);

}

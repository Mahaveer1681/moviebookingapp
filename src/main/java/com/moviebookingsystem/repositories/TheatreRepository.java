package com.moviebookingsystem.repositories;


import com.moviebookingsystem.models.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TheatreRepository extends JpaRepository<Theatre, Long> {
    @Override
    Theatre save(Theatre theatre);

    @Override
    void deleteById(Long id);

    //List<Theatre> findAllByCityName(String city);

}

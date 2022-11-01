package com.pluralsight.springdataoverview.repository;

import com.pluralsight.springdataoverview.entity.Flight;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface FlightRepository extends PagingAndSortingRepository<Flight, Long>, DeleteByOriginRepository {
    List<Flight> findByOrigin(String origin);
    List<Flight> findByOriginAndDestination(String origin, String destination);
    List<Flight> findByOriginIn(String ...origin);
    List<Flight> findByOriginIgnoreCase(String origin);
    Page<Flight> findByOrigin(String origin, Pageable pageRequest);
    List<Flight> findByOriginNotLike(String origin);
}

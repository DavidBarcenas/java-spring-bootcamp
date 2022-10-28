package com.pluralsight.springdataoverview;

import com.pluralsight.springdataoverview.entity.Flight;
import com.pluralsight.springdataoverview.repository.FlightRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.Iterator;

import static org.assertj.core.api.Assertions.*;
import static org.springframework.data.domain.Sort.*;
import static org.springframework.data.domain.Sort.Direction.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PagingAndSortingTests {
    @Autowired
    FlightRepository flightRepository;

    @Before
    public void setUp() {
        flightRepository.deleteAll();
    }

    @Test
    public void shouldSortFlightsByDestination() {
        final Flight mexico = createFlight("Mexico");
        final Flight paris = createFlight("Paris");
        final Flight london = createFlight("London");

        flightRepository.save(mexico);
        flightRepository.save(paris);
        flightRepository.save(london);

        final Iterable<Flight> flights = flightRepository.findAll(by("destination"));

        assertThat(flights).hasSize(3);

        final Iterator<Flight> iterator = flights.iterator();

        assertThat(iterator.next().getDestination()).isEqualTo("London");
        assertThat(iterator.next().getDestination()).isEqualTo("Mexico");
        assertThat(iterator.next().getDestination()).isEqualTo("Paris");
    }

    @Test
    public void shouldSortFlightByScheduleAndThenName() {
        final LocalDateTime now = LocalDateTime.now();
        final Flight paris1 = createFlight("Paris", now);
        final Flight paris2= createFlight("Paris", now.plusHours(2));
        final Flight paris3 = createFlight("Paris", now.minusHours(1));
        final Flight london1 = createFlight("London", now.minusHours(3));
        final Flight london2 = createFlight("London", now);

        flightRepository.save(paris1);
        flightRepository.save(paris2);
        flightRepository.save(paris3);
        flightRepository.save(london1);
        flightRepository.save(london2);

        final Iterable<Flight> flights = flightRepository.findAll(by("destination", "scheduleAt"));

        assertThat(flights).hasSize(5);

        final Iterator<Flight> iterator = flights.iterator();

        assertThat(iterator.next()).usingRecursiveComparison().isEqualTo(london1);
        assertThat(iterator.next()).usingRecursiveComparison().isEqualTo(london2);
        assertThat(iterator.next()).usingRecursiveComparison().isEqualTo(paris3);
        assertThat(iterator.next()).usingRecursiveComparison().isEqualTo(paris1);
        assertThat(iterator.next()).usingRecursiveComparison().isEqualTo(paris2);
    }

    @Test
    public void shouldPageResults() {
        for (int i = 0; i < 50; i++) {
            flightRepository.save(createFlight(String.valueOf(i)));
        }

        final Page<Flight> page = flightRepository.findAll(PageRequest.of(2, 5));

        assertThat(page.getTotalElements()).isEqualTo(50);
        assertThat(page.getNumberOfElements()).isEqualTo(5);
        assertThat(page.getTotalPages()).isEqualTo(10);
        assertThat(page.getContent())
                .extracting(Flight::getDestination)
                .containsExactly("10", "11", "12", "13", "14");
    }

    @Test
    public void shouldPageAndSortResults() {
        for (int i = 0; i < 50; i++) {
            flightRepository.save(createFlight(String.valueOf(i)));
        }

        final Page<Flight> page = flightRepository.findAll(PageRequest.of(2, 5, by(DESC, "destination")));

        assertThat(page.getTotalElements()).isEqualTo(50);
        assertThat(page.getNumberOfElements()).isEqualTo(5);
        assertThat(page.getTotalPages()).isEqualTo(10);
        assertThat(page.getContent())
                .extracting(Flight::getDestination)
                .containsExactly("44", "43", "42", "41", "40");
    }

    @Test
    public void shouldPageAndSortADerivedQuery() {
        for (int i = 0; i < 10; i++) {
            final Flight flightToParis = createFlight(String.valueOf(i));
            final Flight flightToLondon = createFlight(String.valueOf(i));
            flightToParis.setOrigin("Paris");
            flightToLondon.setOrigin("London");

            flightRepository.save(flightToParis);
            flightRepository.save(flightToLondon);
        }

        final Page<Flight> page = flightRepository.findByOrigin("London", PageRequest.of(0, 5, by(DESC, "destination")));

        assertThat(page.getTotalElements()).isEqualTo(10);
        assertThat(page.getNumberOfElements()).isEqualTo(5);
        assertThat(page.getTotalPages()).isEqualTo(2);
        assertThat(page.getContent())
                .extracting(Flight::getDestination)
                .containsExactly("9", "8", "7", "6", "5");
    }

    private Flight createFlight(String destination, LocalDateTime scheduleAt) {
        final Flight flight = new Flight();
        flight.setOrigin("London");
        flight.setDestination(destination);
        flight.setScheduleAt(scheduleAt);
        return flight;
    }

    private Flight createFlight(String destination) {
        return createFlight(destination, LocalDateTime.parse("2022-12-23T12:12:00"));
    }
}

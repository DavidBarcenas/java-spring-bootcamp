package com.pluralsight.springdataoverview;

import com.pluralsight.springdataoverview.entity.Flight;
import com.pluralsight.springdataoverview.repository.FlightRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class DerivedQueryTests {
    @Autowired
    private FlightRepository flightRepository;

    @Before
    public void setUp() {
        flightRepository.deleteAll();
    }

    @Test
    public void shouldFindFlightsFromMexico() {
        final Flight flight1 = createFlight("Mexico");
        final Flight flight2 = createFlight("Mexico");
        final Flight flight3 = createFlight("London");

        flightRepository.save(flight1);
        flightRepository.save(flight2);
        flightRepository.save(flight3);

        final List<Flight> flightsToMexico = flightRepository.findByOrigin("Mexico");

        assertThat(flightsToMexico).hasSize(2);
        assertThat(flightsToMexico.get(0)).usingRecursiveComparison().isEqualTo(flight1);
        assertThat(flightsToMexico.get(1)).usingRecursiveComparison().isEqualTo(flight2);
    }

    @Test
    public void shouldFindFlightsFromLondonToParis() {
        final Flight flight1 = createFlight("London", "Paris");
        final Flight flight2 = createFlight("London", "Mexico");
        final Flight flight3 = createFlight("Mexico", "New York");

        flightRepository.save(flight1);
        flightRepository.save(flight2);
        flightRepository.save(flight3);

        final List<Flight> londonToParis = flightRepository.findByOriginAndDestination("London", "Paris");

        assertThat(londonToParis).hasSize(1);
        assertThat(londonToParis)
                .first()
                .usingRecursiveComparison()
                .isEqualTo(flight1);
    }

    @Test
    public void shouldFindFlightsFromLondonOrMexico() {
        final Flight flight1 = createFlight("London", "Paris");
        final Flight flight2 = createFlight("Tokyo", "Italy");
        final Flight flight3 = createFlight("Mexico", "New York");

        flightRepository.save(flight1);
        flightRepository.save(flight2);
        flightRepository.save(flight3);

        final List<Flight> londonOrMexico = flightRepository.findByOriginIn("London", "Mexico");

        assertThat(londonOrMexico).hasSize(2);
        assertThat(londonOrMexico.get(0)).usingRecursiveComparison().isEqualTo(flight1);
        assertThat(londonOrMexico.get(1)).usingRecursiveComparison().isEqualTo(flight3);
    }

    @Test
    public void shouldFindFlightsFromLondonIgnoringCase() {
        final Flight flight = createFlight("LONDON");

        flightRepository.save(flight);

        final List<Flight> fromLondon = flightRepository.findByOriginIgnoreCase("London");

        assertThat(fromLondon)
                .hasSize(1)
                .first()
                .usingRecursiveComparison()
                .isEqualTo(flight);
    }

    @Test
    public void shouldFindFlightsDoNotOriginMexico() {
        final Flight flight1 = createFlight("London", "Paris");
        final Flight flight2 = createFlight("Mexico", "Italy");
        final Flight flight3 = createFlight("Mexico", "New York");

        flightRepository.save(flight1);
        flightRepository.save(flight2);
        flightRepository.save(flight3);

        final List<Flight> noFlightsFromMexico = flightRepository.findByOriginNotLike("Mexico");

        assertThat(noFlightsFromMexico)
                .hasSize(1)
                .first()
                .usingRecursiveComparison()
                .isEqualTo(flight1);
    }

    private Flight createFlight(String origin, String destination) {
        final Flight flight = new Flight();
        flight.setOrigin(origin);
        flight.setDestination(destination);
        flight.setScheduleAt(LocalDateTime.parse("2022-12-23T12:12:00"));
        return flight;
    }
    private Flight createFlight(String origin) {
        return createFlight(origin, "Paris");
    }
}

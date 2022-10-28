package com.pluralsight.springdataoverview;

import com.pluralsight.springdataoverview.entity.Flight;
import com.pluralsight.springdataoverview.repository.FlightRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomImplTests {
    @Autowired
    private FlightRepository flightRepository;

    @Test
    public void shouldSaveCustomImpl() {
        final Flight toDelete = createFlight("London");
        final Flight toKeep = createFlight("Paris");

        flightRepository.save(toDelete);
        flightRepository.save(toKeep);

        flightRepository.deleteByOrigin("London");

        assertThat(flightRepository.findAll())
                .hasSize(1)
                .first()
                .usingRecursiveComparison()
                .isEqualTo(toKeep);
    }

    private Flight createFlight(String origin) {
        final Flight flight = new Flight();
        flight.setOrigin(origin);
        flight.setDestination("Tokyo");
        flight.setScheduleAt(LocalDateTime.now());
        return flight;
    }
}

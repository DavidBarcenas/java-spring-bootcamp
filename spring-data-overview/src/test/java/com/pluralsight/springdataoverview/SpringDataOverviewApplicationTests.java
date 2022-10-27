package com.pluralsight.springdataoverview;

import com.pluralsight.springdataoverview.entity.Flight;
import com.pluralsight.springdataoverview.repository.FlightRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringDataOverviewApplicationTests {
	@Autowired
	private EntityManager entityManager;

	@Autowired
	private FlightRepository flightRepository;

	@Test
	@Transactional
	void verifyFlightCanBeSaved() {
		Flight flight = createFlight();
		entityManager.persist(flight);

		final TypedQuery<Flight> results = entityManager.createQuery("SELECT f FROM Flight f", Flight.class);
		final List<Flight> resultList = results.getResultList();

		assertThat(resultList)
				.hasSize(1)
				.first()
				.isEqualTo(flight);
	}

	@Test
	public void shouldPerformCRUDOperations() {
		Flight flight = createFlight();
		flightRepository.save(flight);

		assertThat(flightRepository.findAll())
				.hasSize(1)
				.first()
				.usingRecursiveComparison()
				.isEqualTo(flight);

		flightRepository.deleteById(flight.getId());

		assertThat(flightRepository.count()).isZero();
	}

	public Flight createFlight() {
		final Flight flight = new Flight();
		flight.setOrigin("New York");
		flight.setDestination("Mexico City");
		flight.setScheduleAt(LocalDateTime.parse("2022-12-23T12:12:00"));
		return flight;
	}
}

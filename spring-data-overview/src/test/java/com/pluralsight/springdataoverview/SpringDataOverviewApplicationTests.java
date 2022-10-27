package com.pluralsight.springdataoverview;

import com.pluralsight.springdataoverview.entity.Flight;
import org.assertj.core.api.Assertions;
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

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringDataOverviewApplicationTests {
	@Autowired
	private EntityManager entityManager;

	@Test
	@Transactional
	void verifyFlightCanBeSaved() {
		final Flight flight = new Flight();
		flight.setOrigin("New York");
		flight.setDestination("Mexico City");
		flight.setScheduleAt(LocalDateTime.parse("2022-12-23T12:12:00"));

		entityManager.persist(flight);

		final TypedQuery<Flight> results = entityManager.createQuery("SELECT f FROM Flight f", Flight.class);
		final List<Flight> resultList = results.getResultList();

		Assertions.assertThat(resultList)
				.hasSize(1)
				.first()
				.isEqualTo(flight);
	}
}

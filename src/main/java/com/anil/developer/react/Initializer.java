package com.anil.developer.react;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.anil.developer.react.model.Event;
import com.anil.developer.react.model.Group;
import com.anil.developer.react.repo.GroupRepository;

import java.time.Instant;
import java.util.Collections;
import java.util.stream.Stream;

@Component
public class Initializer implements CommandLineRunner {

	private final GroupRepository repository;

	public Initializer(GroupRepository repository) {
		this.repository = repository;
	}

	@Override
	public void run(String... strings) {
		Stream.of("Anil Paul", "Prince Paul", "Shimya Anil", "Serene Prince")
				.forEach(name -> repository.save(new Group(name)));

		Group djug = repository.findByName("Denver JUG");
		Event e = Event.builder().title("Anil Paul")
				.description("Reactive with Spring Boot + React")
				.date(Instant.parse("2018-12-12T18:00:00.000Z")).build();
		djug.setEvents(Collections.singleton(e));
		repository.save(djug);

		repository.findAll().forEach(System.out::println);
	}
}

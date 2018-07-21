package com.anil.developer.react.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anil.developer.react.model.Group;

public interface GroupRepository extends JpaRepository<Group, Long> {
	Group findByName(String name);
}

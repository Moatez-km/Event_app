package de.tekup.ex.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tekup.ex.models.Reactions;

public interface ReactionsRepository extends JpaRepository<Reactions, Long> {

}

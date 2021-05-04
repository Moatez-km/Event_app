package de.tekup.ex.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tekup.ex.models.Activite;

public interface ActivityRepository extends JpaRepository<Activite, Long>{

}

package de.tekup.ex.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tekup.ex.models.Chats;

public interface ChatsRepository extends JpaRepository<Chats, Long>{

}

package de.tekup.ex.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tekup.ex.models.Comment;


public interface CommentRepository extends JpaRepository<Comment, Long>{

}

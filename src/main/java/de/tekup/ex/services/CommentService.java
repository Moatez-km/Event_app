package de.tekup.ex.services;

import de.tekup.ex.models.Comment;

public interface CommentService {
	
	void SaveComment(String message,long idu,long ida);
	Comment getCommentById(long id);

}

package de.tekup.ex.services;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.tekup.ex.models.Comment;
import de.tekup.ex.repositories.ActivityRepository;
import de.tekup.ex.repositories.CommentRepository;
import de.tekup.ex.repositories.UserRepository;
@Service
public class CommentServiceImpl implements CommentService{
	
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private ActivityRepository activiteRepo;
	@Autowired
	private CommentRepository commentRepo;

	@Override
	public void SaveComment(String time,String message, long idu, long ida) {
		// TODO Auto-generated method stub
		
		Comment c=new Comment();
		c.setTime(time);
		c.setMessage(message);
		c.setActivite(activiteRepo.findById(ida).get());
		c.setUser(userRepo.findById(idu).get());
		
		commentRepo.save(c);
		
	}

	@Override
	public Comment getCommentById(long id) {
		// TODO Auto-generated method stub
		Optional<Comment>opt=commentRepo.findById(id);
		Comment entity;
		if(opt.isPresent()) 
			entity=opt.get();
		else
			throw new NoSuchElementException("Acitivity with this Id is not found");
		
		return entity;
	}

}

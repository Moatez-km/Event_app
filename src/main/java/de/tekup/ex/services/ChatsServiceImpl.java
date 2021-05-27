package de.tekup.ex.services;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.tekup.ex.models.Chats;

import de.tekup.ex.repositories.ChatsRepository;
import de.tekup.ex.repositories.UserRepository;

@Service
public class ChatsServiceImpl implements ChatsService{
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private ChatsRepository chatRepo;

	@Override
	public void SaveChats(String message,String date, long id_user) {
		// TODO Auto-generated method stub
		Chats c =new Chats();
		c.setDate(date);
		c.setMessage(message);
		c.setUser(userRepo.findById(id_user).get());
		chatRepo.save(c);
		
	
		
	}

	@Override
	public Chats getChatsById(long id) {
		// TODO Auto-generated method stub
		Optional<Chats>opt=chatRepo.findById(id);
		Chats entity;
		if(opt.isPresent()) 
			entity=opt.get();
		else
			throw new NoSuchElementException("chats with this Id is not found");
		
		return entity;
	}

}

package de.tekup.ex.services;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.tekup.ex.models.Reactions;
import de.tekup.ex.repositories.ActivityRepository;
import de.tekup.ex.repositories.ReactionsRepository;
import de.tekup.ex.repositories.UserRepository;
@Service
public class ReactionsServiceImpl implements ReactionsService{
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private ActivityRepository actiRepo;
	@Autowired
	private ReactionsRepository reactRepo;

	@Override
	public void saveReact( long id_user, long id_activite) {
		// TODO Auto-generated method stub
		Reactions r =new Reactions();
		r.setUser(userRepo.findById(id_user).get());
		r.setActivite(actiRepo.findById(id_activite).get());
	int compteur=1;
		compteur=compteur+r.getCompteur();
		
		
		r.setCompteur(compteur);
		reactRepo.save(r);
		
	}

	@Override
	public Reactions getReactById(long id) {
		// TODO Auto-generated method stub
		Optional<Reactions>opt=reactRepo.findById(id);
		Reactions entity;
		if(opt.isPresent()) 
			entity=opt.get();
		else
			throw new NoSuchElementException("Acitivity with this Id is not found");
		
		return entity;
	}

}

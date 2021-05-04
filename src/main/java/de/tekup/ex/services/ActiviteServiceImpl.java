package de.tekup.ex.services;

import java.io.IOException;
import java.util.Base64;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.web.multipart.MultipartFile;

import de.tekup.ex.models.Activite;
import de.tekup.ex.repositories.ActivityRepository;
import de.tekup.ex.repositories.UserRepository;
@Service
public class ActiviteServiceImpl implements ActivityService {
	@Autowired
	private UserRepository userRepo;

	@Autowired
	private ActivityRepository activityRepo;
	@Override
	public void SaveActivityToDB(MultipartFile file, String name, String description, String type,String date, long idu) {
		// TODO Auto-generated method stub
		Activite a=new Activite();
		String fileName=org.springframework.util.StringUtils.cleanPath(file.getOriginalFilename());
		if(fileName.contains("..")) {
			throw new NoSuchElementException("image not valid");
			}
		try {
			a.setImagecover(Base64.getEncoder().encodeToString(file.getBytes()));
			
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		a.setName(name);
		a.setDescription(description);
		a.setType(type);
		a.setDate(date);
		a.setUser(userRepo.findById(idu).get());
		activityRepo.save(a);
	}

	@Override
	public Activite getActiviteById(long id) {
		// TODO Auto-generated method stub
		Optional<Activite>opt=activityRepo.findById(id);
		Activite entity;
		if(opt.isPresent()) 
			entity=opt.get();
		else
			throw new NoSuchElementException("Acitivity with this Id is not found");
		
		return entity;
	}

}

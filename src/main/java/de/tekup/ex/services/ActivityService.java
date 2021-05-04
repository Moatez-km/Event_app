package de.tekup.ex.services;

import org.springframework.web.multipart.MultipartFile;

import de.tekup.ex.models.Activite;

public interface ActivityService {
	
	void SaveActivityToDB(MultipartFile file,String name,String description,String type,String date,long idu);
	Activite getActiviteById(long id);

}

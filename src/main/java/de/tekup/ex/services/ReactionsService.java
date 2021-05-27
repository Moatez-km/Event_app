package de.tekup.ex.services;

import de.tekup.ex.models.Reactions;

public interface ReactionsService {

	void saveReact(long id_user,long id_activite);
	Reactions getReactById(long id);
}

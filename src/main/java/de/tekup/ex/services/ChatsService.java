package de.tekup.ex.services;

import de.tekup.ex.models.Chats;

public interface ChatsService {
	void SaveChats(String message,String date,long id_user);
	Chats getChatsById(long id);

}

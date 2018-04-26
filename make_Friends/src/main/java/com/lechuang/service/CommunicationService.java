package com.lechuang.service;

import java.util.List;

import com.lechuang.bean.Communication;
import com.lechuang.bean.Invited;

public interface CommunicationService {

	void sendInvitation(Communication c);

	void acceptInvitation(Communication c);

	void rejectInvitation(Communication c);

	List<Invited> select_B_Invited(String u_open_id);

	List<Invited> select_B_Accept(String u_open_id);

}

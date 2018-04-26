package com.lechuang.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lechuang.bean.Communication;
import com.lechuang.bean.Invited;
import com.lechuang.mapper.CommunicationMapper;


@Service
public class CommunicationServiceImp implements CommunicationService{
	
	@Autowired
	CommunicationMapper communicationMapper;
	
	public void sendInvitation(Communication c) {
		communicationMapper.sendInvitation(c);
		
	}

	public void acceptInvitation(Communication c) {
		communicationMapper.acceptInvitation(c);
		
	}

	public void rejectInvitation(Communication c) {
		communicationMapper.rejectInvitation(c);
		
	}

	public List<Invited> select_B_Invited(String u_open_id) {
		
		return communicationMapper.select_B_Invited(u_open_id);
	}

	public List<Invited> select_B_Accept(String u_open_id) {
		
		return communicationMapper.select_B_Accept(u_open_id);
	}

}

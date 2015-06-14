package com.eyooya.app.platform.db.service.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eyooya.app.platform.db.model.security.UserSecurity;
import com.eyooya.app.platform.db.repository.UserSecurityRepository;
import com.eyooya.app.platform.db.service.sequence.SequenceService;
import com.eyooya.app.web.api.internal.controller.form.UserDetails;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserSecurityRepository userSecurityRepository;
	@Autowired
	private SequenceService sequenceService;
	
	@Transactional
	@Override
	public UserSecurity registerNewUserAccount(UserDetails userDetails) {
		
		List <Integer> roles = new ArrayList<>();
		roles.add(1);
		
		long id = sequenceService.getNextSequence("members");
		UserSecurity user = new UserSecurity(id, userDetails.getFirstName(), userDetails.getLastName(), userDetails.getEmail(), userDetails.getPassword(), roles);
		userSecurityRepository.save(user);
		
		return user;
	}

}

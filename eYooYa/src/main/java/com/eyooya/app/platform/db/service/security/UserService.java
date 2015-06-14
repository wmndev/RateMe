package com.eyooya.app.platform.db.service.security;

import com.eyooya.app.platform.db.model.security.UserSecurity;
import com.eyooya.app.web.api.internal.controller.form.UserDetails;

public interface UserService {
	
	UserSecurity registerNewUserAccount(UserDetails userDetails);  

}

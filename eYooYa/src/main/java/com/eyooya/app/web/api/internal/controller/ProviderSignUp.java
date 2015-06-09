package com.eyooya.app.web.api.internal.controller;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.social.facebook.api.Account;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import com.eyooya.app.web.api.internal.controller.form.SignupForm;

@Controller
public class ProviderSignUp {
	
	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public SignupForm signupForm(WebRequest request) {
	    Connection<?> connection = ProviderSignInUtils.getConnection(request);
	    if (connection != null) {
	        return SignupForm.fromProviderUser(connection.fetchUserProfile());
	    } else {
	        return new SignupForm();
	    }
	}
	
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public String signup(SignupForm form, BindingResult formBinding, WebRequest request) {
	    if (formBinding.hasErrors()) {
	        return null;
	    }
	    //Account account = createAccount(form, formBinding);
	    //if (account != null) {
	        //SignInUtils.signin(account.getUsername());
	        ProviderSignInUtils.handlePostSignUp("itayw", request);
	        return "redirect:/";
	    //}
	    //return null;
	}

//	private Account createAccount(SignupForm form, BindingResult formBinding) {
//		// TODO Auto-generated method stub
//		Account account = new Account();
//		account
//		
//	}

}

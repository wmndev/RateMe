package com.eyooya.app.web.api.internal.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.eyooya.app.platform.db.model.security.UserSecurity;
import com.eyooya.app.platform.db.service.security.UserService;
import com.eyooya.app.web.api.internal.controller.form.UserDetails;

@Controller
public class UserSecurityActionsController {

	@Autowired
	private UserService userService;

	/**
	 * Will be called from Spring ignInController after successful SaaS
	 * authentication.
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public UserDetails userDetails(WebRequest request) {
		Connection<?> connection = ProviderSignInUtils.getConnection(request);
		if (connection != null) {
			return UserDetails.fromProviderUser(connection.fetchUserProfile());
		} else {
			return new UserDetails();
		}
	}

	/**
	 * Will be called after user complete the post-social authentication phase's
	 * form.
	 * 
	 * @param form
	 * @param formBinding
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String socialSignup(UserDetails form, BindingResult formBinding,
			WebRequest request) {
		if (formBinding.hasErrors()) {
			return null;
		}
		// Account account = createAccount(form, formBinding);
		// if (account != null) {
		// SignInUtils.signin(account.getUsername());
		ProviderSignInUtils.handlePostSignUp("itayw", request);
		return "redirect:/";
		// }
		// return null;
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView registerUserAccount(
			@ModelAttribute("userSecurity") @Valid UserDetails userDetails,
			BindingResult formBinding, WebRequest request, Errors errors) {
		if (formBinding.hasErrors()) {
			return null;
		}

		UserSecurity user = userService.registerNewUserAccount(userDetails);

		if (user == null || formBinding.hasErrors()) {
			return new ModelAndView("registrationFailed", "user", userDetails);
		} else {
			return new ModelAndView("registrationSucess", "user", userDetails);
		}

	}
}

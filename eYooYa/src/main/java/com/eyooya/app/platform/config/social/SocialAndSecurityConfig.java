package com.eyooya.app.platform.config.social;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.support.ConnectionFactoryRegistry;
import org.springframework.social.connect.web.ConnectController;
import org.springframework.social.connect.web.ProviderSignInController;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;

import com.eyooya.app.platform.db.repository.UserSocialConnectionRepository;
import com.eyooya.app.platform.db.service.security.prodiver.SpringSecuritySignInAdapter;

@Configuration
public class SocialAndSecurityConfig {
	
   @Inject
    private Environment environment;
   
   @Inject
   private UserSocialConnectionRepository userSocialConnectionRepository;
   
   
   @Value("${social.facebook.appId}") 
   private String facebookAppId;
   
   @Value("${social.facebook.appSecret}") 
   private String facebookAppSecret;
   
   @Bean
   public ConnectionFactoryLocator connectionFactoryLocator() {
       ConnectionFactoryRegistry registry = new ConnectionFactoryRegistry();
       
       registry.addConnectionFactory(new FacebookConnectionFactory(
    		   facebookAppId, facebookAppSecret));
       
       return registry;
   }
   
   @Bean
   @Scope(value="request", proxyMode=ScopedProxyMode.INTERFACES)
   public ConnectionRepository connectionRepository(){
	      Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	       if (authentication == null) {
	           throw new IllegalStateException("Unable to get a ConnectionRepository: no user signed in");
	       }
	       return usersConnectionRepository().createConnectionRepository(authentication.getName());
	   }
   
   @Bean
   public UsersConnectionRepository usersConnectionRepository() {
       MongoUsersConnectionRepository repository = new MongoUsersConnectionRepository(userSocialConnectionRepository,
    		   connectionFactoryLocator(), Encryptors.noOpText());
       return repository;
   }
   
   @Bean
   public ConnectController connectController() {
	   ConnectController controller = new ConnectController(
	            connectionFactoryLocator(), connectionRepository());
	   try {
		controller.afterPropertiesSet();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	      // controller.setApplicationUrl("localhost:8080/app/");
	        return controller;
   }
   
   @Bean
   public ProviderSignInController providerSignInController() {
       ProviderSignInController controller = new ProviderSignInController(connectionFactoryLocator(), 
    		   usersConnectionRepository(), new SpringSecuritySignInAdapter());
       //controller.setApplicationUrl(environment.getProperty("application.url"));
       return controller;
   }
   
   
   

  
   
   

//    @Inject
//    private AuthenticationManager authenticationManager;


    
    
    
    
    
    
    
    

//    @Bean
//    public SocialAuthenticationServiceLocator socialAuthenticationServiceLocator() {
//    	System.out.println("------->>>>>>>>>");
//        SocialAuthenticationServiceRegistry registry = new SocialAuthenticationServiceRegistry();
//
//        //add facebook
//        OAuth2ConnectionFactory<Facebook> facebookConnectionFactory = new FacebookConnectionFactory("944913975521973",
//                "9198047afaa019f3acb040e533a45b64");
//        OAuth2AuthenticationService<Facebook> facebookAuthenticationService = new OAuth2AuthenticationService<Facebook>(facebookConnectionFactory);
//        facebookAuthenticationService.setDefaultScope("");
//        registry.addAuthenticationService(facebookAuthenticationService);
//
//        return registry;
//    }

    /**
     * Singleton data access object providing access to connections across all users.
     */
//    @Bean
//    public UsersConnectionRepository usersConnectionRepository() {
//        MongoUsersConnectionRepository repository = new MongoUsersConnectionRepository(userSocialConnectionRepository,
//                socialAuthenticationServiceLocator(), Encryptors.noOpText());
//        repository.setConnectionSignUp(autoConnectionSignUp());
//        return repository;
//    }


    
    
 
 
//    @Bean
//    public ConnectController connectController() {
//    	ConnectController controller = new ConnectController(socialAuthenticationServiceLocator(), connectionRepository());
//        controller.setApplicationUrl("http://localhost:8080/app/");
//        return controller;
//    }
    
    


//
//    @Bean
//    @Scope(value="request", proxyMode=ScopedProxyMode.INTERFACES)   
//    public Facebook facebook() {
//        Connection<Facebook> facebook = connectionRepository().findPrimaryConnection(Facebook.class);
//        return facebook != null ? facebook.getApi() : new FacebookTemplate("");
//    }
//
//   public ConnectionSignUp autoConnectionSignUp() {
//        return new AutoConnectionSignUp();
//    }


}
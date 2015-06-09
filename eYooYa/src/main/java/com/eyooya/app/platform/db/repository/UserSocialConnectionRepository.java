package com.eyooya.app.platform.db.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


import com.eyooya.app.platform.db.model.social.provider.UserSocialConnection;

@Repository
public interface UserSocialConnectionRepository extends MongoRepository<UserSocialConnection, String>{
    List<UserSocialConnection> findByUserId(String userId);

    List<UserSocialConnection> findByUserIdAndProviderId(String userId, String providerId);

    List<UserSocialConnection> findByProviderIdAndProviderUserId(String providerId, String providerUserId);

    UserSocialConnection findByUserIdAndProviderIdAndProviderUserId(String userId, String providerId, String providerUserId);

    List<UserSocialConnection> findByProviderIdAndProviderUserIdIn(String providerId, Collection<String> providerUserIds);
}

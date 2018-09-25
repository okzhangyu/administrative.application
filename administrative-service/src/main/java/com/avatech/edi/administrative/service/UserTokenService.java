package com.avatech.edi.administrative.service;

import com.avatech.edi.administrative.model.dto.UserToken;
import com.avatech.edi.administrative.repository.IUserTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserTokenService {

    @Autowired
    private IUserTokenRepository userTokenRepository;

    public UserToken fetchUserToken(){
        Iterable<UserToken> tokens = userTokenRepository.findAll();
        if(tokens != null && tokens.iterator().hasNext())
            return tokens.iterator().next();
        else
            return null;
    }

    @Transactional
    public void updateToken(UserToken newToken){
        Optional<UserToken> userTokens =  userTokenRepository.findById(newToken.getId());
        if(userTokens !=null && userTokens.isPresent()){
            UserToken userToken = userTokenRepository.findById(newToken.getId()).get();
            userToken.setExpired(newToken.getExpired());
            userTokenRepository.deleteById(newToken.getId());
        }
        userTokenRepository.save(newToken);
    }
}

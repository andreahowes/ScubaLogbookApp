package com.andreahowes.dive_db.logic.SecurityModule.JWT;

import com.andreahowes.dive_db.data.SecurityData.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyTokenService {

    @Autowired
    private TokenRepository tokenRepository;

    public Token createApiToken(Credentials credentials) {
        Token token = new Token();
        token.setToken(hashCode(credentials));
        return tokenRepository.save(token);
    }
    private String hashCode(Credentials credentials) {
        return String.valueOf(credentials.hashCode());
    }
}

package com.andreahowes.dive_db.logic.SecurityModule.JWT;

import com.andreahowes.dive_db.data.SecurityData.TokenRepository;

public class MyTokenService {

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

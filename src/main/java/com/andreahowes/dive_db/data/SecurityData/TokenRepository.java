package com.andreahowes.dive_db.data.SecurityData;

import com.andreahowes.dive_db.logic.SecurityModule.JWT.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository("tokenRepository")
public interface TokenRepository extends JpaRepository<Token, Integer> {

}

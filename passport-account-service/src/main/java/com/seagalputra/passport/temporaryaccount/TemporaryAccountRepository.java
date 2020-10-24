package com.seagalputra.passport.temporaryaccount;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TemporaryAccountRepository extends CrudRepository<TemporaryAccount, String> {
    Optional<TemporaryAccount> findFirstByEmail(String email);
}

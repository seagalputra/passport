package com.seagalputra.passport.passcode;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PasscodeRepository extends CrudRepository<Passcode, String> {
    Optional<Passcode> findFirstByEmail(String email);
}

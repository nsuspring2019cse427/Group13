package com.cse427.server.Repository;

import com.cse427.server.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> getUserByUserName(String userName);


    @Query("select  u from User u where isActive  = true ")
    List<User> getUserByActiveIsTrue();

}

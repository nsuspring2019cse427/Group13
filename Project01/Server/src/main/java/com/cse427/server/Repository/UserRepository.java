package com.cse427.server.Repository;

import com.cse427.server.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u where userName=?1 and active=?2")
    Optional<User> getUserByUserNameAndActive(String userName, boolean isActive);


    @Query("select  u from User u where isActive  = true ")
    List<User> getUserByActiveIsTrue();

}

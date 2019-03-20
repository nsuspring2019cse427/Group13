package com.cse427.server.Repository;

import com.cse427.server.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    @Query("select u from User u where userName=?1 and active=?2")
    Optional<User> getUserByUserNameAndActive(String userName, boolean isActive);


}

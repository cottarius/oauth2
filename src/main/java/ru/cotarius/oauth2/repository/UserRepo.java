package ru.cotarius.oauth2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.cotarius.oauth2.enity.User;

public interface UserRepo extends JpaRepository<User, Long> {

}

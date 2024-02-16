package com.vinimanfrin.controlador_tarefas.repositories;

import com.vinimanfrin.controlador_tarefas.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    UserDetails findByLogin(String login);
}

package co.user.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import co.user.api.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>{

}

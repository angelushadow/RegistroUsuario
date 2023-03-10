package co.user.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import co.user.api.entities.PhoneEntity;

public interface PhoneRepositoy extends JpaRepository<PhoneEntity, Long>{

}

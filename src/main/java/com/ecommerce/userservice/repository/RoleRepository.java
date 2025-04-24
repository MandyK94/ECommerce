package com.ecommerce.userservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.userservice.model.Role;
import com.ecommerce.userservice.model.RoleType;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

	Optional<Role> findByType(RoleType roleType);
}

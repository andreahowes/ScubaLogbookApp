package com.andreahowes.dive_db.data.SecurityData;

import com.andreahowes.dive_db.logic.SecurityModule.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByRole(String role);


}

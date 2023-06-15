package proyecto.grupo6.authz.repository;
import java.util.List;



import org.springframework.data.repository.CrudRepository;

import proyecto.grupo6.authz.entity.Role;






public interface RoleRepository extends CrudRepository <Role, Long> {

    List<Role> findAll();
    
}

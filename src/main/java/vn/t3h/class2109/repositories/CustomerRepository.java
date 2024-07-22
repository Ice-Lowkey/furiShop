package vn.t3h.class2109.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.t3h.class2109.entities.CustomerEntity;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

}

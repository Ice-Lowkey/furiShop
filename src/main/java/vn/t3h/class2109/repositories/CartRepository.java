package vn.t3h.class2109.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.t3h.class2109.entities.CartEntity;

public interface CartRepository extends JpaRepository<CartEntity, Long> {

}

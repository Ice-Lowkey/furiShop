package vn.t3h.class2109.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.t3h.class2109.entities.ReceiptEntity;

public interface ReceiptRepository extends JpaRepository<ReceiptEntity , Long> {

}

package geek.partners.demo.repository;

import geek.partners.demo.entity.QueueCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QueueCodeRepository extends JpaRepository<QueueCode, Long> {}

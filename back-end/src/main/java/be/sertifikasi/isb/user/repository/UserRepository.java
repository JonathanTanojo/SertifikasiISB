package be.sertifikasi.isb.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAll();
    List<User> findAllById(Long id);

}

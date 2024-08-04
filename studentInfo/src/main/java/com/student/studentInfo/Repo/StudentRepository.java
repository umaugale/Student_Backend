package com.student.studentInfo.Repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import com.student.studentInfo.Entity.StudentsEntity;
import java.util.Optional;


@EnableJpaRepositories
@Repository
public interface StudentRepository extends JpaRepository<StudentsEntity,Integer> {
	
    Optional<StudentsEntity> findOneByEmailAndPassword(String email, String password);
    StudentsEntity findByEmail(String email);

}

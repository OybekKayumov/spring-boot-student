package uz.kors.springstudents.repo_dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.kors.springstudents.model.Student;

//! @Repository     //! auto JpaRepository
public interface StudentRepo extends JpaRepository<Student, Long> {

    void deleteByEmail(String email);

    Student findStudentByEmail(String email);
}

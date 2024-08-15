package uz.kors.springstudents.service;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.kors.springstudents.model.Student;
import uz.kors.springstudents.repo_dao.StudentRepo;

import java.util.List;

@Service
@AllArgsConstructor
@Primary
public class StudentServiceImplRepo implements StudentService {

    private final StudentRepo repository;
    //! constructor here

    @Override
    public List<Student> findAllStudent() {
        return repository.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return repository.save(student);
    }

    @Override
    public Student findStudentByEmail(String email) {
        return repository.findStudentByEmail(email);
    }

    @Override
    public Student updateStudent(Student student) {
        return repository.save(student);
    }

    @Override
    @Transactional
    public void deleteStudent(String email) {
        repository.deleteByEmail(email);
    }
}

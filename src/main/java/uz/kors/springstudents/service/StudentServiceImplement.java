package uz.kors.springstudents.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import uz.kors.springstudents.model.Student;
import uz.kors.springstudents.repo_dao.StudentDao;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentServiceImplement implements StudentService {

    //? заполнение, di через конструктор @AllArgsConstructor
    public final StudentDao repository;

    public List<Student> findAllStudent() {

//        return List.of(
//                Student.builder()
//                        .firstName("John")
//                        .email("john@mail.com")
//                        .age(41)
//                        .build(),
//                Student.builder()
//                        .firstName("Anna")
//                        .email("anna@mail.com")
//                        .age(36)
//                        .build(),
//                Student.builder()
//                        .firstName("Helen")
//                        .email("helen@mail.com")
//                        .age(28)
//                        .build()
//        );

        //? надо вызвать эти методы из DAO
        return repository.findAllStudent();
    }

    @Override
    public Student saveStudent(Student student) {
        return repository.saveStudent(student);
    }

    @Override
    public Student findStudentByEmail(String email) {
        return repository.findStudentByEmail(email);
    }

    @Override
    public Student updateStudent(Student student) {
        return repository.updateStudent(student);
    }

    @Override
    public void deleteStudent(String email) {
        repository.deleteStudent(email);
    }
}

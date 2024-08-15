package uz.kors.springstudents.repo_dao;


//? если надо сохранить что-то в памяти, надо буфер

import org.springframework.stereotype.Repository;
import uz.kors.springstudents.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Repository     //? делаем этот класс BEAN
public class StudentDao {
    //! буфер хранящий спсиок студентов
    private final List<Student> students = new ArrayList<>();

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
        //? return array of Students is enough
        return students;
    }

    public Student saveStudent(Student student) {
        students.add(student);
        return student;
    }


    public Student findStudentByEmail(String email) {
        //? use thread
        return students.stream()
                .filter(student -> student.getEmail().equals(email))
                .findFirst()
                .orElse(null); //*! если нет такого, получаем null
    }

    public Student updateStudent(Student student) {

        //! индекс студента, где почта совпадаетс с почтой студента, который
        // был получен при вызове метода,
        // если не нашли, то храним -1
        var studentInd = IntStream.range(0, students.size())
                .filter(i -> students.get(i).getEmail().equals(student.getEmail()))
                .findFirst()
                .orElse(-1);

        //! если нашли, есть совпадение то заменяем студента
        if (studentInd != -1) {
            students.set(studentInd, student);
            System.out.println("Updated student " + studentInd);
            return student;
        }
        return null;
    }

    public void deleteStudent(String email) {
        var student = findStudentByEmail(email);
        if (student != null) {
            students.remove(student);
        } else {
            System.out.println("Student not found");
        }
    }
}

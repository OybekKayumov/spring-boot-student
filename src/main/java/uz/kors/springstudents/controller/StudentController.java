package uz.kors.springstudents.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.kors.springstudents.model.Student;
import uz.kors.springstudents.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@AllArgsConstructor

//! @ResponseBody - пережает объект к браузеру в json
// каждый метод в контроллере использует @ResponseBody
//? список java объектов стало json массивом
public class StudentController {

    //? spring-boot  не управляет этим объектом, делаем вручную - (new)
//    private StudentService studentService = new StudentService();

    //! внедрение зависимостей
    // 1 - поле  - устаревший
//    @Autowired
//    private StudentService studentService;

    // 2 - через конструктор - новый
    //@AllArgsConstructor или дописать контруктор
    private final StudentService studentService;


    @GetMapping("")
    public List<Student> findAllStudent() {

//        return List.of(
//                Student.builder()
//                        .firstName("John")
//                        .email("john@mail.com")
//                        .age(41)
//                        .build(),
//                Student.builder()
//                        .firstName("Bob")
//                        .email("bob@mail.com")
//                        .age(32)
//                        .build(),
//                Student.builder()
//                        .firstName("Helen")
//                        .email("helen@mail.com")
//                        .age(28)
//                        .build()
//        );

        //todo_
        return studentService.findAllStudent();
    }

    //? внедрение конечные точки в контроллер
    @PostMapping("save_student")
//    public Student saveStudent(@RequestBody Student student) {
    public String saveStudent(@RequestBody Student student) {
//        return studentService.saveStudent(student);
        studentService.saveStudent(student);
        return "Student saved successfully";
    }

    @GetMapping("/{email}")     //!  /api/v1/students/john@mail.com
    public Student findByEmail(@PathVariable("email") String email) {
        return studentService.findStudentByEmail(email);
    }

    @PutMapping("update_student")
    public Student updateStudent(@RequestBody Student student) {
        return studentService.updateStudent(student);
    }

    @DeleteMapping("delete_student/{email}")
    public void deleteStudent(@PathVariable("email") String email) {
        studentService.deleteStudent(email);
    }

}

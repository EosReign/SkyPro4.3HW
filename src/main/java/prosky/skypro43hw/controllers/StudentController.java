package prosky.skypro43hw.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import prosky.skypro43hw.models.Student;
import prosky.skypro43hw.services.StudentService;

import java.util.Collection;


@RestController
@RequestMapping(path = "/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping(path ="/{name}/{age}")// POST https://localhost:8080/students
    public Student createStudent(@PathVariable String name,
                                 @PathVariable int age) {
        return studentService.create(name, age);
    }

    @PostMapping(path = "/{id}")
    public Student readStudent(@PathVariable Long id) {
        return studentService.read(id);
    }

    @PutMapping(path = "/{id}/{name}/{age}")
    public Student updateStudent(@PathVariable Long id,
                                 @PathVariable String name,
                                 @PathVariable int age) {
        return studentService.update(id, name, age);
    }

    @DeleteMapping(path = "/{id}") // DELETE https://localhost:8080/students/23
    public ResponseEntity deleteStudent(@PathVariable Long id) {
        studentService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping(path = "/age/{age}")
    public Collection<Student> filterStudent(@PathVariable int age) {
        return studentService.filterByAge(age);
    }

}

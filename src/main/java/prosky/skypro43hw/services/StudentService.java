package prosky.skypro43hw.services;

import org.springframework.stereotype.Service;
import prosky.skypro43hw.models.Student;
import prosky.skypro43hw.repositories.StudentRepository;

import java.util.*;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student create(String name, int age) {
        Student student = new Student(name, age);
        return studentRepository.save(student);
    }

    public Student read(Long id) {
        return studentRepository.findById(id).get();
    }

    public Student update(Long id, String name, int age) {
        Student student = new Student(id, name, age);
        return studentRepository.save(student);
    }

    public void delete(Long id) {
        studentRepository.deleteById(id);
    }

    public Collection<Student> filterByAge(int age) {
        return studentRepository.findByAge(age);
    }
}

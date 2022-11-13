package prosky.skypro43hw.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import prosky.skypro43hw.models.Faculty;
import prosky.skypro43hw.models.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByAge(int age);
}

package prosky.skypro43hw.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import prosky.skypro43hw.models.Faculty;

import java.util.List;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    List<Faculty> findByColor(String color);
}

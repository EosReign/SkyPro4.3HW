package prosky.skypro43hw.services;

import org.springframework.stereotype.Service;
import prosky.skypro43hw.models.Faculty;
import prosky.skypro43hw.repositories.FacultyRepository;

import java.util.*;

@Service
public class FacultyService {

    private FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty create(String name, String color) {
        Faculty faculty = new Faculty(name, color);
        return facultyRepository.save(faculty);
    }

    public Faculty read(Long id) {
        return facultyRepository.findById(id).get();
    }

    public Faculty update(Long id, String name, String color) {
        Faculty faculty = new Faculty(id, name, color);
        return facultyRepository.save(faculty);
    }

    public void delete(Long id) {
        facultyRepository.deleteById(id);
    }

    public Collection<Faculty> getAll() {
        return facultyRepository.findAll();
    }

    public Collection<Faculty> filterByColor(String color) {
        return facultyRepository.findByColor(color);
    }

}

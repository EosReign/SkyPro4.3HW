package prosky.skypro43hw.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import prosky.skypro43hw.models.Faculty;
import prosky.skypro43hw.services.FacultyService;

import java.util.Collection;


@RestController
@RequestMapping(path = "/faculty")
public class FacultyController {
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @PostMapping(path ="/{name}/{color}")// POST https://localhost:8080/Facultys
    public Faculty createFaculty(@PathVariable String name,
                                 @PathVariable String color) {
        return facultyService.create(name, color);
    }

    @PostMapping(path = "/{id}")// READ
    public Faculty readFaculty(@PathVariable Long id) {
        return facultyService.read(id);
    }

    @PutMapping(path = "/{id}/{name}/{color}") //UPDATE
    public Faculty updateFaculty(@PathVariable Long id,
                                 @PathVariable String name,
                                 @PathVariable String color) {
        return facultyService.update(id, name, color);
    }

    @DeleteMapping(path = "/{id}") // DELETE https://localhost:8080/Facultys/23
    public ResponseEntity deleteFaculty(@PathVariable Long id) {
        facultyService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping(path = "/color/{color}")
    public Collection<Faculty> filterStudent(@PathVariable String color) {
        return facultyService.filterByColor(color);
    }

}

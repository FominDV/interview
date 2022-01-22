package ru.fomin.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.fomin.entities.Student;
import ru.fomin.repositories.StudentRepository;

@Controller
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {

    private final StudentRepository studentRepository;

    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("students", studentRepository.findAll());
        return "students";
    }

    @PostMapping("delete/{id}")
    public String delete(@PathVariable Long id) {
        studentRepository.deleteById(id);
        return "redirect:/";
    }

    @PostMapping
    public String create( String name, int age){
        Student student = Student.builder()
                .name(name)
                .age(age)
                .build();
        studentRepository.save(student);
        return "redirect:/";
    }

}

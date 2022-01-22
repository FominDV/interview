package ru.fomin.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.fomin.entities.Student;
import ru.fomin.repositories.StudentRepository;

import javax.transaction.Transactional;

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
    public String create(String name, Integer age) {
        Student student = Student.builder()
                .name(name)
                .age(age)
                .build();
        studentRepository.save(student);
        return "redirect:/";
    }

    @GetMapping("update/{id}")
    public String getUpdatingStudentPage(@PathVariable Long id, Model model) {
        model.addAttribute("student", studentRepository.getById(id));
        return "update_student";
    }

    @PostMapping("update/{id}")
    @Transactional
    public String update(@PathVariable Long id, String name, Integer age) {
        Student student = studentRepository.getById(id);
        student.setName(name);
        student.setAge(age);
        studentRepository.save(student);
        return "redirect:/";
    }

}

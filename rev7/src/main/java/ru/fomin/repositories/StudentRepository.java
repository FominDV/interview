package ru.fomin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.fomin.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}

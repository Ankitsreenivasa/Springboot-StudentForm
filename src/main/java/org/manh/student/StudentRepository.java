package org.manh.student;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findStudentsByAgeGreaterThan(Integer ageIsGreaterThan);
}

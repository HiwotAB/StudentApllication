package com.hiwotab.studentapplication.repository;

import com.hiwotab.studentapplication.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository  extends CrudRepository<Student, Long> {

}

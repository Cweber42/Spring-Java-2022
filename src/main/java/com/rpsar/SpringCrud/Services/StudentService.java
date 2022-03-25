package com.rpsar.SpringCrud.Services;
import java.util.List;

import com.rpsar.SpringCrud.model.Student;
public interface StudentService {
	List<Student> getAllStudents();
	void saveStudent(Student student);
	Student getStudentById(long id);
	void deleteStudentById(long id);
}

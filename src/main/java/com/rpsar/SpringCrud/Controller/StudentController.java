package com.rpsar.SpringCrud.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.rpsar.SpringCrud.Services.StudentService;
import com.rpsar.SpringCrud.model.Student;

@Controller

public class StudentController {
@Autowired
	private StudentService studentService;
//display list of students
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listStudents",studentService.getAllStudents());
		return "index";
	}
	@GetMapping("/shownewStudentForm")
	public String shownewStudentForm(Model model) {
		//creates new student for manual entry; with ID being auto incremented
		Student student=new Student();
		model.addAttribute("student",student);
		return "new_student";
	}
	@PostMapping("/saveStudent")
	public String saveStudent(@ModelAttribute("student")Student student) {
		//save new student to the database
		studentService.saveStudent(student);
		return "redirect:/" ;
	}
	
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        // get Student from the service.java
        Student student = studentService.getStudentById(id);

        // set Student as a model attribute to pre-populate the form
        model.addAttribute("student", student);
        return "update_student";
    }
    
    @GetMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable(value = "id") long id) {

        // call delete employee method 
        this.studentService.deleteStudentById(id);
        return "redirect:/";
    }
}
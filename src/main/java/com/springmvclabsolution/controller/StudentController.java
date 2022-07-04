package com.springmvclabsolution.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springmvclabsolution.model.Student;
import com.springmvclabsolution.service.StudentService;

import java.util.ArrayList;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
private StudentService studentService;
	
	@RequestMapping("/list")
	public String listStudents(Model theModel)
	{
		List<Student> students = studentService.fetchAllStudents();
		
		theModel.addAttribute("Students", students);
		
		return "List-Students";
		
	}
	
	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel)
	{
		Student student = new Student();
		
		theModel.addAttribute("Student", student);
		
		return "Student-Form";
		
	}
	
	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("studentId") int id , Model theModel)
	{
		Student student = studentService.fetchStudentById(id);
		
		theModel.addAttribute("Student", student);
		
		return "Student-Form";
		
	}
	
	@PostMapping("/save")
	public String saveStudent(@RequestParam("studentId") int id , @RequestParam("studentName") String name, @RequestParam("studentDept") String dept, @RequestParam("studentCountry") String country)
	{
		Student student;
		if(id!=0)
		{
			student= studentService.fetchStudentById(id);
			student.setStudentName(name);
			student.setStudentDept(dept);
			student.setStudentCountry(country);
			
			
		}
		else
		{
			student = new Student(name,dept,country);
			
		}
		
	studentService.saveStudent(student);
	
		
		return "redirect:/student/list";
		
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("studentId") int id , Model theModel)
	{
		 studentService.deleteStudentById(id);
		
		
		
		 return "redirect:/student/list";
		
	}


}

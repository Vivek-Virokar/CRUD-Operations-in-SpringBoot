package com.springboot.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.Service.StudentService;
import com.springboot.entity.Student;



@RestController
@RequestMapping("/student")
public class StudentController {
	
//	private static final Logger Logs=LoggerFactory.getLogger(StudentController.class);
	private static final Logger logs=LoggerFactory.getLogger(StudentController.class);
	
	@Autowired
	private StudentService studentservice;
	
	//1)CREATE
	
	@PostMapping("/save")
 public Student save(@RequestBody Student student)
 {
		logs.info("In saveemployee API>>"+student);
	 Student stud=studentservice.save(student);
	 logs.info("After the completing the service call>>"+stud);
	 return stud;
 }
	
	//2)RETRIEVE
	@GetMapping("/getStudentByRollno/{rollno}")
	public Student getStudentByRollno(@PathVariable int rollno)
	{
		logs.info("Inside a getStudentByRollno method of Controller>>" + rollno);
		Student stud=studentservice.getStudentByRollno(rollno);
		logs.info("Service call completed>>"+stud);
		return stud;
	}
	@GetMapping("/getAllStudents")
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		List<Student> studlist=(List<Student>)studentservice.getAllStudent();
		return studlist;
	
	}
	//3)Update
	@PutMapping("/update/{rollno}")
	public Student updateStudent(@PathVariable int rollno,@RequestBody Student student)
	{
		Student stud1=studentservice.getStudentByRollno(rollno);
		stud1.setName(student.getName());
		stud1.setMobileno(student.getMobileno());
		stud1.setCity(student.getCity());
	    Student stu2=studentservice.save(stud1);
		return stu2;
	}
	//4)Delete
	@DeleteMapping("/delete/{rollno}")
	public void deleteAllById(@PathVariable int rollno) {
		// TODO Auto-generated method stub
		studentservice.deleteByRollno(rollno);
		
	}
	@GetMapping("/getStudentByName/{name}")
	public Student getStudentByName(@PathVariable String name)
	{
		Student student=studentservice.getStudentByName(name);
		return student;
	}
	

}

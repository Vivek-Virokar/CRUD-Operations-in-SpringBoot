package com.springboot.ServiceImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.springboot.Repository.StudentRepository;
import com.springboot.Service.StudentService;

import com.springboot.entity.Student;
@Service
public class StudentServiceImpl implements StudentService{
	private static final Logger logs =  LoggerFactory.getLogger(StudentService.class);

	@Autowired
	private StudentRepository repository;
	@Override
	public Student save(Student student) {
		// TODO Auto-generated method stub
		logs.info("Inside a saveStudent method of Service class>>" +student);
		Student stud=repository.save(student);
		return stud; 
	}

	@Override
	public Student getStudentByRollno( int rollno) {
		logs.info("Inside a getStudentByRollno method of Service class>>" +rollno);
		// TODO Auto-generated method stub
		Student student=repository.findByRollno(rollno);
		logs.info("repo call is completed>>" +student);
		return student;
		
	}

	@Override
	public void deleteByRollno(int rollno) {
		// TODO Auto-generated method stub
		repository.deleteById(rollno);
		
	}

	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		List<Student> studlist=(List<Student>) repository.findAll();
		return studlist;
	}

	@Override
	public Student getStudentByName(String name) {
		
		Student student=repository.findByName(name);
		return student;
	}
	
	

}

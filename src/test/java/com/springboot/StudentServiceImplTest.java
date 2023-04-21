package com.springboot;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.springboot.Repository.StudentRepository;
import com.springboot.ServiceImpl.StudentServiceImpl;
import com.springboot.entity.Student;
import java.util.ArrayList;
import java.util.Iterator;
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class StudentServiceImplTest {

	@InjectMocks
	private StudentServiceImpl studentservice;
	@Mock
	private StudentRepository repository;
	@Test
	 public void getAllStudentTest()
	{
		List<Student> studentlist=new ArrayList();
		studentlist.add(new Student(1,"Vivek","Shegaon","9322032401"));
		studentlist.add(new Student(2,"Vaishnavi","Shegaon","8999723316"));
		when(repository.findAll()).thenReturn(studentlist);
		List<Student> list=studentservice.getAllStudent();
		assertEquals(studentlist,list);
		
		
	}
	@Test
	public void saveTest()
	{
		Student student=new Student(101,"Suraj","Amravati","9322032401");
		when(repository.save(student)).thenReturn(student);
		Student actualstudent=studentservice.save(student);
		assertEquals(student,actualstudent);
	}
	@Test
	public void getStudentByRollnoTest()
	{
		Student student=new Student(105,"Neha","Baramati","7654389021");
		when(repository.findByRollno(105)).thenReturn(student);
		Student actualstudent=studentservice.getStudentByRollno(105);
		assertEquals("Neha",actualstudent.getName());
	}
	@Test
	public void getStudentByName()
	{
		Student student=new Student(109,"Shubham","Amravati","9178564321");
		when(repository.findByName("Shubham")).thenReturn(student);
		Student actualstudent=studentservice.getStudentByName("Shubham");
		assertEquals(109,actualstudent.getRollno());
	}
	
	
	
	

}

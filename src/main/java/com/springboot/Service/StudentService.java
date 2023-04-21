package com.springboot.Service;


import java.util.List;


import com.springboot.entity.Student;

public interface StudentService {
	
	public Student save(Student student);
	public Student getStudentByRollno(int rollno);
    public void deleteByRollno(int rollno);
    public List<Student> getAllStudent();
    public Student getStudentByName(String name);
}

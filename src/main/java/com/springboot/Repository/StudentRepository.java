package com.springboot.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.entity.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student,Integer>
{
	
	public Student findByRollno(Integer rollno);
	public Student findByName(String name);

}

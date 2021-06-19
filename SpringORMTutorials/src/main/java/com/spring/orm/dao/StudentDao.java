package com.spring.orm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.orm.entities.Student;

public class StudentDao {

	private HibernateTemplate hibernateTemplate;
	
	//save method
	@Transactional
	public int insert(Student student)
	{
	Integer i=(Integer)this.hibernateTemplate.save(student);	
		return i;
	}

	//get the single data
	
	public Student getStudent(int id)
	{
		Student student=this.hibernateTemplate.get(Student.class, id);
		return student;
	}
	
//	get all student(all row)
	public List<Student> getAllStudent()
	{
		List<Student> student=this.hibernateTemplate.loadAll(Student.class);
	return student;
	}
	//deleting thye data
	@Transactional
	public void deleteStudent(int id)
	{
	Student student=	this.hibernateTemplate.get(Student.class, id);
	this.hibernateTemplate.delete(student);
	}
	
	//updating data
	@Transactional
	public void updateStudent(Student student)
	{
		this.hibernateTemplate.update(student);
	}
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	
}

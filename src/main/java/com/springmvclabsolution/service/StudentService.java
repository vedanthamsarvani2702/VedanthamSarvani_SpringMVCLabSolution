package com.springmvclabsolution.service;

import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.springmvclabsolution.model.Student;
@Repository
public class StudentService {
	private SessionFactory sessionFactory;
	private Session session;
	
	@Autowired
	public StudentService(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}
		
	}
	
	@Transactional
	public List<Student> fetchAllStudents()
	{
		Transaction tx =session.beginTransaction();
		List<Student> students = session.createQuery("from Student").list();
		tx.commit();
		
		return students;
		
		
	}
	@Transactional
	public Student fetchStudentById(int id)
	{
		Transaction tx =session.beginTransaction();
		Student student = new Student();
		student = session.get(Student.class, id);
		tx.commit();
		
		return student;
		
		
	}
	
	@Transactional
	public void saveStudent(Student student)
	{
		Transaction tx =session.beginTransaction();
		session.saveOrUpdate(student);
		tx.commit();
	
		
		
	}
	@Transactional
	public void deleteStudentById(int id)
	{
		Transaction tx =session.beginTransaction();
		Student student = new Student();
	 student= session.get(Student.class, id);
		session.delete(student);
		tx.commit();
		
	
		
		
	}
	


}

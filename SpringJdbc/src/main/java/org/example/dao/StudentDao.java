package org.example.dao;

import org.example.entities.Student;

import java.util.List;

public interface StudentDao {
    public int insert(Student student);
    public int update(Student student);
    public int delete(int sid);
    public Student getStudent(int sid);
    public List<Student> getAll();
}

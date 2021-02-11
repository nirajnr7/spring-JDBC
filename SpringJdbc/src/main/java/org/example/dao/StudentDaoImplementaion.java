package org.example.dao;

import org.example.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("studentDao")
public class StudentDaoImplementaion implements StudentDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int update(Student student) {
        String q="update student set name=?, city=? where id=?;";
        int r=jdbcTemplate.update(q,student.getName(),student.getCity(),student.getId());
        return r;
    }

    @Override
    public int delete(int sid) {
        String q="delete from student where id=?;";
        int r=jdbcTemplate.update(q,sid);
        return r;
    }

    @Override
    public Student getStudent(int sid) {
        String q="select * from student where id=?";
        RowMapper<Student> rowMapper=new RowMapperImplement();
        return jdbcTemplate.queryForObject(q,rowMapper,sid);

    }

    @Override
    public List<Student> getAll() {
        String q="select * from student";
        RowMapper<Student> rowMapper=new RowMapperImplement();
        List<Student> r=jdbcTemplate.query(q,rowMapper);
        return r;
    }

    @Override
    public int insert(Student student) {
        String q="insert into student(id,name,city) values(?,?,?);";
        int r=jdbcTemplate.update(q,student.getId(),student.getName(),student.getCity());
        return r;
    }


}

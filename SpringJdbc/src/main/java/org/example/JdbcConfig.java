package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan({"org.example.dao"})
public class JdbcConfig {

    @Bean("ds")
    public DriverManagerDataSource getDataSource(){
        DriverManagerDataSource ds=new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/youtube?useSSL=false");
        ds.setUsername("root");
        ds.setPassword("Niraj@nr7");
        return ds;
    }

    @Bean("jdbcTemplate")
    public JdbcTemplate getTemplate(){
        JdbcTemplate jdbcTemplate=new JdbcTemplate();
        jdbcTemplate.setDataSource(getDataSource());
        return jdbcTemplate;
    }

//    @Bean("studentDao")
//    public StudentDao getStudent(){
//        StudentDaoImplementaion studentDao=new StudentDaoImplementaion();
//        studentDao.setJdbcTemplate(getTemplate());
//        return studentDao;
//
//    }



}

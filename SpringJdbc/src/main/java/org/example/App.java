package org.example;

import org.example.dao.StudentDao;
import org.example.entities.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
//        ApplicationContext con=new ClassPathXmlApplicationContext("config.xml");

        //______________________________________________________________

        ApplicationContext con=new AnnotationConfigApplicationContext(JdbcConfig.class);


        //_______________________________________________________________

//        JdbcTemplate temp=con.getBean("JdbcTemplate", JdbcTemplate.class);
//        String q="insert into student(id,name,city) values(?,?,?);";
//        int r=jdbcTemplate.update(q,student.getId(),student.getName(),student.getCity());

        StudentDao studentDao=con.getBean("studentDao", StudentDao.class);

        Student student=new Student();
        student.setId(111);
        student.setName("pain");
        student.setCity("aakutski");

        //insert
//        int x=studentDao.insert(student);
//        System.out.println("inserted"+x);

//        update
//        int y= studentDao.update(student);
//        System.out.println(y +"upadted");



//        DElecte
//        int y= studentDao.delete(2);
//        System.out.println(y +"upadted");

        //single id return ;
        Student s=studentDao.getStudent(1);
        System.out.println(s);

        //returning alll
        List<Student> list=studentDao.getAll();
        System.out.println(list);





    }
}

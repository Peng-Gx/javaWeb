package mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws SQLException, FileNotFoundException {
//        jdbcFun();
        mybatisFun();
    }

    public static void jdbcFun() throws SQLException {
        String url="jdbc:mysql://localhost:3306/study";
        String root="root";
        String password="";

        DriverManager.setLogWriter(new PrintWriter(System.out));
        Connection c=DriverManager.getConnection(url,root,password);
        Statement s=c.createStatement();

        ResultSet set=s.executeQuery("select * from student;");
        while(set.next()){
            System.out.println(set.getString(1));
        }
    }

    public static void mybatisFun() throws FileNotFoundException {
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        SqlSessionFactory factory=builder.build(new FileInputStream("mybatis-config.xml"));
        SqlSession session=factory.openSession();

//        List<Student> students=session.selectList("selectStudent");
//        for(int i=0;i<students.size();i++){
//            System.out.println(students.get(i).toString());
//        }

        Mapper mapper=session.getMapper(Mapper.class);
        List<Student> students=mapper.selectStudent();
        for(int i=0;i<students.size();i++){
            System.out.println(students.get(i).toString());
        }

        List<Map> maps=mapper.selectStudentToMap();
        for(int i=0;i<maps.size();i++){
            System.out.println(maps.get(i));
        }
    }
}

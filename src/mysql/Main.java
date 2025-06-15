package mysql;

import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        DriverManager.setLogWriter(new PrintWriter(System.out));

        try(Connection connection= DriverManager
                .getConnection("jdbc:mysql://localhost:3306/study","root","");
            Statement statement=connection.createStatement();
            Statement statement1=connection.createStatement();){

            ResultSet set =statement.executeQuery("select * from student");
//            statement.close();
            ResultSet set1 =statement1.executeQuery("select * from student");
            System.out.println(set);
            System.out.println(set1);

            while(set.next()){
                Student s=myConvert(set,Student.class);
                System.out.println(s.getInfo());
            }
        }


        Class clazz= Student.class;

        Constructor<?>[] list=clazz.getConstructors();
        for(int i=0;i<list.length;i++){
            System.out.println("构造方法 "+list[i].getName()+" "+list[i].getParameterCount());
        }

        Method[] methods=clazz.getMethods();
        for(int i=0;i<methods.length;i++){
            System.out.println("对象方法 "+methods[i].getName()+" "+methods[i].getParameterCount());
        }
    }

    private static <T> T myConvert(ResultSet set, Class<T> clazz) throws NoSuchMethodException, SQLException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<T>[] constructors= (Constructor<T>[]) clazz.getConstructors();
        Constructor<T> constructor=clazz.getConstructor(constructors[0].getParameterTypes());


        Class<?>[] paramTypes=constructor.getParameterTypes();
        Object[] params=new Object[paramTypes.length];

        for(int i=0;i<paramTypes.length;i++){
//            params[i]=paramTypes[i].cast(set.getObject(i+1));
            params[i]=set.getObject(i+1);
        }

        return constructor.newInstance(params);
    }

//    private static <T> T convert(ResultSet set, Class<T> clazz){
//        try {
//            Constructor<T> constructor = clazz.getConstructor(clazz.getConstructors()[0].getParameterTypes());   //默认获取第一个构造方法
//            Class<?>[] param = constructor.getParameterTypes();  //获取参数列表
//            for(int i=0;i<param.length;i++){
//                System.out.print(param[i]+" ");
//            }
//            System.out.println();
//            Object[] object = new Object[param.length];  //存放参数
//            for (int i = 0; i < param.length; i++) {   //是从1开始的
//
//                object[i] = set.getObject(i+1);
//                System.out.print(object[i].getClass()+" ");
////                if(object[i].getClass() != param[i])
////                    throw new SQLException("错误的类型转换："+object[i].getClass()+" -> "+param[i]);
//            }
//            System.out.println();
//            return constructor.newInstance(object);
//        } catch (ReflectiveOperationException | SQLException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
}

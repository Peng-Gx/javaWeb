package lombok;

import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
//        Student s=new Student();
//        Class<?> clazz=s.getClass();

        Class<?> clazz= Student.class;

//        Method[] methods=clazz.getMethods();
        Method[] methods=clazz.getDeclaredMethods();
        for(int i=0;i<methods.length;i++){
            System.out.println(methods[i].getName());
            System.out.print("参数列表");
            for(int j=0;j<methods[i].getParameterCount();j++){
                System.out.print(" "+methods[i].getParameterTypes()[j].getTypeName());
            }
            System.out.println();
        }
    }
}

package mysql;

import jdk.nashorn.internal.runtime.regexp.joni.ast.StringNode;

public class Student {
    private int stu_id;
    private String name;
    private String sex;

    public Student(int i,String n,String s){
        stu_id=i;
        name=n;
        sex=s;
    }

    public String getInfo(){
        return name+" "+sex+" "+stu_id;
    }
}

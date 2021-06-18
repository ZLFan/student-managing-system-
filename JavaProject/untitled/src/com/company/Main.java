package com.company;
class Student
{
    //private static Object name;
    int id;
    String name;
}
class Header extends Student
{
    int group;
}
public class Main {

    public static void main(String[] args) {
	// write your code here
        Student s=new Student();
        s.id=1;
        s.name="zs";
        System.out.println(s.id+" "+s.name);
    }
}

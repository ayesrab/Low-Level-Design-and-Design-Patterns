package Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Student {
    int age;
    String name;

    Student(int age,String name){
        this.age = age;
        this.name = name;
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(14,"asfaf"));
        students.add(new Student(67,"bfsd"));
        students.add(new Student(23,"cash"));

        Collections.sort(students,(i,j) -> i.name.compareTo(j.name));
        for(Student student:students){
            System.out.println(student.age + " " + student.name);
        }

    }
}

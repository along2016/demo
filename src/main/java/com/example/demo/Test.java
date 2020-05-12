package com.example.demo;

import com.example.demo.Vo.Student;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        initStudents(studentList);

        printStudentList(studentList);
        List<Student> paidStudents = listPaid(studentList, 90);
        printStudentList(paidStudents);
        printStudentList(studentList);
        System.out.println("---------------------");
        List<Student> paidStudents1 = listPaid(studentList, 10);
        printStudentList(paidStudents1);
        printStudentList(studentList);
        System.out.println("---------------------");
        List<Student> paidStudents2 = listPaid(studentList, 50);
        printStudentList(paidStudents2);
        printStudentList(studentList);
    }

    private static void initStudents(List<Student> studentList){
        Student cash = new Student("现金", 5);
        Student bankcard = new Student("银行卡", 100);
        Student alipay = new Student("支付宝", 30);
        studentList.add(cash);
        studentList.add(bankcard);
        studentList.add(alipay);
    }

    private static List<Student> listPaid(List<Student> studentList, int payAmount){
        List<Student> paidStudents = new ArrayList<>();
        int size = studentList.size();
        for(int i = 0; i < size; i++){
            Student student = studentList.get(0);
            if(payAmount > student.getAge()){
                paidStudents.add(student);
                studentList.remove(student);
                payAmount = payAmount - student.getAge();
            } else if(payAmount == student.getAge()){
                paidStudents.add(student);
                studentList.remove(student);
                break;
            } else {
                student.setAge(student.getAge() - payAmount);
                Student paidStudent = new Student();
                BeanUtils.copyProperties(student, paidStudent);
                paidStudent.setAge(payAmount);
                paidStudents.add(paidStudent);
                break;
            }
        }
        return paidStudents;
    }

    private static void printStudentList(List<Student> students){
        students.stream().forEach(s -> System.out.println(s));
        System.out.println("==========================");
    }

}

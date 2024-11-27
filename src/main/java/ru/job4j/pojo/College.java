package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Ivanov Ivan");
        student.setGroup(1);
        student.setAdmission(new Date());
        System.out.println(student.getFullName() + " : студент группы " + student.getGroup() + ", дата поступления - " + student.getAdmission());
    }
}

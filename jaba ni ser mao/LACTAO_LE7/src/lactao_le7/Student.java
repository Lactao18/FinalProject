/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lactao_le7;

/**
 *
 * @author Rainier
 */
public class Student extends Person {
    private double grade;

    public Student(String name, int age, char gender, double grade) {
        super(name, age, gender);
        this.grade = grade;
    }

    public double getGrade() { return grade; }

    public void printInfo() {
        System.out.println("Student:");
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Gender: " + getGender());
        System.out.println("Grade: " + getGrade());
        System.out.println();
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lactao_le7;

/**
 *
 * @author Rainier
 */
public class Teacher extends Person {
    private double salary;

    public Teacher(String name, int age, char gender, double salary) {
        super(name, age, gender);
        this.salary = salary;
    }

    public double getSalary() { return salary; }

    public void printInfo() {
        System.out.println("Teacher:");
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Gender: " + getGender());
        System.out.println("Salary: " + getSalary());
        System.out.println();
    }
}
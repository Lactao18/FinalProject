/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lactao_le7;

/**
 *
 * @author Rainier
 */
public class LACTAO_LE7 {
    public static void main(String[] args) {
        Student s1 = new Student("Juan", 18, 'M', 1.75);
        Student s2 = new Student("Rachel", 15, 'F', 2.50);
        Teacher t1 = new Teacher("Mr. Cruz", 40, 'M', 35000);

        s1.printInfo();
        s2.printInfo();
        t1.printInfo();

        Time t1time = new Time(10, 30);
        Time t2time = new Time(9, 45);
        TimeComparison compare = new TimeComparison();

        System.out.println("t1 > t2? " + compare.isGreater(t1time, t2time));
        System.out.println("t1 < t2? " + compare.isLess(t1time, t2time));
        System.out.println("t1 == t2? " + compare.isEqual(t1time, t2time));
    }
}
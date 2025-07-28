/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lactao_le7;

/**
 *
 * @author Rainier
 */
public class TimeComparison implements Comparison {

    @Override
    public boolean isGreater(Time t1, Time t2) {
        if (t1.getHour() > t2.getHour()) return true;
        if (t1.getHour() == t2.getHour()) return t1.getMinute() > t2.getMinute();
        return false;
    }

    @Override
    public boolean isLess(Time t1, Time t2) {
        if (t1.getHour() < t2.getHour()) return true;
        if (t1.getHour() == t2.getHour()) return t1.getMinute() < t2.getMinute();
        return false;
    }

    @Override
    public boolean isEqual(Time t1, Time t2) {
        return t1.getHour() == t2.getHour() && t1.getMinute() == t2.getMinute();
    }
}
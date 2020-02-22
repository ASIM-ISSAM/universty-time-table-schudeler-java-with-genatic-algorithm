/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.util.ArrayList;


/**
 *
 * @author Assim
 */
public class Course {
    private String number = null ;
    private String name = null ;
    private int hour = 0;
    private int maxNumberOfStudent;
    private ArrayList<Instructor> instructors;

    public Course(String number, String name, int hour, int maxNumberOfStudent, ArrayList<Instructor> instructors) {
        this.number = number;
        this.name = name;
        this.hour = hour;
        this.maxNumberOfStudent = maxNumberOfStudent;
        this.instructors = instructors;
    }

    public int getHour() {
        return hour;
    }
    
    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public int getMaxNumberOfStudent() {
        return maxNumberOfStudent;
    }

    public ArrayList<Instructor> getInstructors() {
        return instructors;
    }

    @Override
    public String toString() {
        return name;
    }
    
    
    
}

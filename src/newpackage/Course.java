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
    //private int criditHour = 0;
    private int maxNumberOfStudent;
    private ArrayList<Instructor> instructors;

    public Course(String number, String name, int maxNumberOfStudent, ArrayList<Instructor> instructors) {
        this.number = number;
        this.name = name;
        this.maxNumberOfStudent = maxNumberOfStudent;
        this.instructors = instructors;
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

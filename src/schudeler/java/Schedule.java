/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schudeler.java;

import java.util.ArrayList;
import newpackage.Department;
import newpackage.Class;

/**
 *
 * @author Assim
 */
public class Schedule {

    private ArrayList<Class> classes;
    private boolean isFitnessChanged = false;
    private double fitness = -1;
    private int classNumb = 0; 
    private int numbOfConflicts = 0;
    private Data data;

    public Data getData() {
        return data;
    }

    public Schedule(Data data) {
        this.data = data;
        classes = new ArrayList<Class>(data.getNumberOfClasses());
    }

    public Schedule initialize() {
        new ArrayList<Department>(data.getDepts()).forEach(dept -> {
            dept.getCourses().forEach(course -> {
                Class newClass = new Class(classNumb++, dept, course);
                newClass.setMeetingTime(data.getMeetingTimes().get((int) (data.getMeetingTimes().size() * Math.random())));
                newClass.setRoom(data.getRooms().get((int) (data.getRooms().size() * Math.random())));
                newClass.setInstructor(data.getInstructors().get((int) (data.getInstructors().size() * Math.random())));
                classes.add(newClass);
            });
        });
        return this;
    }

    public int getNumbOfConflicts() {
        return numbOfConflicts;
    }

    public ArrayList<Class> getClasses() {
        isFitnessChanged = true;
        return classes;
    }

    public double getFitness() {
        if (isFitnessChanged == false) {
            fitness = calculateFitness();
            isFitnessChanged = true;
        }
        return fitness;
    }

    private double calculateFitness() {
        numbOfConflicts = 0;
        classes.forEach(x -> {
            if (x.getRoom().getSeatingCapacity() < x.getCourse().getMaxNumberOfStudent()) {
                numbOfConflicts++;
            }
            classes.stream().filter(y -> classes.indexOf(y) >= classes.indexOf(x)).forEach(y -> {
                if (x.getMeetingTime() == y.getMeetingTime() && x.getId() != y.getId()) {
                    if (x.getRoom() == y.getRoom()) {
                        numbOfConflicts++;
                    }
                    if (x.getInstructor() == y.getInstructor()) {
                        numbOfConflicts++;
                    }
                }
            });
        });
        return 1 / (double) (numbOfConflicts + 1);
    }

    @Override
    public String toString() {
        String returnValue = new String();
        for (int x = 0; x < classes.size(); x++) {
            returnValue += classes.get(x) + ",";
        }
        return returnValue;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schudeler.java;

import java.util.ArrayList;  
import java.util.Arrays;
import newpackage.Course;
import newpackage.Department;
import newpackage.Instructor;
import newpackage.MeetingTime;
import newpackage.Room;

/**
 *
 * @author Assim
 */
public class Data {

    private ArrayList<Room> rooms;
    private ArrayList<Instructor> instructors;
    private ArrayList<Course> courses;
    private ArrayList<Department> depts;
    private ArrayList<MeetingTime> meetingTimes;
    private int numberOfClasses = 0;

    public Data() {
        initialise();
    }

    private Data initialise() {
        Room room1 = new Room("room1", 500);
        Room room2 = new Room("room2", 500);
        Room room3 = new Room("room2", 500);
        Room room4 = new Room("room3", 500);
        Room room5 = new Room("room4", 500);
        rooms = new ArrayList<Room>(Arrays.asList(room1,room2,room3,room4,room5));

        MeetingTime meetingTime1 = new MeetingTime("MT1", "08:00 - 09:00");
        MeetingTime meetingTime2 = new MeetingTime("MT2", "09:00 - 10:00");
        MeetingTime meetingTime3 = new MeetingTime("MT3", "10:00 - 11:00");
        MeetingTime meetingTime4 = new MeetingTime("MT4", "11:00 - 12:00");
        MeetingTime meetingTime5 = new MeetingTime("MT5", "12:00 - 01:00");
        MeetingTime meetingTime6 = new MeetingTime("MT6", "01:00 - 02:00");
        MeetingTime meetingTime7 = new MeetingTime("MT7", "02:00 - 03:00");
        MeetingTime meetingTime8 = new MeetingTime("MT8", "03:00 - 04:00");
        MeetingTime meetingTime9 = new MeetingTime("MT9", "04:00 - 05:00");
        MeetingTime meetingTime10 = new MeetingTime("MT10", "05:00 - 06:00");
        meetingTimes = new ArrayList<MeetingTime>(Arrays.asList(meetingTime1,meetingTime2,meetingTime3,meetingTime4,meetingTime5));

        Instructor instructor1 = new Instructor("I1", "Dr instractor 1");
        Instructor instructor2 = new Instructor("I2", "Dr instractor 2");
        Instructor instructor3 = new Instructor("I3", "Dr instractor 3");
        Instructor instructor4 = new Instructor("I4", "Dr instractor 4");
        Instructor instructor5 = new Instructor("I5", "Dr instractor 5");
        instructors = new ArrayList<Instructor>(Arrays.asList(instructor1,instructor2,instructor3,instructor4,instructor5));

        Course course1 = new Course("comp 101", "cs1", 500, new ArrayList<Instructor>(Arrays.asList(instructor1)));
        Course course2 = new Course("comp 102", "cs2", 500, new ArrayList<Instructor>(Arrays.asList(instructor2)));
        Course course3 = new Course("comp 103", "cs3", 500, new ArrayList<Instructor>(Arrays.asList(instructor3)));
        Course course4 = new Course("comp 104", "cs4", 500, new ArrayList<Instructor>(Arrays.asList(instructor4)));
        Course course5 = new Course("comp 105", "cs5", 500, new ArrayList<Instructor>(Arrays.asList(instructor5)));
        courses = new ArrayList<Course>(Arrays.asList(course1,course2,course3,course4,course5));

        Department dept1 = new Department("computer science1", new ArrayList<Course>(Arrays.asList(course1)));
        Department dept2 = new Department("computer science2", new ArrayList<Course>(Arrays.asList(course2)));
        Department dept3 = new Department("computer science3", new ArrayList<Course>(Arrays.asList(course3)));
        Department dept4 = new Department("computer science4", new ArrayList<Course>(Arrays.asList(course4)));
        Department dept5 = new Department("computer science5", new ArrayList<Course>(Arrays.asList(course5)));
        depts = new ArrayList<Department>(Arrays.asList(dept1,dept2,dept3,dept4,dept5));

        depts.forEach(x -> numberOfClasses += x.getCourses().size());

        return this;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public ArrayList<Instructor> getInstructors() {
        return instructors;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public ArrayList<Department> getDepts() {
        return depts;
    }

    public ArrayList<MeetingTime> getMeetingTimes() {
        return meetingTimes;
    }

    public int getNumberOfClasses() {
        return numberOfClasses;
    }

}

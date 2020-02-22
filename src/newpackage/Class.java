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
public class Class {
    
    private int id;
    private Department dept;
    private Course course;
    private Instructor instructor;
    private Room room;
    private ArrayList<MeetingTime> meetingTime;

    public Class(int id, Department dept, Course course) {
        this.id = id;
        this.dept = dept;
        this.course = course;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public int getId() {
        return id;
    }

    public Department getDept() {
        return dept;
    }

    public Course getCourse() {
        return course;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public Room getRoom() {
        return room;
    }
    
    public ArrayList<MeetingTime> getMeetingTime() {
        return meetingTime;
    }
    
    public void setMeetingTime(ArrayList<MeetingTime> meetingTime) {
        this.meetingTime = meetingTime;
    }

    @Override
    public String toString() {
        return "Class{" + "id=" + id + ", dept=" + dept + ", course=" + course + ", instructor=" + instructor + ", meetingTime=" + meetingTime + ", room=" + room + '}';
    }  
}

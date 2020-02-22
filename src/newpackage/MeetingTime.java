/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

/**
 *
 * @author Assim
 */
public class MeetingTime {
 
    private String id;
    private int start;
    private int day;

    public MeetingTime(int day, int start) {
        this.id = "(d:"+day+" , h:"+start+") ";
        this.start = start ;
        this.day = day;
    }

    public String getId() {
        return id;
    }

    public int getStart() {
        return start;
    }

    public int getDay() {
        return day;
    }

    @Override
    public String toString() {
        return "MeetingTime{" + "id=" + id + ", start=" + start + ", day=" + day + '}';
    }
}

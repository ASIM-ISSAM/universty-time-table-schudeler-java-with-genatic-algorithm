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
    private String time;

    public MeetingTime(String id, String time) {
        this.id = id;
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public String getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "MeetingTime{" + "id=" + id + ", time=" + time + '}';
    }
    
    
    
}
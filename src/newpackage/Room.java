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
public class Room {
    
    private String number;
    private int seatingCapacity;
    private ArrayList<MeetingTime> avTimes;

    public Room(String number, int seatingCapacity, ArrayList<MeetingTime> avTimes) {
        this.number = number;
        this.seatingCapacity = seatingCapacity;
        this.avTimes = avTimes;
    }

    public String getNumber() {
        return number;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }
    
    public ArrayList<ArrayList<MeetingTime>> getMeetingTimes(int slotHours) {
       ArrayList<ArrayList<MeetingTime>> hoursAvTime = new ArrayList() ;
       ArrayList<MeetingTime> slots = new ArrayList();
       for(int i=0; i<avTimes.size(); i++)
       {
           for(int j=i; j<i+slotHours && i+slotHours<avTimes.size() ; j++)
           {
               if(avTimes.get(i).getDay() == avTimes.get(j).getDay())
               {
                   slots.add(avTimes.get(j));
               }
               else
               {
                   slots = new ArrayList();
                   break;
               }
           }
           if(slots.size() == slotHours)
           {
                hoursAvTime.add(slots);
           }
           slots = new ArrayList();
       }
       return hoursAvTime;
    }
    
    public void setAvTimes(ArrayList<MeetingTime> avTimes) {
        this.avTimes = avTimes;
    }
    
    public void removeMeetingTime(ArrayList<MeetingTime> mT)
    {
        avTimes.removeAll(mT);
    }
    
    @Override
    public String toString() {
        return "Room{" + "number=" + number + ", seatingCapacity=" + seatingCapacity + '}';
    }
    
    
    
}

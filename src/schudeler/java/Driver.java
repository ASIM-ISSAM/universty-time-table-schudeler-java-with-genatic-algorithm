/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schudeler.java;

import java.util.ArrayList;
import java.util.Collections;
import newpackage.Class;

/**
 *
 * @author Assim
 */
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static final int POPULATION_SIZE = 10;
    public static final double MUTATION_RATE = 0.1;
    public static final double CROSSOVER_RATE = 0.9;
    public static final int TOURNAMENT_SELECTION_SIZE = 3;
    public static final int NUMB_OF_ELITE_SCHEDULES = 2;
    private int scheduleNumb = 1;
    private int classNumb = 1;
    private Data data;

    public static void main(String[] args) {
        // TODO code application logic here

        Driver driver = new Driver();
        driver.data = new Data();
        int generationNumber = 1;
        driver.printAvailableData();

        GenaticAlgorithm geneticAlgorithm = new GenaticAlgorithm((driver.data));
        Population population = new Population(Driver.POPULATION_SIZE, driver.data).sortByFitnes();
        do { // if the no of student is too large, this code will not stop ( you need to divide the students to many  rooms)
            driver.scheduleNumb = 1;
            driver.classNumb = 1;
            System.out.println("> Generation : " + generationNumber++);
            System.out.println("schedule :         | classes [dept,class,room,instractor,meeting-time]   | fitness | conflicts");
            System.out.println("----------------------------------------------------------------------------------------------");
            population = new Population(Driver.POPULATION_SIZE, driver.data).sortByFitnes();
            population.getSchedules().forEach(schedule -> System.out.println("           " + driver.scheduleNumb++ + "       | " + schedule + " | " + String.format("%.5f", schedule.getFitness()) + " | " + schedule.getNumbOfConflicts()));
            if (population.getSchedules().get(0).getFitness() == 1.0) 
            {
                driver.printScheduleAsTable(population.getSchedules().get(0), generationNumber);
            }
        } while (population.getSchedules().get(0).getFitness() != 1.0);
    }

    private void printScheduleAsTable(Schedule schedule, int generation) {
        ArrayList<Class> classes = schedule.getClasses();
        System.out.print("\n                          ");
        System.out.println("Class# | dept | course (number, max #of students) | room(capacity) | instructor(id)  | meeting-time(id)");
        System.out.print("              ");
        System.out.print("----------------------------------");
        System.out.println("----------------------------------------------");
        classes.forEach(x -> {
            int majorIndex = data.getDepts().indexOf(x.getDept());
            int coursesIndex = data.getCourses().indexOf(x.getCourse());
            int roomIndex = data.getRooms().indexOf(x.getRoom());
            int instructorIndex = data.getInstructors().indexOf(x.getInstructor());
            int meetingTimeIndex = data.getMeetingTimes().indexOf(x.getMeetingTime());
            System.out.print("                         ");
            System.out.print(String.format("%1$02d", classNumb) + " | ");
            System.out.print(String.format("%1$4s", data.getDepts().get(majorIndex).getName()) + " | ");
            System.out.print(String.format("%1$21s", data.getCourses().get(coursesIndex).getName()) + " ( " + data.getCourses().get(coursesIndex).getNumber() + " , " + x.getCourse().getMaxNumberOfStudent() + ")                 |");
            System.out.print(String.format("%1$10s", data.getRooms().get(roomIndex).getNumber()) + " ( " + x.getRoom().getSeatingCapacity() + " ) | ");
            System.out.print(String.format("%1$15s", data.getInstructors().get(instructorIndex).getName()) + " ( " + x.getInstructor().getId() + " ) | ");
            System.out.print(data.getMeetingTimes().get(meetingTimeIndex).getTime() + " ( " + data.getMeetingTimes().get(meetingTimeIndex).getId() + " ) | ");
            classNumb++;
        });
        System.out.println("> solution found in " + (generation + 1) + " generations");
        System.out.print("----------------------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------------------------");

    }

    private void printAvailableData() {
        System.out.println("Avaliable Department");
        data.getDepts().forEach(x -> System.out.println("name: " + x.getName() + ", courses: " + x.getCourses()));
        System.out.println("\nAvilable Courses ==>");
        data.getCourses().forEach(x -> System.out.println("course #: " + x.getNumber() + ", name: " + x.getName() + ", max # of student: " + x.getMaxNumberOfStudent() + ", instructor: " + x.getInstructors()));
        System.out.println("\nAvailable rooms ==>");
        data.getRooms().forEach(x -> System.out.println("room #: " + x.getNumber() + " ,max seating capacity: " + x.getSeatingCapacity()));
        System.out.println("\nAvailable instructors ==>");
        data.getInstructors().forEach(x -> System.out.println("id #: " + x.getId() + " ,name: " + x.getName()));
        System.out.println("\nAvailable meeting time ==>");
        data.getMeetingTimes().forEach(x -> System.out.println("id #: " + x.getId() + " ,time: " + x.getTime()));
        System.out.print("----------------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------------");
    }

}

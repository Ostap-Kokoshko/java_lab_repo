package ua.lviv.iot.algo.part1.lab1;

import lombok.Setter;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Stadium {
    final static int ONE_HUNDRED_PEOPLE_TO_EXPEL = 100;
    private String name;
    private int capacity;
    private int currentAttendance;
    private String homeTeam;
    private String awayTeam;

    private static Stadium instance;

    public static Stadium getInstance() {
        if (instance == null) {
            return new Stadium();
        }
        return instance;
    }

    public void addAttendies(int count) {
        var newAttendance = currentAttendance + count;
        if (newAttendance > capacity) {
            System.out.println("The stadium is full!");
            return;
        }
        currentAttendance = newAttendance;
    }

    public void decreaseAttendance() {
        if (currentAttendance >= ONE_HUNDRED_PEOPLE_TO_EXPEL) {
            currentAttendance -= ONE_HUNDRED_PEOPLE_TO_EXPEL;
        } else {
            System.out.println("There is no attendees left to remove!");
        }
    }

    public void changeHomeTeam(String teamName) {
        this.homeTeam = teamName;
    }

    public void changeAwayTeam(String teamName) {
        this.awayTeam = teamName;
    }

    public static void main(String[] args) {
        Stadium[] stadiums = new Stadium[4];

        //Create object by @NoArgsConstructor from lombok
        stadiums[0] = new Stadium();

        //Create object by @AllArgsConstructor from lombok
        stadiums[1] = new Stadium(" Arena Lviv", 35000, 100, " Shahtar", " Carpatian");

        //Create 2 objects by method getInstance
        stadiums[2] = getInstance();
        stadiums[2].setName(" Olympic");
        stadiums[2].setCapacity(70000);
        stadiums[2].setCurrentAttendance(10000);
        stadiums[2].setHomeTeam(" Shahtar");
        stadiums[2].setAwayTeam(" Henk");

        stadiums[3] = getInstance();
        stadiums[3].setName(" Ukraine");
        stadiums[3].setCapacity(28000);
        stadiums[3].setCurrentAttendance(3000);
        stadiums[3].setHomeTeam(" Dynamo");
        stadiums[3].setAwayTeam(" FK Zahid");

        //Create a loop with a precondition to output all stadiums data
        for (int index = 0; index < stadiums.length; index++) {
            System.out.println("Stadium " + (index + 1) + ": " + stadiums[index].toString());
        }
    }
}
package org.example;

import java.util.Scanner;

public class NewsPaperData {

    private String newsPaperName;
    private String weekDay;
    private double cost;

    public NewsPaperData(String newsPaperName, String weekDay, double cost) {
        this.newsPaperName = newsPaperName;
        this.weekDay = weekDay;
        this.cost = cost;
    }

    public String getNewsPaperName() {
        return newsPaperName;
    }

    public String getWeekDay() {
        return weekDay;
    }

    public double getCost() {
        return cost;
    }
}

class NewsPaper {
    public void addData(Scanner sc, BudgetCalculate bg) {
        System.out.println("name: ");
        String n = sc.nextLine();
        System.out.println("day: ");
        String d = sc.nextLine();
        System.out.println("cost: ");
        double c = sc.nextDouble();
        sc.nextLine(); 
        NewsPaperData nd = new NewsPaperData(n, d, c);
        bg.data.add(nd);
    }
}



package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BudgetCalculate {

    List<NewsPaperData> data = new ArrayList<>();
    HashMap<String, Double> toi = new HashMap<>();
    HashMap<String, Double> hindu = new HashMap<>();
    HashMap<String, Double> et = new HashMap<>();
    HashMap<String, Double> bm = new HashMap<>();
    HashMap<String, Double> ht = new HashMap<>();

    public void populateHashMaps() {
        for (NewsPaperData newspaper : data) {
            String name = newspaper.getNewsPaperName();
            double cost = newspaper.getCost();

            if (name.equalsIgnoreCase("toi")) {
                toi.put(newspaper.getWeekDay(), cost);
            } else if (name.equalsIgnoreCase("hindu")) {
                hindu.put(newspaper.getWeekDay(), cost);
            } else if (name.equalsIgnoreCase("et")) {
                et.put(newspaper.getWeekDay(), cost);
            } else if (name.equalsIgnoreCase("bm")) {
                bm.put(newspaper.getWeekDay(), cost);
            } else if (name.equalsIgnoreCase("ht")) {
                ht.put(newspaper.getWeekDay(), cost);
            }
        }
    }

    public void printNewspaperData(String newspaperName) {
        populateHashMaps();
    
        HashMap<String, Double> newspaperData = null;
    
        if (newspaperName.equalsIgnoreCase("toi")) {
            newspaperData = toi;
        } else if (newspaperName.equalsIgnoreCase("hindu")) {
            newspaperData = hindu;
        } else if (newspaperName.equalsIgnoreCase("et")) {
            newspaperData = et;
        } else if (newspaperName.equalsIgnoreCase("bm")) {
            newspaperData = bm;
        } else if (newspaperName.equalsIgnoreCase("ht")) {
            newspaperData = ht;
        } else {
            System.out.println("Newspaper with name '" + newspaperName + "' not found.");
            return;
        }
    
        System.out.println(newspaperName.toUpperCase() + ":");
        for (String day : newspaperData.keySet()) {
            System.out.println("Day: " + day + ", Cost: " + newspaperData.get(day));
        }
    }

    public List<String> findNewspaperCombinationWithinBudget(double weeklyBudget) {
        populateHashMaps();

        List<String> affordableNewspapers = new ArrayList<>();
        Map<String, Double> newspaperPrices = new HashMap<>();
        newspaperPrices.put("toi", calculateTotalCost(toi));
        newspaperPrices.put("hindu", calculateTotalCost(hindu));
        newspaperPrices.put("et", calculateTotalCost(et));
        newspaperPrices.put("bm", calculateTotalCost(bm));
        newspaperPrices.put("ht", calculateTotalCost(ht));

        for (String newspaper : newspaperPrices.keySet()) {
            if (newspaperPrices.get(newspaper) <= weeklyBudget) {
                affordableNewspapers.add(newspaper);
            }
        }

        return affordableNewspapers;
    }

    private double calculateTotalCost(Map<String, Double> newspaperData) {
        double totalCost = 0;
        for (double cost : newspaperData.values()) {
            totalCost += cost;
        }
        return totalCost;
    }
    
    
    
}

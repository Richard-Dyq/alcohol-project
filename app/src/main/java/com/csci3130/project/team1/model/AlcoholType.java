package com.csci3130.project.team1.model;

import java.util.ArrayList;
import java.util.List;

public class AlcoholType {
    private static final AlcoholType instance = new AlcoholType();
    public List<String> types = new ArrayList<>();

    public static AlcoholType getInstance() {
        return instance;
    }

    private AlcoholType() {
        types.add("Beer");
        types.add("Wine");
        types.add("Icewine");
        types.add("Noble rot wines");
        types.add("Fortified Wine");
        types.add("Sherry");
        types.add("Port wine");
        types.add("Sparkling wine");
        types.add("Champagne");
        types.add("Chinese rice wines");
        types.add("Sake");
        types.add("Chinese spirits");
        types.add("Brandy");
        types.add("Whisky");
        types.add("Vodka");
        types.add("Gin");
        types.add("Liquor");
    }
}

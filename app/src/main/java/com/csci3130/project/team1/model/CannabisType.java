package com.csci3130.project.team1.model;

import java.util.ArrayList;
import java.util.List;

public class CannabisType {
    public static final CannabisType ourInstance = new CannabisType();
    public List<String > allTypes = new ArrayList<>();

    static CannabisType getInstance() {
        return ourInstance;
    }

    private CannabisType() {
        allTypes.add("Indica");
        allTypes.add("Sativa");
        allTypes.add("Hybrid");
    }
}

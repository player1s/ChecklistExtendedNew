package com.example.checklistextended;

import java.util.ArrayList;

public class conceptModel {
    boolean isActive;
    String name;
    String definition;
    String glossary;
    ArrayList<conceptModel> childElements;
    String plans;
    ArrayList<conceptModel> parentElements;
    String purpose;
    int id;
    //associatedWith:
    //ArrayList<conceptModel> associatedWith;


    public conceptModel(boolean isActive, String name, String definition, String glossary, ArrayList<conceptModel> childElements, String plans, ArrayList<conceptModel> parentElements, String purpose, int id) {
        this.isActive = isActive;
        this.name = name;
        this.definition = definition;
        this.glossary = glossary;
        this.childElements = childElements;
        this.plans = plans;
        this.parentElements = parentElements;
        this.purpose = purpose;
        this.id = id;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getGlossary() {
        return glossary;
    }

    public void setGlossary(String glossary) {
        this.glossary = glossary;
    }

    public ArrayList<conceptModel> getChildElements() {
        return childElements;
    }

    public void setChildElements(ArrayList<conceptModel> childElements) {
        this.childElements = childElements;
    }

    public String getPlans() {
        return plans;
    }

    public void setPlans(String plans) {
        this.plans = plans;
    }

    public ArrayList<conceptModel> getParentElements() {
        return parentElements;
    }

    public void setParentElements(ArrayList<conceptModel> parentElements) {
        this.parentElements = parentElements;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

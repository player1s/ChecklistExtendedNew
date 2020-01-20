package com.example.checklistextended;

import java.io.Serializable;
import java.util.ArrayList;

public class conceptModel implements Serializable {

    int id;
    boolean isActive;
    String name;
    String definition;
    String glossary;
    String thingsItsBuiltOf;
    String plans;
    String uses;
    String purpose;
    ArrayList<conceptModel> childElements;
    ArrayList<conceptModel> parentElements;
    ArrayList<conceptModel> associatedWith;
    long coordx;
    long coordy;
    String fireBaseId;
    String docStoredIn;

    public conceptModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getThingsItsBuiltOf() {
        return thingsItsBuiltOf;
    }

    public void setThingsItsBuiltOf(String thingsItsBuiltOf) {
        this.thingsItsBuiltOf = thingsItsBuiltOf;
    }

    public String getPlans() {
        return plans;
    }

    public void setPlans(String plans) {
        this.plans = plans;
    }

    public String getUses() {
        return uses;
    }

    public void setUses(String uses) {
        this.uses = uses;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public ArrayList<conceptModel> getChildElements() {
        return childElements;
    }

    public void setChildElements(ArrayList<conceptModel> childElements) {
        this.childElements = childElements;
    }

    public ArrayList<conceptModel> getParentElements() {
        return parentElements;
    }

    public void setParentElements(ArrayList<conceptModel> parentElements) {
        this.parentElements = parentElements;
    }

    public ArrayList<conceptModel> getAssociatedWith() {
        return associatedWith;
    }

    public void setAssociatedWith(ArrayList<conceptModel> associatedWith) {
        this.associatedWith = associatedWith;
    }

    public long getCoordx() {
        return coordx;
    }

    public void setCoordx(long coordx) {
        this.coordx = coordx;
    }

    public long getCoordy() {
        return coordy;
    }

    public void setCoordy(long coordy) {
        this.coordy = coordy;
    }

    public String getFireBaseId() {
        return fireBaseId;
    }

    public void setFireBaseId(String fireBaseId) {
        this.fireBaseId = fireBaseId;
    }

    public String getDocStoredIn() {
        return docStoredIn;
    }

    public void setDocStoredIn(String docStoredIn) {
        this.docStoredIn = docStoredIn;
    }
}



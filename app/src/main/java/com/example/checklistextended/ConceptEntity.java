package com.example.checklistextended;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

    @Entity
    public class ConceptEntity {
        @PrimaryKey
        @NonNull
        public String uid;
/*
        @ColumnInfo(name = "conceptModel")
        public conceptModel conceptModel;
        */

        @ColumnInfo(name = "name")
        public String name;

        @ColumnInfo(name = "definition")
        public String definition;

        @ColumnInfo(name = "glossary")
        public String glossary;

        @ColumnInfo(name = "thingsitsbuiltof")
        public String thingsitsbuiltof;

        @ColumnInfo(name = "plans")
        public String plans;

        @ColumnInfo(name = "uses")
        public String uses;

        @ColumnInfo(name = "purpose")
        public String purpose;

        @ColumnInfo(name = "coordx")
        public String coordx;

        @ColumnInfo(name = "coordy")
        public String coordy;
    }

/*
 conceptModel.setName((String)document.get("name"));
                        conceptModel.setDefinition((String)document.get("definition"));
                        conceptModel.setGlossary((String)document.get("glossary"));
                        conceptModel.setThingsItsBuiltOf((String)document.get("thingsitsbuiltof"));
                        conceptModel.setPlans((String)document.get("plans"));
                        conceptModel.setUses((String)document.get("uses"));
                        conceptModel.setPurpose((String)document.get("purpose"));
                        conceptModel.setCoordx((long)document.get("coordx"));
                        conceptModel.setCoordy((long)document.get("coordy"));
                        conceptModel.setFireBaseId(document.getId());
 */
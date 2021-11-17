package com.hotmail.kalebmarc.textfighter.main;

public class Property {

    private String name;
    private String description;
    private Type type;
    private int pricePerSquareFoot;
    private int levelNeeded;
    private final int MAX_SQ_FT = 100;//TODO Change this later. Not sure how the SqFt thing is going to work yet.

    private int squareFeetOwned;

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setDesc(String description){
        this.description = description;
    }
    public String getDescription(){
        return this.description;
    }
    public void setType(Type type){
        this.type = type;
    }
    public Type getType(){
        return this.type;
    }
    public void setPricePerSquareFoot(int pricePerSquareFoot){
        this.pricePerSquareFoot = pricePerSquareFoot;
    }
    public int getPricePerSquareFoot(){
        return this.pricePerSquareFoot;
    }
    public void setLevelNeeded(int levelNeeded){
        this.levelNeeded = levelNeeded;
    }
    public int getLevelNeeded(){
        return this.levelNeeded;
    }
    public void setSquareFeetOwned(int squareFeetOwned){
        if (squareFeetOwned > MAX_SQ_FT){
            this.squareFeetOwned = MAX_SQ_FT;
        } else {
            this.squareFeetOwned = squareFeetOwned;
        }
    }
    public int getSquareFeetOwned(){
        return this.squareFeetOwned;
    }
    public static void buyProperty(){

    }

    public enum Type{
        CROP_FIELD,
        ORCHARD,
        RIVER;

        @Override
        public String toString() {
            switch(super.toString()){
                case "CROP_FIELD":
                    return "Crop Field";
                case "ORCHARD":
                    return "Orchard";
                case "RIVER":
                    return "River";
                default:
                    Handle.error("Unknown Property Type: " + super.toString());
                    return null;
            }
        }
    }
}


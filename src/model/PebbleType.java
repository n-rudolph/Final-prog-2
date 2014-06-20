package model;

/**
 * Created by rudolpha on 08/06/2014.
 */
public enum PebbleType {
    WHITE("white"), BLACK("black"), EMPTY("empty");

    private String color;

    private PebbleType(String color) {
       this.color=color;
    }

    public String getColor(){
        return color;
    }
}

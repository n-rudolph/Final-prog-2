package model;

/**
 * Created by rudolpha on 08/06/2014.
 */
public class Pebble {
    private PebbleType pebbleType;

    public Pebble( PebbleType type){
        pebbleType=type;
    }

    public PebbleType getPebbleType(){
        return pebbleType;
    }

}

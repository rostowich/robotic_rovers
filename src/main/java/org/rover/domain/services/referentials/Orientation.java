package org.rover.domain.services.referentials;

public enum Orientation {

    NORTH ("N",0,1,"W","E"),
    SOUTH("S",0,-1,"E","W"),
    EAST("E",1,0,"N","S"),
    WEST("W",-1,0,"S","N");

    private final String value;

    private final int xMovement;

    private final int yMovement;

    private final String leftOrientation;

    private final String rightOrientation;

    public String getValue() {
        return value;
    }

    public int getxMovement() {
        return xMovement;
    }

    public int getyMovement() {
        return yMovement;
    }

    public String getLeftOrientation() {
        return leftOrientation;
    }

    public String getRightOrientation() {
        return rightOrientation;
    }

    Orientation(String value, int xMovement, int yMovement, String leftOrientation, String rightOrientation) {
        this.value = value;
        this.xMovement = xMovement;
        this.yMovement = yMovement;
        this.leftOrientation = leftOrientation;
        this.rightOrientation = rightOrientation;
    }

    public static Orientation orientationByValue (String value){
        for (Orientation orientation : Orientation.values()){
            if (orientation.getValue().equals(value)){
                return orientation;
            }
        }
        return null;
    }
}

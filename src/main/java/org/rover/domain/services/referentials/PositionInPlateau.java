package org.rover.domain.services.referentials;

public class PositionInPlateau {

    private Position currentPosition;

    private Plateau plateau;

    public PositionInPlateau(Position currentPosition, Plateau plateau) {
        this.currentPosition = currentPosition;
        this.plateau = plateau;
    }

    public Position getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(Position currentPosition) {
        this.currentPosition = currentPosition;
    }

    public Plateau getPlateau() {
        return plateau;
    }

    public void setPlateau(Plateau plateau) {
        this.plateau = plateau;
    }
}

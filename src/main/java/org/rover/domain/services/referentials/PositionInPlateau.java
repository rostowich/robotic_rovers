package org.rover.domain.services.referentials;

public class PositionInPlateau {

    private final Plateau plateau;

    private final Position position;

    public PositionInPlateau(Plateau plateau, Position position) {
        this.plateau = plateau;
        this.position = position;
    }

    public Plateau getPlateau() {
        return plateau;
    }

    public Position getPosition() {
        return position;
    }
}

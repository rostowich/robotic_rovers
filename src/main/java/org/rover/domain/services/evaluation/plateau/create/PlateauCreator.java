package org.rover.domain.services.evaluation.plateau.create;

import org.rover.domain.services.referentials.Plateau;

public class PlateauCreator {

    public Plateau init(int length, int width){
        return new Plateau(length, width);
    }
}

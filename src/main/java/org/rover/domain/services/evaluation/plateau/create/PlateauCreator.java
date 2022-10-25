package org.rover.domain.services.evaluation.plateau.create;

import org.rover.domain.services.referentials.Plateau;

import java.util.Arrays;
import java.util.List;

public class PlateauCreator {

    public Plateau init(String command){

        List<String> commandSplit = Arrays.asList(command.split(" "));
        int length = Integer.parseInt(commandSplit.get(0));
        int width = Integer.parseInt(commandSplit.get(1));
        return new Plateau(length, width);
    }
}

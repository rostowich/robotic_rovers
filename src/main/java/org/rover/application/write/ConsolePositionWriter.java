package org.rover.application.write;

import org.rover.domain.services.referentials.Position;

import java.util.List;

public class ConsolePositionWriter implements PositionWriter{
    private static final String SEPARATOR = " ";

    @Override
    public void display(List<Position> positions) {
        positions.forEach(position -> System.out.println(format(position)));
    }

    private String format(Position position){
        return String.format("%s%s%s%s%s", position.getX(), SEPARATOR, position.getY(), SEPARATOR, position.getOrientation().getValue());
    }
}
